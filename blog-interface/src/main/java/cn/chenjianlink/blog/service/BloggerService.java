package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.pojo.Blogger;

public interface BloggerService {
    //前台博主信息展示
    Blogger showBlogger() throws Exception;

    //后台博主信息回显
    Blogger showBloggerAll() throws Exception;
}
