package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.pojo.EasyUIResult;
import cn.chenjianlink.blog.pojo.Blog;

public interface BlogService {
    //查询博客列表
    EasyUIResult findBlogList(String title, Integer page, Integer rows) throws Exception;

    //根据id查询博客
    Blog findBlogById(Integer id) throws Exception;

    //根据id删除博客
    BlogResult deleteBlog(Integer[] ids) throws Exception;

    //更新博客
    BlogResult editBlog(Blog blog) throws Exception;

    //添加新博客
    BlogResult addBlog(Blog blog) throws Exception;
}
