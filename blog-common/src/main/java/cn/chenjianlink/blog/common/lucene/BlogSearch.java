package cn.chenjianlink.blog.common.lucene;

import cn.chenjianlink.blog.pojo.Blog;

import java.util.List;

/**
 * 使用lucene实现前台博客查询
 */
public interface BlogSearch {

    //添加索引
    void addBlogIndex(Blog blog) throws Exception;

    //删除索引
    void deleteBlogIndex(Integer blogId) throws Exception;

    //更新索引
    void updateBlogIndex(Blog blog) throws Exception;

    //根据条件查询索引
    List<Blog> searchBlogIndex(String query) throws Exception;
}
