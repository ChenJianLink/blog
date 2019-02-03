package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.method.ControllerMethod;
import cn.chenjianlink.blog.pojo.Blog;
import cn.chenjianlink.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 博客相关展示Controller
 */
@Controller
public class BlogController {

    @Resource
    private ControllerMethod controllerMethod;
    @Resource
    private BlogService blogService;

    //搜索博客
    @RequestMapping("/blog/query")
    public String searchBlog(Model model, @RequestParam(value = "query", required = true) String query, @RequestParam(value = "page", required = false) Integer page) throws Exception {
        controllerMethod.showMainTemp(model);
        model.addAttribute("pageTitle", "局外人之个人空间-搜索结果");
        model.addAttribute("mainPage", "foreground/blog/result.jsp");
        return "mainTemp";
    }

    //显示博客内容
    @RequestMapping("/blog/articles/{blogId}")
    public String showBlogInfo(Model model, @PathVariable(value = "blogId", required = true) Integer blogId) throws Exception {
        Blog blog = blogService.findBlogById(blogId);
        controllerMethod.showMainTemp(model);
        model.addAttribute("blog", blog);
        model.addAttribute("pageTitle", blog.getTitle() + "-局外人");
        model.addAttribute("mainPage", "foreground/blog/view.jsp");
        return "mainTemp";
    }
}
