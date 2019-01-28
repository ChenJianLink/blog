package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.BlogType;

import java.util.List;

public interface BlogTypeMapper {
    //查询所有博客类别
    List<BlogType> selectAll() throws Exception;
}
