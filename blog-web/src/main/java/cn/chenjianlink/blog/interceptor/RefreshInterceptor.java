package cn.chenjianlink.blog.interceptor;

import cn.chenjianlink.blog.common.utils.AddressUtils;
import cn.chenjianlink.blog.pojo.Ip;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 恶意刷新拦截器
 */
public class RefreshInterceptor implements HandlerInterceptor {
    //页面加载前进行ip判断
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {
        //获取ip
        //由于反向代理
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader(" Proxy-Client-IP ");
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader(" WL-Proxy-Client-IP ");
        }
        //获取真实ip
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        System.out.println("ip为" + ip);
        //开始进行判断
        HttpSession session = request.getSession();
        Ip ipo = (Ip) session.getAttribute(ip);
        //如果session为空
        if (null == ipo) {
            //放入到session中
            Ip ipoo = new Ip();
            ipoo.setTime(System.currentTimeMillis());
            ipoo.setRecount(1);
            session.setAttribute(ip, ipoo);
            System.out.println("通过！");
            return true;
        } else {
            //如果ip不为空则禁止访问(恶意刷新后把ip存到session中)
            if (ipo.getIp() != null) {
                System.out.println("session消失前永远被拦截了");
                request.getRequestDispatcher("/jsp/foreground/error/errorforbid.jsp").forward(request, response);
                return false;
            } else {
                //如果session不为空
                Long Time = ipo.getTime();
                //如果时间为null表示单秒内刷新过快
                if (Time == null) {
                    Ip ipoo = new Ip();
                    ipo.setIp(ip);
                    session.setAttribute(ip, ipoo);
                    System.out.println("刷新过快");
                    request.getRequestDispatcher("/jsp/foreground/error/errorforbid.jsp").forward(request, response);
                } else {
                    //当前时间减去session中的时间大于两秒的
                    if (((System.currentTimeMillis() - Time) / 1000) > 2) {
                        //当前时间离上一次请求时间大于2秒，可以直接通过,保存这次的请求
                        Ip ipoo = new Ip();
                        ipoo.setTime(System.currentTimeMillis());
                        ipoo.setRecount(1);
                        session.setAttribute(ip, ipoo);
                        System.out.println("大于两秒");
                        return true;
                    } else {
                        //小于两秒的
                        if (ipo.getRecount() > 12) {
                            //小于2秒，并且2秒间隔之内请求了12次
                            System.out.println("进行拦截！");
                            //将ip放到session中用来禁止该ip访问
                            ipo.setIp(ip);
                            //将ip存到数据库里用来后台查看，如发现多次攻击将永远禁止访问
                            //获取ip所在区域
                            Ip jdip = new Ip();
                            AddressUtils addutil = new AddressUtils();
                            System.out.println(addutil.getAddresses("ip=" + ip, "utf-8"));
                            //获取地址
                            String loacl = addutil.getAddresses("ip=" + ip, "utf-8");
                            //写入ip类
                            jdip.setCreatTime(new Date());
                            jdip.setLocation(loacl);
                            jdip.setIp(ip);
                            //userService.insertIp(jdip);
                            request.getRequestDispatcher("/jsp/foreground/error/errorforbid.jsp").forward(request, response);
                            return false;
                        } else {
                            //小于2秒，但请求数小于12次，给对象添加
                            ipo.setTime(System.currentTimeMillis());
                            ipo.setRecount(ipo.getRecount() + 1);
                            System.out.println("访问次数" + ipo.getRecount());
                            request.getSession().setAttribute(ip, ipo);
                        }
                    }
                }
            }
        }
        //如果未出现上述情况直接通过
        return true;
    }
}
