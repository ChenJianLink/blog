package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.common.utils.EasyUIResult;
import cn.chenjianlink.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客管理Controller
 */
@Controller
public class BlogManageController {

    @Resource
    private BlogService blogService;

    //展示博客列表
    @RequestMapping(value = "/admin/blog/list", method = RequestMethod.POST)
    @ResponseBody
    public EasyUIResult getBlogList(String title, Integer page, Integer rows) throws Exception {
        EasyUIResult blogList = blogService.findBlogList(page, rows);
        return blogList;
    }
}
