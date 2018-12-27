package cn.chenjianlink.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 博客首页展示controller
 */
@Controller
public class IdexController {

    //首页展示
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("pageTitle", "局外人之个人空间");
        mav.addObject("mainPage", "foreground/blog/list.jsp");
        mav.setViewName("mainTemp");
        return mav;
    }

}