package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.method.ControllerMethod;
import cn.chenjianlink.blog.pojo.Message;
import cn.chenjianlink.blog.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 留言板块Controller
 */
@Controller
public class MessageController {

    @Resource
    private ControllerMethod controllerMethod;
    @Resource
    private MessageService messageService;

    //留言板展示
    @RequestMapping("/message/leavemessages")
    public String showMessageboard(Model model) throws Exception {
        List<Message> messageList = messageService.findMessageList();
        model.addAttribute("messageList", messageList);
        model.addAttribute("mainPage", "foreground/message/messagesboard.jsp");
        model.addAttribute("pageTitle", "游客留言-局外人之秘境");
        controllerMethod.showMainTemp(model);
        return "mainTemp";
    }

    //留言
    @RequestMapping(value = "/message/save", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult leaveMessage(Message message, @RequestParam(value = "imageCode", required = true) String imageCode, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            String sRand = (String) session.getAttribute("sRand");
            //判断验证码的正确性
            if (sRand == null || !sRand.equals(imageCode)) {
                return BlogResult.showError("验证码不正确");
            }
            String userIp = request.getRemoteAddr();
            message.setUserIp(userIp);
            BlogResult result = messageService.addMessage(message);
            return result;
        } catch (Exception e) {
            return BlogResult.showError("留言失败");
        }

    }
}
