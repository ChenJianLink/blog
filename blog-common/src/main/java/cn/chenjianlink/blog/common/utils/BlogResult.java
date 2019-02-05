package cn.chenjianlink.blog.common.utils;

import java.io.Serializable;

/**
 * 日志自定义响应结构
 */
public class BlogResult implements Serializable {

    // 响应业务状态
    private Integer success;

    //分类中是否存在子类
    private String exist;

    public BlogResult() {

    }

    public BlogResult(Integer success, String exist) {
        this.success = success;
        this.exist = exist;
    }

    public BlogResult(String exist) {
        this.success = 1;
        this.exist = exist;
    }

    public static BlogResult build(Integer success, String exist) {
        return new BlogResult(success, exist);
    }

    public static BlogResult ok() {
        return new BlogResult(null);
    }

    public static BlogResult hasExist(String exist) {
        return new BlogResult(exist);
    }

    public Integer getsuccess() {
        return success;
    }

    public void setsuccess(Integer success) {
        this.success = success;
    }

    public String getExist() {
        return exist;
    }

    public void setExist(String exist) {
        this.exist = exist;
    }


}
