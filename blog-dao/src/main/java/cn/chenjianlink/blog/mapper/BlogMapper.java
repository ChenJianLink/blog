package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.Blog;

import java.util.List;

public interface BlogMapper {
    //首页博客展示
    List<Blog> selectListAll() throws Exception;

    //后台博客管理列表展示
    List<Blog> selectList() throws Exception;


}
