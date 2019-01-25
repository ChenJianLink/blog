package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.method.MainTempMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


/**
 * 博客首页展示controller
 */
@Controller
public class IdexController {

    @Resource
    private MainTempMethod mainTempMethod;
    //首页展示
    @RequestMapping("/index")
    public String index(Model model) throws Exception {
        mainTempMethod.showMainTemp(model);
        model.addAttribute("pageTitle", "局外人之个人空间");
        model.addAttribute("mainPage", "foreground/blog/list.jsp");
        return "mainTemp";
    }

}