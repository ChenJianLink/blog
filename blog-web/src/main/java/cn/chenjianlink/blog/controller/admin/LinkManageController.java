package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.pojo.Link;
import cn.chenjianlink.blog.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 友情链接管理Controller
 */
@Controller
public class LinkManageController {

    @Resource
    private LinkService linkService;

    /**
     * 友情链接管理页面的友情链接列表展示
     * @return
     * @throws Exception
     */
    @RequestMapping("/admin/link/list")
    @ResponseBody
    public List<Link> getLinkList() throws Exception {
        List<Link> linkList = linkService.getLinkList();
        return linkList;
    }
}
