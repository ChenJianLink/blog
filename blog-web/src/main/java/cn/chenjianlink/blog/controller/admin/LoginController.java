package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.pojo.Blogger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录Controller
 */
@Controller
public class LoginController {

    @RequestMapping("/admin/admin-login")
    public String showLoginPage() {
        return "admin/login";
    }

    @Value("${SESSIONTIMEOUT}")
    private long SESSIONTIMEOUT;

    //登录
    @RequestMapping(value = "/admin/blogger/login")
    public String login(Blogger blogger, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(), blogger.getPassword());
        try {
            subject.login(token);
            subject.getSession().setTimeout(SESSIONTIMEOUT);
            return "redirect:admin-index.html";
        } catch (Exception e) {
            request.setAttribute("errorInfo", "用户名或密码错误");
            return "admin/login";
        }

    }
}
