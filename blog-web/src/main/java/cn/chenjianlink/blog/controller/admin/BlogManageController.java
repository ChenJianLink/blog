package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.utils.EasyUIResult;
import cn.chenjianlink.blog.pojo.Blog;
import cn.chenjianlink.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
    public EasyUIResult getBlogList(@RequestParam(value = "title", required = false) String title, Integer page, Integer rows) throws Exception {
        EasyUIResult blogList = blogService.findBlogList(title, page, rows);
        return blogList;
    }

    //修改博客页面的数据回显
    @RequestMapping(value = "/admin/blog/findById", method = RequestMethod.POST)
    @ResponseBody
    public Blog findBlogInfo(Integer id) throws Exception {
        Blog blog = blogService.findBlogById(id);
        return blog;
    }

    //删除博客
    @RequestMapping()
    @ResponseBody
    public BlogResult deleteBlog(@RequestParam(value = "ids", required = true) Integer[] ids) {
        BlogResult result = null;
        try {
            result = blogService.deleteBlog(ids);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = new BlogResult(0, null);
            return result;
        }
    }

    //更新博客内容
    @RequestMapping(value = "/admin/blog/edit", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult updateBlogInfo(Blog blog) {
        BlogResult result = null;
        try {
            result = blogService.updateBlog(blog);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = new BlogResult(0, null);
            return result;
        }
    }
}
