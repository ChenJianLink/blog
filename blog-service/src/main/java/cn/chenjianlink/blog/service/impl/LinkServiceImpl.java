package cn.chenjianlink.blog.service.impl;

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

    @Override
    public List<Link> getLinkList() throws Exception {
        List<Link> linkList = linkMapper.getLinkList();
        return linkList;
    }
}
