package cn.chenjianlink.blog.controller;

import cn.chenjianlink.blog.method.MainTempMethod;
import cn.chenjianlink.blog.pojo.Blog;
import cn.chenjianlink.blog.service.BlogService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 博客首页展示controller
 */
@Controller
public class IdexController {

    @Resource
    private MainTempMethod mainTempMethod;
    @Resource
    private BlogService blogService;

    //首页展示
    @RequestMapping("/index")
    public String index(Model model, @RequestParam(value = "typeId", required = false) Integer typeId, @RequestParam(value = "releaseDateStr", required = false) String releaseDateStr) throws Exception {
        //将传入的日期以及博客类别封装到map中
        Map<String, Object> blogMap = new HashMap<>();
        blogMap.put("typeId", typeId);
        blogMap.put("releaseDateStr", releaseDateStr);
        mainTempMethod.showMainTemp(model);
        List<Blog> blogList = blogService.findBlogList(blogMap);
        //抓取博客中插入的图片，在博客列表中显示(利用jsoup抓取)
        for (Blog blog : blogList) {
            List<String> imagesList = blog.getImagesList();
            String blogContent = blog.getContent();
            Document doc = Jsoup.parse(blogContent);
            Elements jpgs = doc.select("img");
            for (int i = 0; i < jpgs.size(); i++) {
                //将图片url取出并放入到imageList中
                imagesList.add(jpgs.get(i).attr("src"));
                if (i == 2) {
                    break;
                }
            }
        }
        model.addAttribute("blogList", blogList);
        model.addAttribute("pageTitle", "局外人之个人空间");
        model.addAttribute("mainPage", "foreground/blog/list.jsp");
        return "mainTemp";
    }

}