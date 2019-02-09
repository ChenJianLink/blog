package cn.chenjianlink.blog.service.impl;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.mapper.CommentMapper;
import cn.chenjianlink.blog.pojo.Comment;
import cn.chenjianlink.blog.pojo.EasyUIResult;
import cn.chenjianlink.blog.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 评论管理service
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    //评论审核查询待审核评论
    @Override
    @Cacheable(value = "commentCache")
    public EasyUIResult findCommentList(Integer page, Integer rows, Map<String, Object> commentMap) throws Exception {
        PageHelper.startPage(page, rows);
        List<Comment> commentList = commentMapper.selectList(commentMap);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        long total = pageInfo.getTotal();
        EasyUIResult result = new EasyUIResult(total, commentList);
        return result;
    }

    //删除评论
    @Override
    @CacheEvict(value = "commentCache", allEntries = true)
    public BlogResult deleteCommentById(Integer[] ids) throws Exception {
        int[] id = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            id[i] = ids[i];
        }
        commentMapper.delete(id);
        return BlogResult.ok();
    }
}
