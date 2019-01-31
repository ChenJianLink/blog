package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.pojo.EasyUIResult;
import cn.chenjianlink.blog.pojo.Link;
import cn.chenjianlink.blog.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 友情链接管理Controller
 */
@Controller
public class LinkManageController {

    @Resource
    private LinkService linkService;

    /**
     * 友情链接管理页面的友情链接列表展示
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/admin/link/list", method = RequestMethod.POST)
    @ResponseBody
    public EasyUIResult getLinkList(Integer page, Integer rows) throws Exception {
        EasyUIResult linkList = linkService.getLinkList(page, rows);
        return linkList;
    }

    /**
     * 添加友情链接
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/admin/link/save", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult addLink(Link link) {
        try {
            BlogResult result = linkService.addLink(link);
            return result;
        } catch (Exception e) {
            return new BlogResult(0, null);
        }
    }

    /**
     * 修改友情链接
     *
     * @param id
     * @param link
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/admin/link/edit", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult editLink(@RequestParam(value = "id", required = true) Integer id, Link link) {
        try {
            BlogResult result = linkService.editLink(id, link);
            return result;
        } catch (Exception e) {
            return new BlogResult(0, null);
        }
    }

    /**
     * 删除友情链接
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/admin/link/delete", method = RequestMethod.POST)
    @ResponseBody
    public BlogResult deleteLink(@RequestParam(value = "ids", required = true) Integer[] ids) {
        try {
            BlogResult result = linkService.deleteLink(ids);
            return result;
        } catch (Exception e) {
            return new BlogResult(0, null);
        }
    }

}
