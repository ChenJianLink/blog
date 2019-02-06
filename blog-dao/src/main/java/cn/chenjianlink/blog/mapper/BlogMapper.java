package cn.chenjianlink.blog.mapper;

import cn.chenjianlink.blog.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //首页日志展示
    List<Blog> selectListAll(Map<String, Object> blogMap) throws Exception;

    //按日志发布日期查询
    List<Blog> selectCountList() throws Exception;

    //后台日志管理列表展示
    List<Blog> selectList(String title) throws Exception;

    //根据id查询日志
    Blog selectByPrimaryKey(int id) throws Exception;

    //由id删除日志
    int delete(int[] id) throws Exception;

    //更新日志
    int update(Blog blog) throws Exception;

    //增加新日志
    int insert(Blog blog) throws Exception;

    //查询日志总数
    int selectCount(Map<String, Object> blogMap) throws Exception;
}
