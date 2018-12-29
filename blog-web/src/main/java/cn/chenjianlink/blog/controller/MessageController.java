package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.pojo.Link;
import cn.chenjianlink.blog.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 留言板块Controller
 */
@Controller
public class MessageController {

    @Resource
    private LinkService linkService;

    //留言板展示
    @RequestMapping("/message/leavemessages")
    public String messageboard(Model model) throws Exception{
        model.addAttribute("mainPage", "foreground/message/messagesboard.jsp");
        model.addAttribute("pageTitle", "游客留言-局外人之个人空间");
        List<Link> linkList = linkService.getLinkList();
        model.addAttribute("linkList", linkList);
        return "mainTemp";
    }
}
