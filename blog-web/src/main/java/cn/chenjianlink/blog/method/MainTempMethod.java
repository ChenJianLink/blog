package cn.chenjianlink.blog.method;

import cn.chenjianlink.blog.pojo.Blogger;
import cn.chenjianlink.blog.pojo.Link;
import cn.chenjianlink.blog.service.BloggerService;
import cn.chenjianlink.blog.service.LinkService;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * 封装页面展示时的重复代码
 */
public class MainTempMethod {
    @Resource
    private LinkService linkService;
    @Resource
    private BloggerService bloggerService;

    //显示友情链接，博主信息，日志分类的代码
    public void showMainTemp(Model model) throws Exception {
        //博主信息查询
        Blogger blogger = bloggerService.showBlogger();
        model.addAttribute("blogger", blogger);
        //友情链接查询
        List<Link> linkList = linkService.getLinkList();
        model.addAttribute("linkList", linkList);
    }
}
