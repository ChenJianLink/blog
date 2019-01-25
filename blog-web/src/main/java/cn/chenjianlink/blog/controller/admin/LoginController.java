package cn.chenjianlink.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录Controller
 */
@Controller
public class LoginController {

    @RequestMapping("/admin/admin-login")
    public String showLoginPage() {
        return "admin/login";
    }

    @RequestMapping("/admin/blogger/login")
    public String login(){
        return "redirect:admin-index.html";
    }
}
