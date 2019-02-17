package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.Blogger;

public interface BloggerService {
    //前台Master信息展示
    Blogger findBlogger() throws Exception;

    //后台Master信息回显
    Blogger findBloggerAll() throws Exception;

    //修改Master信息
    BlogResult editBloggerInfo(Blogger blogger) throws Exception;

    //修改密码
    BlogResult updatePassword(Blogger blogger) throws Exception;

    //查找密码
    Blogger findPassword();
}
