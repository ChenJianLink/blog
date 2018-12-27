package cn.chenjianlink.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台首面controller
 */
@Controller
public class AdminIdexController {

    @RequestMapping("/admin/admin-index")
    public String adminIndex(){
        return "admin/main";
    }
}
