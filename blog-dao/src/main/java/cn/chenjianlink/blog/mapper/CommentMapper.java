package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.Comment;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
    //查询所有评论
    List<Comment> selectList(Map<String, Object> commentMap) throws Exception;

    //删除评论
    int delete(int[] ids) throws Exception;

    //根据博客id查询该博客的评论总数
    int selectCommentCount(int blogId) throws Exception;

    //修改评论状态为审核通过
    void updateStateAsAdopt(int[] ids) throws Exception;

    //修改评论状态为审核不通过
    void updateStateAsFail(int[] ids) throws Exception;

    //插入新的评论（未审核）
    int insert(Comment comment) throws Exception;
}
