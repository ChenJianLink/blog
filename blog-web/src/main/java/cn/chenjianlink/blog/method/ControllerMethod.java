package cn.chenjianlink.blog.method;

import cn.chenjianlink.blog.pojo.Blog;
import cn.chenjianlink.blog.pojo.BlogType;
import cn.chenjianlink.blog.pojo.Blogger;
import cn.chenjianlink.blog.pojo.Link;
import cn.chenjianlink.blog.service.BlogService;
import cn.chenjianlink.blog.service.BlogTypeService;
import cn.chenjianlink.blog.service.BloggerService;
import cn.chenjianlink.blog.service.LinkService;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 封装Controller中多次使用的功能代码
 */
public class ControllerMethod {
    @Resource
    private LinkService linkService;
    @Resource
    private BloggerService bloggerService;
    @Resource
    private BlogTypeService blogTypeService;
    @Resource
    private BlogService blogService;

    //显示主页的友情链接，博主信息，日志分类的代码
    public void showMainTemp(Model model) throws Exception {
        //博主信息查询
        Blogger blogger = bloggerService.findBlogger();
        model.addAttribute("blogger", blogger);
        //友情链接查询
        List<Link> linkList = linkService.getLinkList();
        model.addAttribute("linkList", linkList);
        //博客类型查询
        List<BlogType> blogTypeList = blogTypeService.getBlogTypeCountList();
        model.addAttribute("blogTypeCountList", blogTypeList);
        //根据发布日期查询
        List<Blog> blogList = blogService.findBlogDateList();
        model.addAttribute("blogCountList", blogList);
    }

    //获取请求的url,与分页信息相关
    public String getUrl(HttpServletRequest request) {
        String contextPath = request.getContextPath();//获取项目名
        String servletPath = request.getServletPath();//获取servlet
        String queryString = request.getQueryString();//获取问号后的参数
        //判断参数是否为空
        if (queryString != null) {
            //判断参数部分是否带page
            if (queryString.contains("&page=")) {
                int index = queryString.lastIndexOf("&page=");
                queryString = queryString.substring(0, index);
            }
        } else {
            //设置为空串
            queryString = "";
        }
        //url拼接
        return contextPath + servletPath + "?" + queryString;
    }
}
