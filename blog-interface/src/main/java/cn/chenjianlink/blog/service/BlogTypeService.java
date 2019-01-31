package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.pojo.EasyUIResult;
import cn.chenjianlink.blog.pojo.BlogType;

import java.util.List;

public interface BlogTypeService {
    //查询所有博客类别
    List<BlogType> getBlogTypeCountList() throws Exception;

    //分页查询所有博客类别
    EasyUIResult getBlogTypeList(Integer page, Integer rows) throws Exception;

    //添加博客类别
    BlogResult addBlogType(BlogType blogType) throws Exception;

    //修改博客类别
    BlogResult editBlogType(Integer id, BlogType blogType) throws Exception;

    //删除博客类别
    BlogResult deleteBlogType(Integer[] ids) throws Exception;
}
