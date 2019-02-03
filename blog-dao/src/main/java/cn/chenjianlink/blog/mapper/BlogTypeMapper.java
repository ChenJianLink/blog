package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.BlogType;

import java.util.List;

public interface BlogTypeMapper {
    //查询所有日志类别以及该类别下的日志数量
    List<BlogType> selectAll() throws Exception;

    //查询所有日志类别但不包括日志数量
    List<BlogType> selectList() throws Exception;

    //添加日志类别
    int insert(BlogType blogType) throws Exception;

    //更新日志类别
    int update(BlogType blogType) throws Exception;

    //根据id查询日志类别
    BlogType selectByPrimaryKey(int id) throws Exception;

    //删除日志类别
    int delete(int[] ids) throws Exception;

    //根据id查询所有日志类别以及该类别下的日志数量
    List<BlogType> selectTypeCount(int[] ids) throws Exception;
}
