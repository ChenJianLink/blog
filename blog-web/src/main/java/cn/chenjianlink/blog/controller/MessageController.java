package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.method.ControllerMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


/**
 * 留言板块Controller
 */
@Controller
public class MessageController {

    @Resource
    private ControllerMethod controllerMethod;

    //留言板展示
    @RequestMapping("/message/leavemessages")
    public String messageboard(Model model) throws Exception {
        model.addAttribute("mainPage", "foreground/message/messagesboard.jsp");
        model.addAttribute("pageTitle", "游客留言-局外人之秘境");
        controllerMethod.showMainTemp(model);
        return "mainTemp";
    }
}
