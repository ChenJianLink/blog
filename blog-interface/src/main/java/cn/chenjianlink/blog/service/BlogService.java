package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.EasyUIResult;

public interface BlogService {
    //查询博客列表
    EasyUIResult findBlogList(Integer page, Integer rows) throws Exception;
}
