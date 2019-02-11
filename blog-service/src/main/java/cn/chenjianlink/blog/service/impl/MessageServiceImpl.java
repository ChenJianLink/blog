package cn.chenjianlink.blog.service.impl;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.mapper.MessageMapper;
import cn.chenjianlink.blog.pojo.EasyUIResult;
import cn.chenjianlink.blog.pojo.Message;
import cn.chenjianlink.blog.service.MessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 留言管理service
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    //留言列表显示
    @Override
    @Cacheable(value = "messageCache")
    public EasyUIResult findMessageListAll(Integer page, Integer rows, Integer state) throws Exception {
        PageHelper.startPage(page, rows);
        Map<String, Integer> messageMap = new HashMap<>();
        messageMap.put("state", state);
        List<Message> messageList = messageMapper.selectList(messageMap);
        PageInfo<Message> pageInfo = new PageInfo<>(messageList);
        long total = pageInfo.getTotal();
        EasyUIResult result = new EasyUIResult(total, messageList);
        return result;
    }

    //删除留言
    @Override
    @CacheEvict(value = "messageCache", allEntries = true)
    public BlogResult deleteMessageById(Integer[] ids) throws Exception {
        int[] id = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            id[i] = ids[i];
        }
        messageMapper.delete(id);
        return BlogResult.ok();
    }

    //更新留言状态
    @Override
    @CacheEvict(value = "messageCache", allEntries = true)
    public BlogResult updateMessageState(String[] ids, Integer state) throws Exception {
        //数组类型转换
        int[] id = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            id[i] = Integer.parseInt(ids[i]);
        }
        //判断state
        if (state == 1) {
            messageMapper.updateStateAsAdopt(id);
        } else if (state == 2) {
            messageMapper.updateStateAsFail(id);
        } else {
            return new BlogResult(0, null);
        }
        return BlogResult.ok();
    }

    //留言显示
    @Override
    @Cacheable(value = "messageCache")
    public List<Message> findMessageList() throws Exception {
        Map<String, Integer> messageMap = new HashMap<>();
        messageMap.put("state", 1);
        List<Message> messageList = messageMapper.selectList(messageMap);
        return messageList;
    }

    //添加留言
    @Override
    @CacheEvict(value = "messageCache", allEntries = true)
    public BlogResult addMessage(Message message) throws Exception {
        message.setLeaveMessageDate(new Date());
        messageMapper.insert(message);
        return BlogResult.ok();
    }
}
