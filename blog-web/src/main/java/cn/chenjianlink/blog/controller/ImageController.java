package cn.chenjianlink.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 验证码Controller
 */
@Controller
public class ImageController {

    //显示验证码
    @RequestMapping("/image")
    public String showImage(){
        return "image";
    }
}
