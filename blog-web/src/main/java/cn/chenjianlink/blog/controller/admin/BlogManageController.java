package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.EasyUIResult;
import cn.chenjianlink.blog.pojo.Blog;
import cn.chenjianlink.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 日志管理Controller
 */
@Controller
public class BlogManageController {

    @Resource
    private BlogService blogService;

    //展示日志列表
    @RequestMapping(value = "/admin/blog/list", method = RequestMethod.POST)
    @ResponseBody
    public EasyUIResult getBlogList(@RequestParam(value = "title", required = false) String title, Integer page, Integer rows) throws Exception {
        EasyUIResult blogList = blogService.findBlogList(title, page, rows);
        return blogList;
    }

    //修改日志页面的数据回显
    @RequestMapping(value = "/admin/blog/findById", method = RequestMethod.POST)
    @ResponseBody
    public Blog findBlogInfo(Integer id) throws Exception {
        Blog blog = blogService.findBlogById(id);
        return blog;
    }

    //删除日志
    @RequestMapping(value = "/admin/blog/delete", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult deleteBlog(@RequestParam(value = "ids", required = true) Integer[] ids) {
        try {
            BlogResult result = blogService.deleteBlog(ids);
            return result;
        } catch (Exception e) {
            return new BlogResult(0, null);
        }
    }

    //更新日志内容
    @RequestMapping(value = "/admin/blog/edit", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult editBlogInfo(Blog blog) {
        try {
            BlogResult result = blogService.editBlog(blog);
            return result;
        } catch (Exception e) {
            return new BlogResult(0, null);
        }
    }

    //增加新日志
    @RequestMapping(value = "/admin/blog/save", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult addBlog(Blog blog) {
        try {
            BlogResult result = blogService.addBlog(blog);
            return result;
        } catch (Exception e) {
            return new BlogResult(0, null);
        }
    }
}
