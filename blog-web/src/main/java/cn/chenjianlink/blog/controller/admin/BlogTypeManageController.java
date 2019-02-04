package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.EasyUIResult;
import cn.chenjianlink.blog.pojo.BlogType;
import cn.chenjianlink.blog.service.BlogTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 日志类别管理Controller
 */
@Controller
public class BlogTypeManageController {

    @Resource
    private BlogTypeService blogTypeService;

    //展示日志类别列表
    @RequestMapping(value = "/admin/blogType/list", method = RequestMethod.POST)
    @ResponseBody
    public EasyUIResult getBlogTypeList(Integer page, Integer rows) throws Exception {
        EasyUIResult result = blogTypeService.getBlogTypeList(page, rows);
        return result;
    }

    //添加日志类别
    @RequestMapping(value = "/admin/blogType/save", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult addBlogType(BlogType blogType) {
        try {
            BlogResult result = blogTypeService.addBlogType(blogType);
            return result;
        } catch (Exception e) {
            return new BlogResult(0, null);
        }
    }

    //修改日志类别
    @RequestMapping(value = "/admin/blogType/edit", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult editBlodType(@RequestParam(value = "id", required = true) Integer id, BlogType blogType) {
        try {
            BlogResult result = blogTypeService.editBlogType(id, blogType);
            return result;
        } catch (Exception e) {
            return new BlogResult(0, null);
        }
    }

    //删除日志类别
    @RequestMapping(value = "/admin/blogType/delete", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult deleteBlogType(@RequestParam(value = "ids", required = true) Integer[] ids) {
        try {
            BlogResult result = blogTypeService.deleteBlogType(ids);
            return result;
        } catch (Exception e) {
            return new BlogResult(0, null);
        }
    }
}
