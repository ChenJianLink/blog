package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.pojo.PageResult;
import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.pojo.EasyUIResult;
import cn.chenjianlink.blog.pojo.Blog;

import java.util.List;
import java.util.Map;

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

    //根据发布日期查询博客
    List<Blog> findBlogDateList() throws Exception;

    //前台博客列表展示
    PageResult findBlogList(Integer page, Map<String, Object> blogMap) throws Exception;
}
