package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.BlogType;

import java.util.List;

public interface BlogTypeMapper {
    //查询所有博客类别以及该类别下的博客数量
    List<BlogType> selectAll() throws Exception;

    //查询所有博客类别但不包括博客数量
    List<BlogType> selectList() throws Exception;

    //添加博客类别
    int insert(BlogType blogType) throws Exception;

    //更新博客类别
    int update(BlogType blogType) throws Exception;

    //根据id查询博客类别
    BlogType selectByPrimaryKey(int id) throws Exception;

    //删除博客类别
    int delete(int[] ids) throws Exception;

    //根据id查询所有博客类别以及该类别下的博客数量
    List<BlogType> selectTypeCount(int[] ids) throws Exception;
}
