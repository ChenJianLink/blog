package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.pojo.PageResult;
import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.EasyUIResult;
import cn.chenjianlink.blog.pojo.Blog;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BlogService {
    //查询日志列表
    EasyUIResult findBlogList(String title, Integer page, Integer rows) throws Exception;

    //根据id查询日志
    Blog findBlogById(Integer id) throws Exception;

    //根据id删除日志
    BlogResult deleteBlog(Integer[] ids) throws Exception;

    //修改日志内容
    BlogResult editBlog(Blog blog) throws Exception;

    //添加新日志
    BlogResult addBlog(Blog blog) throws Exception;

    //根据发布日期查询日志
    List<Blog> findBlogDateList() throws Exception;

    //前台日志列表展示
    PageResult findBlogList(Integer page, Map<String, Object> blogMap) throws Exception;

    //根据条件查询日志
    PageResult searchBlogByQuery(Integer page, String query) throws Exception;

    //更新日志阅读量以及评论量
    void updateClickAndReply(Blog blog) throws Exception;

    //获得上一篇博客
    Blog findPreBlog(Blog blog) throws Exception;

    //获得下一篇博客
    Blog findNextBlog(Blog blog) throws Exception;
}
