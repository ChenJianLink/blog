package cn.chenjianlink.blog.service.impl;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.mapper.BloggerMapper;
import cn.chenjianlink.blog.pojo.Blogger;
import cn.chenjianlink.blog.service.BloggerService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Master信息处理服务层
 */
@Service
public class BloggerServiceImpl implements BloggerService {

    @Resource
    private BloggerMapper bloggerMapper;

    //前台Master信息展示
    @Override
    @Cacheable(value = "bloggerCache")
    public Blogger findBlogger() throws Exception {
        Blogger blogger = bloggerMapper.selectSome();
        return blogger;
    }

    //后台Master信息回显
    @Override
    @Cacheable(value = "bloggerCache")
    public Blogger findBloggerAll() throws Exception {
        Blogger blogger = bloggerMapper.selectAll();
        return blogger;
    }

    //编辑Master个人信息
    @Override
    @CacheEvict(value = "bloggerCache", allEntries = true)
    public BlogResult editBloggerInfo(Blogger blogger) throws Exception {
        bloggerMapper.update(blogger);
        return BlogResult.ok();
    }

    //修改密码
    @Override
    @CacheEvict(value = "bloggerCache", allEntries = true)
    public BlogResult updatePassword(Blogger blogger) throws Exception {
        bloggerMapper.update(blogger);
        return BlogResult.ok();
    }

    @Override
    public Blogger findPassword() throws Exception {
        Blogger blogger = bloggerMapper.selectPassword();
        return blogger;
    }
}
