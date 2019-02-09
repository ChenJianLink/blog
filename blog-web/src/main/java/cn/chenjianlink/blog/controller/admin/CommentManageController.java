package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.EasyUIResult;
import cn.chenjianlink.blog.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 评论管理Controller
 */
@Controller
public class CommentManageController {

    @Resource
    private CommentService commentService;

    //显示评论列表（评论管理以及评论审核）
    @RequestMapping(value = "/admin/comment/list", method = RequestMethod.POST)
    @ResponseBody
    public EasyUIResult getCommentList(Integer page, Integer rows, @RequestParam(value = "state", required = false) Integer state) throws Exception {
        Map<String, Object> commentMap = new HashMap<>();
        commentMap.put("state", state);
        commentMap.put("blogId", null);
        EasyUIResult commentList = commentService.findCommentList(page, rows, commentMap);
        return commentList;
    }

    //删除评论
    @RequestMapping(value = "/admin/comment/delete", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult deleteCommentById(@RequestParam(value = "ids", required = true) Integer[] ids) {
        try {
            BlogResult result = commentService.deleteCommentById(ids);
            return result;
        } catch (Exception e) {
            return new BlogResult(0, null);
        }
    }
}
