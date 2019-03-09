package cn.chenjianlink.blog.Exception;

import cn.chenjianlink.blog.common.utils.BlogResult;
import cn.chenjianlink.blog.common.utils.JsonUtils;
import cn.chenjianlink.blog.common.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 全局异常处理器
 */
public class BlogExceptionResolver implements HandlerExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        e.printStackTrace();
        LOGGER.info("系统发生异常");
        LOGGER.error("系统内部错误");
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof BlogException) {
            //显示错误页面
            modelAndView.setViewName("/foreground/error/error404");
            return modelAndView;
        }
        BlogResult result = new BlogResult(0, null);
        try {
            ResponseUtil.write(httpServletResponse, JsonUtils.objectToJson(result));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return modelAndView;
    }
}
