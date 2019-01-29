package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.utils.ResponseUtil;
import cn.chenjianlink.blog.pojo.Blogger;
import cn.chenjianlink.blog.service.BloggerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

/**
 * 后台博主信息管理Controller
 */
@Controller
public class BloggerManageController {
    @Resource
    private BloggerService bloggerService;

    //修改用户信息页面对用户信息进行回显
    @RequestMapping(value = "/admin/blogger/find", method = RequestMethod.POST)
    @ResponseBody
    public Blogger findBloggerInfo() throws Exception {
        Blogger blogger = bloggerService.findBloggerAll();
        return blogger;
    }

    //修改个人信息
    @RequestMapping(value = "/admin/blogger/save", method = RequestMethod.POST)
    public void editBloggerInfo(Blogger blogger, @RequestParam("imageFile") MultipartFile imageFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer responseResult = new StringBuffer();
        try {
            //判断是否有图片上传
            if (!imageFile.isEmpty()) {
                String path = request.getServletContext().getRealPath("/") + "static/userImages/";
                //原始文件名称
                String pictureName = imageFile.getOriginalFilename();
                //设置新文件名
                String newPictureName = UUID.randomUUID().toString() + pictureName.substring(pictureName.lastIndexOf("."));
                //上传图片
                File uploadPic = new File(path + newPictureName);
                if (uploadPic.exists()) {
                    uploadPic.mkdirs();
                }
                //向磁盘写文件
                imageFile.transferTo(uploadPic);
                //将图片名称写入pojo
                blogger.setImageName(newPictureName);
            }
            BlogResult result = bloggerService.editBloggerInfo(blogger);
            if (result.getsuccess() == 1) {
                responseResult.append("<script language='javascript'>alert('修改成功！');</script>");
            }
            ResponseUtil.write(response, responseResult);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.append("<script language='javascript'>alert('修改失败！');</script>");
            ResponseUtil.write(response, responseResult);
        }

    }
}
