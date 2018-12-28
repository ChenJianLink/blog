package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.pojo.Link;
import cn.chenjianlink.blog.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


/**
 * 博客首页展示controller
 */
@Controller
public class IdexController {

    @Resource
    private LinkService linkService;

    //首页展示
    @RequestMapping("/index")
    public ModelAndView index() throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("pageTitle", "局外人之个人空间");
        mav.addObject("mainPage", "foreground/blog/list.jsp");
        mav.setViewName("mainTemp");
        List<Link> linkList = linkService.getLinkList();
        mav.addObject("linkList", linkList);
        return mav;
    }

}