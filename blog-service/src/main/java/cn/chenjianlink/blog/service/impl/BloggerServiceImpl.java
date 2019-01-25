package cn.chenjianlink.blog.service.impl;

import cn.chenjianlink.blog.mapper.BloggerMapper;
import cn.chenjianlink.blog.pojo.Blogger;
import cn.chenjianlink.blog.service.BloggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 博主信息处理服务层
 */
@Service
public class BloggerServiceImpl implements BloggerService {

    @Resource
    private BloggerMapper bloggerMapper;

    //前台博主信息展示
    @Override
    public Blogger showBlogger() throws Exception {
        Blogger blogger = bloggerMapper.selectSome();
        return blogger;
    }

    @Override
    public Blogger showBloggerAll() throws Exception {
        Blogger blogger = bloggerMapper.selectAll();
        return blogger;
    }
}
