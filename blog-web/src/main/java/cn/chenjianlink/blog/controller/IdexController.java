package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.pojo.PageResult;
import cn.chenjianlink.blog.method.ControllerMethod;
import cn.chenjianlink.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * 日志首页展示controller
 */
@Controller
public class IdexController {

    @Resource
    private ControllerMethod controllerMethod;
    @Resource
    private BlogService blogService;

    //首页展示
    @RequestMapping("/index")
    public String index(Model model, @RequestParam(value = "typeId", required = false) Integer typeId, @RequestParam(value = "releaseDateStr", required = false) String releaseDateStr, @RequestParam(value = "page", required = false) Integer page, HttpServletRequest request) throws Exception {
        //判断page是否为空,为空则设置为1
        if (page == null || page <= 0) {
            page = 1;
        }
        //将传入的日期以及日志类别封装到map中
        Map<String, Object> blogMap = new HashMap<>();
        blogMap.put("typeId", typeId);
        blogMap.put("releaseDateStr", releaseDateStr);
        //查询
        PageResult pageResult = blogService.findBlogList(page, blogMap);
        //获取请求的url，将URL截取并封装到结果中
        String url = controllerMethod.getUrl(request);
        pageResult.setUrl(url);
        controllerMethod.showMainTemp(model);
        model.addAttribute("blogList", pageResult.getPageList());
        model.addAttribute("page", pageResult);
        model.addAttribute("pageTitle", "局外人之秘境");
        model.addAttribute("mainPage", "foreground/blog/list.jsp");
        return "mainTemp";
    }

}