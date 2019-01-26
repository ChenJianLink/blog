package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.Blogger;

public interface BloggerService {
    //前台博主信息展示
    Blogger findBlogger() throws Exception;

    //后台博主信息回显
    Blogger findBloggerAll() throws Exception;

    //修改博主信息
    BlogResult editBloggerInfo(Blogger blogger) throws Exception;
}
