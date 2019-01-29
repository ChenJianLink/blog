package cn.chenjianlink.blog.controller.admin;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.utils.EasyUIResult;
import cn.chenjianlink.blog.pojo.Link;
import cn.chenjianlink.blog.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping("/admin/link/list")
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
    public BlogResult saveLink(Link link) {
        BlogResult result = null;
        try {
            result = linkService.saveLink(link);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = new BlogResult(0, null);
            return result;
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
    public BlogResult editLink(Integer id, Link link) {
        BlogResult result = null;
        try {
            result = linkService.editLink(id, link);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = new BlogResult(0, null);
            return result;
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
    public BlogResult deleteLink(Integer[] ids) {
        BlogResult result = null;
        try {
            result = linkService.deleteLink(ids);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = new BlogResult(0, null);
            return result;
        }
    }

}
