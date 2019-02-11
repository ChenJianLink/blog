package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.Comment;
import cn.chenjianlink.blog.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 评论发表Controller
 */
@Controller
public class CommentController {
    @Resource
    private CommentService commentService;

    //发表评论
    @RequestMapping(value = "/comment/save", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult comment(Comment comment, @RequestParam(value = "imageCode", required = true) String imageCode, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            String sRand = (String) session.getAttribute("sRand");
            //判断验证码的正确性
            if (sRand == null || !sRand.equals(imageCode)) {
                return BlogResult.showError("验证码不正确");
            }
            String userIp = request.getRemoteAddr();
            comment.setUserIp(userIp);
            BlogResult result = commentService.addComment(comment);
            return result;
        } catch (Exception e) {
            return BlogResult.showError("评论失败");
        }

    }
}
