package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.Link;

import java.util.List;

/**
 * 友情链接mapper
 */
public interface LinkMapper {
    //查询所有链接
    List<Link> selectAll() throws Exception;

    //插入新链接
    int insert(Link link) throws Exception;

    //根据id查询链接
    Link selectByPrimaryKey(int id) throws Exception;

    //更新链接
    int update(Link link) throws Exception;

    //删除链接
    int delete(int[] ids) throws Exception;
}
