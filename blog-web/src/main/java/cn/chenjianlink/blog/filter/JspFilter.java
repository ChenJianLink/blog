package cn.chenjianlink.blog.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Jsp页面直接访问过滤器
 */
public class JspFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession(true);
        String url = httpServletRequest.getRequestURI();
        session.setAttribute("L'Eteranger", "L'Eteranger");
        if (url != null && url.endsWith(".jsp")) {
            httpServletResponse.sendRedirect("/index.html");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
