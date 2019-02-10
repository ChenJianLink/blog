package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.EasyUIResult;

import java.util.Map;

public interface CommentService {
    //评论审核查询待审核评论
    EasyUIResult findCommentList(Integer page, Integer rows, Map<String, Object> commentMap) throws Exception;

    //删除评论
    BlogResult deleteCommentById(Integer[] ids) throws Exception;

    //审核评论
    BlogResult updateCommentState(String[] ids, Integer state) throws Exception;
}
