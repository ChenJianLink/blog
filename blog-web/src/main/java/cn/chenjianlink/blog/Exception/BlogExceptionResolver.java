package cn.chenjianlink.blog.Exception;

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
        //显示错误页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/foreground/error/error404");
        return modelAndView;
    }
}
