package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.Blogger;

public interface BloggerMapper {
    //前台Master信息查询
    Blogger selectSome() throws Exception;

    //后台Master信息查询
    Blogger selectAll() throws Exception;

    //Master信息修改
    int update(Blogger blogger) throws Exception;
}
