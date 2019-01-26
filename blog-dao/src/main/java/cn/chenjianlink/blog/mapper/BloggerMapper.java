package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.Blogger;

public interface BloggerMapper {
    //前台博主信息查询
    Blogger selectSome() throws Exception;

    //后台博主信息查询
    Blogger selectAll() throws Exception;

    //博主信息修改
    int update(Blogger blogger) throws Exception;
}
