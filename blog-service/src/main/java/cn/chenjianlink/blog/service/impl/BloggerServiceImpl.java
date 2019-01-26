package cn.chenjianlink.blog.service.impl;

import cn.chenjianlink.blog.common.utils.BlogResult;
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
    public Blogger findBlogger() throws Exception {
        Blogger blogger = bloggerMapper.selectSome();
        return blogger;
    }

    //后台博主信息回显
    @Override
    public Blogger findBloggerAll() throws Exception {
        Blogger blogger = bloggerMapper.selectAll();
        return blogger;
    }

    //编辑博主个人信息
    @Override
    public BlogResult editBloggerInfo(Blogger blogger) {
        try {//清除密码
            blogger.setPassword(null);
            bloggerMapper.update(blogger);
            return BlogResult.build(1, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return BlogResult.build(0, "修改失败");
        }
    }
}
