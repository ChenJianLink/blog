package cn.chenjianlink.blog.service.impl;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.utils.EasyUIResult;
import cn.chenjianlink.blog.mapper.BlogMapper;
import cn.chenjianlink.blog.pojo.Blog;
import cn.chenjianlink.blog.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客相关service
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    //后台博客管理列表展示(分页查询)
    @Override
    public EasyUIResult findBlogList(String title, Integer page, Integer rows) throws Exception {
        PageHelper.startPage(page, rows);
        List<Blog> blogList = blogMapper.selectList(title);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        long total = pageInfo.getTotal();
        EasyUIResult result = new EasyUIResult(total, blogList);
        return result;
    }

    //修改博客页面数据回显
    @Override
    public Blog findBlogById(Integer id) throws Exception {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        return blog;
    }

    //删除博客
    @Override
    public BlogResult deleteBlog(Integer[] ids) throws Exception {
        int[] id = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            id[i] = ids[i];
        }
        blogMapper.delete(id);
        return BlogResult.ok();
    }

    //更新博客
    @Override
    public BlogResult updateBlog(Blog blog) throws Exception {
        blogMapper.update(blog);
        return BlogResult.ok();
    }
}
