package cn.chenjianlink.blog.pojo;


import java.util.Date;

/**
 * Ip相关pojo
 */
public class Ip {
    //请求时间
    private Long time;
    //请求的ip
    private String ip;
    //请求次数
    private Integer recount;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getRecount() {
        return recount;
    }

    public void setRecount(Integer recount) {
        this.recount = recount;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //恶意刷新ip创建时间
    private Date creatTime;
    //访问地址
    private String location;
}
