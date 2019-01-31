package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.Blog;

import java.util.List;

public interface BlogMapper {
    //首页博客展示
    List<Blog> selectListAll() throws Exception;

    //后台博客管理列表展示
    List<Blog> selectList(String title) throws Exception;

    //根据id查询博客
    Blog selectByPrimaryKey(int id) throws Exception;

    //由id删除博客
    int delete(int[] id) throws Exception;

    //修改博客内容
    int update(Blog blog) throws Exception;

    //增加新博客
    int insert(Blog blog) throws Exception;
}
