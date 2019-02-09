package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.Comment;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
    //查询所有评论
    List<Comment> selectList(Map<String, Object> commentMap) throws Exception;

    //删除评论
    int delete(int[] ids) throws Exception;
}
