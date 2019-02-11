package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.pojo.EasyUIResult;
import cn.chenjianlink.blog.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 留言管理Controller
 */
@Controller
public class MessageManageController {
    @Resource
    private MessageService messageService;

    //显示留言列表（留言管理以及留言审核）
    @RequestMapping(value = "/admin/message/list", method = RequestMethod.POST)
    @ResponseBody
    public EasyUIResult getMessageList(Integer page, Integer rows, @RequestParam(value = "state", required = false) Integer state) throws Exception {
        EasyUIResult result = messageService.findMessageListAll(page, rows, state);
        return result;
    }

    //删除留言
    @RequestMapping(value = "/admin/message/delete", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult deleteMessageById(@RequestParam(value = "ids", required = true) Integer[] ids) {
        try {
            BlogResult result = messageService.deleteMessageById(ids);
            return result;
        } catch (Exception e) {
            return new BlogResult(0, null);
        }
    }

    //审核留言
    @RequestMapping(value = "/admin/message/review", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult reviewComment(@RequestParam(value = "ids", required = true) String ids, @RequestParam(value = "state", required = true) Integer state) {
        try {
            String[] id = ids.split(",");
            BlogResult result = messageService.updateMessageState(id, state);
            return result;
        } catch (Exception e) {
            return new BlogResult(0, null);
        }
    }
}
