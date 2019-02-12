package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.method.ControllerMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 访问可视化Controller
 */
@Controller
public class VisiterShowController {

    @Resource
    private ControllerMethod controllerMethod;

    @RequestMapping("/show/visiterShow")
    public String visiterShow(Model model) throws Exception {
        controllerMethod.showMainTemp(model);
        model.addAttribute("mainPage", "foreground/visitershow/show.jsp");
        model.addAttribute("pageTitle", "访客记录-局外人之秘境");
        return "mainTemp";
    }
}
