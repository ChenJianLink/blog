package cn.chenjianlink.blog.service.impl;

import cn.chenjianlink.blog.common.pojo.PageResult;
import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.pojo.EasyUIResult;
import cn.chenjianlink.blog.mapper.BlogMapper;
import cn.chenjianlink.blog.pojo.Blog;
import cn.chenjianlink.blog.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 日志相关service
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;
    @Value("${ROWS}")
    private Integer ROWS;

    //后台日志管理列表展示(分页查询)
    @Override
    public EasyUIResult findBlogList(String title, Integer page, Integer rows) throws Exception {
        PageHelper.startPage(page, rows);
        List<Blog> blogList = blogMapper.selectList(title);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        long total = pageInfo.getTotal();
        EasyUIResult result = new EasyUIResult(total, blogList);
        return result;
    }

    //根据id查询日志
    @Override
    public Blog findBlogById(Integer id) throws Exception {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        return blog;
    }

    //删除日志
    @Override
    public BlogResult deleteBlog(Integer[] ids) throws Exception {
        int[] id = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            id[i] = ids[i];
        }
        blogMapper.delete(id);
        return BlogResult.ok();
    }

    //更新日志
    @Override
    public BlogResult editBlog(Blog blog) throws Exception {
        blogMapper.update(blog);
        return BlogResult.ok();
    }

    //添加新日志
    @Override
    public BlogResult addBlog(Blog blog) throws Exception {
        //补全属性
        blog.setReleaseDate(new Date());
        blogMapper.insert(blog);
        return BlogResult.ok();
    }

    //根据日期分类查询日志数量
    @Override
    public List<Blog> findBlogDateList() throws Exception {
        List<Blog> blogList = blogMapper.selectCountList();
        return blogList;
    }

    //首页日志列表显示
    @Override
    public PageResult findBlogList(Integer page, Map<String, Object> blogMap) throws Exception {
        //设置分页信息
        PageHelper.startPage(page, ROWS);
        //查询日志
        List<Blog> blogList = blogMapper.selectListAll(blogMap);
        //抓取日志中插入的图片，在日志列表中显示(利用jsoup抓取)
        for (Blog blog : blogList) {
            List<String> imagesList = blog.getImagesList();
            String blogContent = blog.getContent();
            Document doc = Jsoup.parse(blogContent);
            Elements images = doc.select("img");
            for (int i = 0; i < images.size(); i++) {
                //将图片url取出并放入到imageList中
                imagesList.add(images.get(i).attr("src"));
                if (i == 2) {
                    break;
                }
            }
        }
        //设置查询分页总记录数，并进行封装
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        long total = pageInfo.getTotal();
        PageResult result = new PageResult(page, (int) total, ROWS, blogList);
        return result;
    }
}
