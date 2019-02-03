package cn.chenjianlink.blog.pojo;

import java.io.Serializable;

/**
 * 日志类型对象
 */
public class BlogType implements Serializable {
    private Integer id;
    //类别名称
    private String typeName;
    //排序序号
    private Integer orderNo;
    //分类下日志数量
    private Integer blogCount;

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
