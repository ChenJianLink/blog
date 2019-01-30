package cn.chenjianlink.blog.service.impl;

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
    public EasyUIResult findBlogList(Integer page, Integer rows) throws Exception {
        PageHelper.startPage(page, rows);
        List<Blog> blogList = blogMapper.selectList();
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
}
