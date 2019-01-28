package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.common.utils.EasyUIResult;
import cn.chenjianlink.blog.service.BlogTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
