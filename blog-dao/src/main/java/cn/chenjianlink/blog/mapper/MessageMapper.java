package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.Comment;

import java.util.List;
import java.util.Map;

public interface MessageMapper {
    //查询所有留言
    List<Comment> selectList(int state) throws Exception;

    //删除留言
    int delete(int[] ids) throws Exception;

    //修改留言状态为审核通过
    void updateStateAsAdopt(int[] ids) throws Exception;

    //修改留言状态为审核不通过
    void updateStateAsFail(int[] ids) throws Exception;

    //插入新的留言（未审核）
    int insert(Comment comment) throws Exception;
}
