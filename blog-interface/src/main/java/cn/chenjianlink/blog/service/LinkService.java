package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.pojo.EasyUIResult;
import cn.chenjianlink.blog.pojo.Link;

import java.util.List;

public interface LinkService {
    //查询所有链接
    List<Link> getLinkList() throws Exception;

    //分页查询所有链接
    EasyUIResult getLinkList(Integer page, Integer rows) throws Exception;

    //保存新链接
    BlogResult addLink(Link link) throws Exception;

    //修改链接
    BlogResult editLink(Integer id, Link link) throws Exception;

    //删除链接
    BlogResult deleteLink(Integer[] ids) throws Exception;
}
