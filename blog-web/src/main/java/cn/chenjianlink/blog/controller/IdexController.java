package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.pojo.Blogger;
import cn.chenjianlink.blog.pojo.Link;
import cn.chenjianlink.blog.service.BloggerService;
import cn.chenjianlink.blog.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


/**
 * 博客首页展示controller
 */
@Controller
public class IdexController {

    @Resource
    private LinkService linkService;
    @Resource
    private BloggerService bloggerService;

    //首页展示
    @RequestMapping("/index")
    public String index(Model model) throws Exception {
        Blogger blogger = bloggerService.showBlogger();
        model.addAttribute("blogger", blogger);
        model.addAttribute("pageTitle", "局外人之个人空间");
        model.addAttribute("mainPage", "foreground/blog/list.jsp");
        List<Link> linkList = linkService.getLinkList();
        model.addAttribute("linkList", linkList);
        return "mainTemp";
    }

}