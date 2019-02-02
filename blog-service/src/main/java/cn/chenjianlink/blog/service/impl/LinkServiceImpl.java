package cn.chenjianlink.blog.service.impl;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.pojo.EasyUIResult;
import cn.chenjianlink.blog.mapper.LinkMapper;
import cn.chenjianlink.blog.pojo.Link;
import cn.chenjianlink.blog.service.LinkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 友情链接服务层
 */
@Service
public class LinkServiceImpl implements LinkService {

    @Resource
    private LinkMapper linkMapper;

    //查询所有链接
    @Override
    public List<Link> getLinkList() throws Exception {
        List<Link> linkList = linkMapper.selectList();
        return linkList;
    }

    //分页查询友情链接
    @Override
    public EasyUIResult getLinkList(Integer page, Integer rows) throws Exception {
        //设置分页信息
        PageHelper.startPage(page, rows);
        //查询
        List<Link> linkList = linkMapper.selectAll();
        //获得结果
        PageInfo<Link> pageInfo = new PageInfo<>(linkList);
        long total = pageInfo.getTotal();
        EasyUIResult result = new EasyUIResult(total, linkList);
        return result;
    }

    //保存新链接
    @Override
    public BlogResult addLink(Link link) throws Exception {
        linkMapper.insert(link);
        return BlogResult.ok();
    }

    //修改链接
    @Override
    public BlogResult editLink(Integer id, Link link) throws Exception {
        Link oldlink = linkMapper.selectByPrimaryKey(id);
        if (oldlink == null) {
            return BlogResult.build(0, null);
        }
        //数据更新
        //非法输入判断
        if (!link.getLinkName().isEmpty() && link.getLinkName().trim().length() <= 0) {
            oldlink.setLinkName(link.getLinkName());
        }
        if (!link.getLinkUrl().isEmpty() && link.getLinkUrl().trim().length() <= 0) {
            oldlink.setLinkUrl(link.getLinkUrl());
        }
        if (link.getOrderNo() != null) {
            oldlink.setOrderNo(link.getOrderNo());
        }
        linkMapper.update(oldlink);
        return BlogResult.ok();
    }

    //删除链接
    @Override
    public BlogResult deleteLink(Integer[] ids) throws Exception {
        int[] id = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            id[i] = ids[i];
        }
        linkMapper.delete(id);
        return BlogResult.ok();
    }
}
