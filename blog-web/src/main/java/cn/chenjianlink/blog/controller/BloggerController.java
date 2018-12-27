package cn.chenjianlink.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 查看博主信息Controller
 */
@Controller
public class BloggerController {

    @RequestMapping("/blogger/aboutMe")
    public String aboutMe(Model model){
        model.addAttribute("mainPage", "foreground/blogger/info.jsp");
        model.addAttribute("pageTitle", "关于博主-局外人之个人空间");
        return "mainTemp";
    }

}
