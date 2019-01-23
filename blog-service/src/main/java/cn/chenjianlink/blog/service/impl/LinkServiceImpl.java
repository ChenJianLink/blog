package cn.chenjianlink.blog.service.impl;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.mapper.LinkMapper;
import cn.chenjianlink.blog.pojo.Link;
import cn.chenjianlink.blog.service.LinkService;
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
        List<Link> linkList = linkMapper.selectAll();
        return linkList;
    }

    //保存新链接
    @Override
    public BlogResult saveLink(Link link) throws Exception {
        linkMapper.insert(link);
        return BlogResult.ok();
    }

    //修改链接
    @Override
    public BlogResult editLink(Integer id, Link link) throws Exception {
        Link oldlink = linkMapper.selectByPrimaryKey(id);
        //数据更新
        oldlink.setLinkName(link.getLinkName());
        oldlink.setLinkUrl(link.getLinkUrl());
        oldlink.setOrderNo(link.getOrderNo());
        linkMapper.update(oldlink);
        return BlogResult.ok();
    }

    @Override
    public BlogResult deleteLink(Integer[] ids) throws Exception {
        int[] id = new int[ids.length];
        for (int i = 0; i < ids.length; i++){
            id[i] = ids[i];
        }
        linkMapper.delete(id);
        return BlogResult.ok();
    }
}
