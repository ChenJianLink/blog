package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.pojo.BlogType;

import java.util.List;

public interface BlogTypeService {
    //查询所有博客类别
    List<BlogType> getBlogTypeList() throws Exception;
}
