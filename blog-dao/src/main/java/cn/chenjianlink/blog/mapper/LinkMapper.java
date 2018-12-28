package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.Link;

import java.util.List;

/**
 * 友情链接mapper
 */
public interface LinkMapper {
    List<Link> getLinkList() throws Exception;
}
