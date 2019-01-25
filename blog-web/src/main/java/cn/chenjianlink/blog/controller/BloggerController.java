package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.pojo.Blogger;
import cn.chenjianlink.blog.pojo.Link;
import cn.chenjianlink.blog.service.BloggerService;
import cn.chenjianlink.blog.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查看博主信息Controller
 */
@Controller
public class BloggerController {

    @Resource
    private LinkService linkService;
    @Resource
    private BloggerService bloggerService;

    /**
     * "关于博主"页面展示
     *
     * @param model
     * @return
     */
    @RequestMapping("/blogger/aboutMe")
    public String aboutMe(Model model) throws Exception {
        Blogger blogger = bloggerService.showBlogger();
        model.addAttribute("blogger", blogger);
        model.addAttribute("mainPage", "foreground/blogger/info.jsp");
        model.addAttribute("pageTitle", "关于博主-局外人之个人空间");
        List<Link> linkList = linkService.getLinkList();
        model.addAttribute("linkList", linkList);
        return "mainTemp";
    }

}
