package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.utils.EasyUIResult;
import cn.chenjianlink.blog.pojo.BlogType;
import cn.chenjianlink.blog.service.BlogTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 博客类别管理Controller
 */
@Controller
public class BlogTypeManageController {

    @Resource
    private BlogTypeService blogTypeService;

    //展示博客类别列表
    @RequestMapping("/admin/blogType/list")
    @ResponseBody
    public EasyUIResult getBlogTypeList(Integer page, Integer rows) throws Exception {
        EasyUIResult result = blogTypeService.getBlogTypeList(page, rows);
        return result;
    }

    //添加博客类别
    @RequestMapping(value = "/admin/blogType/save", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult addBlogType(BlogType blogType) {
        BlogResult result = null;
        try {
            result = blogTypeService.addBlogType(blogType);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = new BlogResult(0,  null);
            return result;
        }
    }

    //修改博客类别
    @RequestMapping(value = "/admin/blogType/edit", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult editBlodType(Integer id, BlogType blogType) {
        BlogResult result = null;
        try {
            result = blogTypeService.editBlogType(id, blogType);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = new BlogResult(0, null);
            return result;
        }
    }

    //删除博客类别
    @RequestMapping(value = "/admin/blogType/delete", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult deleteBlogType(Integer[] ids) {
        BlogResult result = null;
        try {
            result = blogTypeService.deleteBlogType(ids);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = new BlogResult(0,  null);
            return result;
        }
    }
}
