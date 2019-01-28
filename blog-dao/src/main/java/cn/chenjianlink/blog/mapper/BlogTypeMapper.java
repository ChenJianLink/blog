package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.BlogType;

import java.util.List;

public interface BlogTypeMapper {
    //查询所有博客类别以及该类别下的博客数量
    List<BlogType> selectAll() throws Exception;

    //查询所有博客类别但不包括博客数量
    List<BlogType> selectList() throws Exception;
}
