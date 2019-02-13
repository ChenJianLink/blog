package cn.chenjianlink.blog.method;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;


/**
 * 封装Controller中多次使用的功能代码
 */
public interface ControllerMethod {

    //显示主页的友情链接，Master信息，日志分类的代码
    void showMainTemp(Model model) throws Exception;

    //获取请求的url,与分页信息相关
    String getUrl(HttpServletRequest request);
}
