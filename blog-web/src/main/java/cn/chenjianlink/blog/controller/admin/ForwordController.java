package cn.chenjianlink.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台jsp页面跳转显示Controller
 */
@Controller
public class ForwordController {
    @RequestMapping("/admin/{page}")
    public String forwordPage(@PathVariable String page) {
        return "/admin/" + page;
    }
}
