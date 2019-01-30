package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.EasyUIResult;
import cn.chenjianlink.blog.pojo.Blog;

public interface BlogService {
    //查询博客列表
    EasyUIResult findBlogList(Integer page, Integer rows) throws Exception;

    //根据id查询博客
    Blog findBlogById(Integer id) throws Exception;
}
