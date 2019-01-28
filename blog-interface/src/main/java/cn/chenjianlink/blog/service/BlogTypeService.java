package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.EasyUIResult;
import cn.chenjianlink.blog.pojo.BlogType;

import java.util.List;

public interface BlogTypeService {
    //查询所有博客类别
    List<BlogType> getBlogTypeCountList() throws Exception;

    //分页查询所有博客类别
    EasyUIResult getBlogTypeList(Integer page, Integer rows) throws Exception;
}
