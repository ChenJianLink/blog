package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.pojo.BlogType;
import cn.chenjianlink.blog.service.BlogTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台jsp页面跳转显示Controller
 */
@Controller
public class ForwordController {

    @Resource
    private BlogTypeService blogTypeService;

    @RequestMapping("/admin/{page}")
    public String forwordPage(@PathVariable String page, Model model) throws Exception {
        //判断是否为写日志的页面,是则向页面添加日志类别
        if (page.equals("writeBlog") || page.equals("modifyBlog")) {
            //向添加日志类别
            List<BlogType> blogTypeCountList = blogTypeService.getBlogTypeCountList();
            model.addAttribute("blogTypeCountList", blogTypeCountList);
        }
        return "/admin/" + page;
    }

    //后台首页展示
    @RequestMapping("/admin/blogger/admin-index")
    public String adminIndex() {
        return "admin/main";
    }
}
