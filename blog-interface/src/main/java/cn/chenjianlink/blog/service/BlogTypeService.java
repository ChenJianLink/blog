package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.EasyUIResult;
import cn.chenjianlink.blog.pojo.BlogType;

import java.util.List;

public interface BlogTypeService {
    //查询所有日志类别
    List<BlogType> getBlogTypeCountList() throws Exception;

    //分页查询所有日志类别
    EasyUIResult getBlogTypeList(Integer page, Integer rows) throws Exception;

    //添加日志类别
    BlogResult addBlogType(BlogType blogType) throws Exception;

    //修改日志类别
    BlogResult editBlogType(Integer id, BlogType blogType) throws Exception;

    //删除日志类别
    BlogResult deleteBlogType(Integer[] ids) throws Exception;
}
