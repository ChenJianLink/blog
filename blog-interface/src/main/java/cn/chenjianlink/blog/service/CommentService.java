package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.Comment;
import cn.chenjianlink.blog.pojo.EasyUIResult;

import java.util.List;
import java.util.Map;

public interface CommentService {
    //评论管理列表显示
    EasyUIResult findCommentList(Integer page, Integer rows, Map<String, Object> commentMap) throws Exception;

    //删除评论
    BlogResult deleteCommentById(Integer[] ids) throws Exception;

    //审核评论
    BlogResult updateCommentState(String[] ids, Integer state) throws Exception;

    //显示评论
    List<Comment> findCommentListByBlogId(Integer blogId) throws Exception;
}
