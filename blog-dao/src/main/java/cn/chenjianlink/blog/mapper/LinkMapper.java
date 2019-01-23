package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.Link;

import java.util.List;

/**
 * 友情链接mapper
 */
public interface LinkMapper {
    List<Link> selectAll() throws Exception;

    int insert(Link link) throws Exception;

    Link selectByPrimaryKey(int id) throws Exception;

    int update(Link link) throws Exception;

    int delete(int[] ids) throws Exception;
}
