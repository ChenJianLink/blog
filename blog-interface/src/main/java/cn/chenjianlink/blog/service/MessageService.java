package cn.chenjianlink.blog.service;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.Message;
import cn.chenjianlink.blog.pojo.EasyUIResult;

import java.util.List;

public interface MessageService {
    //留言管理列表显示
    EasyUIResult findMessageListAll(Integer page, Integer rows, Integer state) throws Exception;

    //删除留言
    BlogResult deleteMessageById(Integer[] ids) throws Exception;

    //审核留言
    BlogResult updateMessageState(String[] ids, Integer state) throws Exception;

    //显示留言
    List<Message> findMessageList() throws Exception;

    //增加新留言
    BlogResult addMessage(Message message) throws Exception;
}
