package cn.chenjianlink.blog.service.impl;

import cn.chenjianlink.blog.common.utils.EasyUIResult;
import cn.chenjianlink.blog.mapper.BlogTypeMapper;
import cn.chenjianlink.blog.pojo.BlogType;
import cn.chenjianlink.blog.service.BlogTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    //查询所有类别以及博客数量
    @Override
    public List<BlogType> getBlogTypeCountList() throws Exception {
        List<BlogType> blogTypes = blogTypeMapper.selectAll();
        return blogTypes;
    }

    //分页查询所有类别
    @Override
    public EasyUIResult getBlogTypeList(Integer page, Integer rows) throws Exception {
        PageHelper.startPage(page, rows);
        List<BlogType> typeList = blogTypeMapper.selectList();
        PageInfo<BlogType> pageInfo = new PageInfo<>(typeList);
        long total = pageInfo.getTotal();
        EasyUIResult result = new EasyUIResult(total, typeList);
        return result;
    }
}
