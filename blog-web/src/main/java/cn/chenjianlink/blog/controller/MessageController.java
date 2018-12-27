package cn.chenjianlink.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 留言板块Controller
 */
@Controller
public class MessageController {
    //留言板展示
    @RequestMapping("/message/leavemessages")
    public String messageboard(Model model){
        model.addAttribute("mainPage", "foreground/message/messagesboard.jsp");
        model.addAttribute("pageTitle", "游客留言-局外人之个人空间");
        return "mainTemp";
    }
}
