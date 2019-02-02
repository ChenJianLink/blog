package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.common.pojo.PageResult;
import cn.chenjianlink.blog.method.MainTempMethod;
import cn.chenjianlink.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * 博客首页展示controller
 */
@Controller
public class IdexController {

    @Resource
    private MainTempMethod mainTempMethod;
    @Resource
    private BlogService blogService;

    //首页展示
    @RequestMapping("/index")
    public String index(Model model, @RequestParam(value = "typeId", required = false) Integer typeId, @RequestParam(value = "releaseDateStr", required = false) String releaseDateStr, @RequestParam(value = "page", required = false) Integer page, HttpServletRequest request) throws Exception {
        //判断page是否为空,为空则设置为1
        if (page == null) {
            page = 1;
        }
        //将传入的日期以及博客类别封装到map中
        Map<String, Object> blogMap = new HashMap<>();
        blogMap.put("typeId", typeId);
        blogMap.put("releaseDateStr", releaseDateStr);
        //查询
        PageResult pageResult = blogService.findBlogList(page, blogMap);
        //获取请求的url，将URL截取并封装到结果中
        String url = getUrl(request);
        pageResult.setUrl(url);
        mainTempMethod.showMainTemp(model);
        model.addAttribute("blogList", pageResult.getPageList());
        model.addAttribute("page", pageResult);
        model.addAttribute("pageTitle", "局外人之个人空间");
        model.addAttribute("mainPage", "foreground/blog/list.jsp");
        return "mainTemp";
    }

    //获取请求的url
    private String getUrl(HttpServletRequest request) {
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
            //url拼接
            return contextPath + servletPath + "?" + queryString;
        }
        return contextPath + servletPath + "?";

    }

}