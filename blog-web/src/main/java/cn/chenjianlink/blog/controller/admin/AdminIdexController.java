package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.pojo.Blogger;
import cn.chenjianlink.blog.service.BloggerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 后台首面controller
 */
@Controller
public class AdminIdexController {

    @Resource
    private BloggerService bloggerService;

    @RequestMapping("/admin/blogger/admin-index")
    public String adminIndex(Model model) throws Exception {
        Blogger blogger = bloggerService.showBloggerAll();
        model.addAttribute("currentUser", blogger);
        return "admin/main";
    }
}
