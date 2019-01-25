package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.pojo.Blogger;
import cn.chenjianlink.blog.service.BloggerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 博主信息管理Controller
 */
@Controller
public class BloggerManageController {
    @Resource
    private BloggerService bloggerService;

    //修改用户信息页面对用户信息进行回显
    @RequestMapping(value = "/admin/blogger/find", method = RequestMethod.POST)
    @ResponseBody
    public Blogger findBloggerInfo() throws Exception {
        Blogger blogger = bloggerService.showBloggerAll();
        return blogger;
    }
}
