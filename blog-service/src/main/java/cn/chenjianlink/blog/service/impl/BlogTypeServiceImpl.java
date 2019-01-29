package cn.chenjianlink.blog.service.impl;

import cn.chenjianlink.blog.common.utils.BlogResult;
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

    //添加博客类别
    @Override
    public BlogResult addBlogType(BlogType blogType) throws Exception {
        blogTypeMapper.insert(blogType);
        return BlogResult.ok();
    }

    //修改博客类别
    @Override
    public BlogResult editBlogType(Integer id, BlogType blogType) throws Exception {
        BlogType oldType = blogTypeMapper.selectByPrimaryKey(id);
        //非法输入判断
        if (!blogType.getTypeName().isEmpty() && blogType.getTypeName().trim().length() > 0) {
            oldType.setTypeName(blogType.getTypeName());
        }
        if (blogType.getOrderNo() != null) {
            oldType.setOrderNo(blogType.getOrderNo());
        }
        blogTypeMapper.update(oldType);
        return BlogResult.ok();
    }

    //删除博客类别
    @Override
    public BlogResult deleteBlogType(Integer[] ids) throws Exception {
        int[] id = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            id[i] = ids[i];
        }
        List<BlogType> blogTypes = blogTypeMapper.selectTypeCount(id);
        //判断要删除的博客类别下是否有博客
        for (BlogType blogType : blogTypes) {
            if (blogType.getBlogCount() > 0) {
                return BlogResult.hasExist("编号为" + blogType.getId() + "的类别下存在博客,请先删除相关博客，再删除该分类");
            }
        }
        blogTypeMapper.delete(id);
        return BlogResult.ok();
    }
}
