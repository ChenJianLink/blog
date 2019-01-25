package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.method.MainTempMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 查看博主信息Controller
 */
@Controller
public class BloggerController {

    @Resource
    private MainTempMethod mainTempMethod;
    /**
     * "关于博主"页面展示
     *
     * @param model
     * @return
     */
    @RequestMapping("/blogger/aboutMe")
    public String aboutMe(Model model) throws Exception {
        mainTempMethod.showMainTemp(model);
        model.addAttribute("mainPage", "foreground/blogger/info.jsp");
        model.addAttribute("pageTitle", "关于博主-局外人之个人空间");
        return "mainTemp";
    }

}
