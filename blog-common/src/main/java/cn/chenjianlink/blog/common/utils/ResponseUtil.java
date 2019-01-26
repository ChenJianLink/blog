package cn.chenjianlink.blog.common.utils;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 * 响应输出类
 */
public class ResponseUtil {
    public static void write(HttpServletResponse response, Object o) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}


