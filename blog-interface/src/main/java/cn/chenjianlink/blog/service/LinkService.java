package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.Link;

import java.util.List;

public interface LinkService {
    //查询所有链接
    List<Link> getLinkList() throws Exception;
    //保存新链接
    BlogResult saveLink(Link link) throws Exception;
}
