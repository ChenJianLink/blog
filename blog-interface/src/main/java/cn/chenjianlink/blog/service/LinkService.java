package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.pojo.Link;

import java.util.List;

public interface LinkService {
    List<Link> getLinkList() throws Exception;
}
