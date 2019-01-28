package cn.chenjianlink.blog.service.impl;

import cn.chenjianlink.blog.mapper.BlogTypeMapper;
import cn.chenjianlink.blog.pojo.BlogType;
import cn.chenjianlink.blog.service.BlogTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客类别管理service
 */
@Service
public class BlogTypeServiceImpl implements BlogTypeService {

    @Resource
    private BlogTypeMapper blogTypeMapper;

    //查询所有类别
    @Override
    public List<BlogType> getBlogTypeList() throws Exception {
        List<BlogType> blogTypes = blogTypeMapper.selectAll();
        return blogTypes;
    }
}
