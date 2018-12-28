package cn.chenjianlink.blog.pojo;

import java.io.Serializable;

/**
 * 博客类型对象
 */
public class BlogType implements Serializable {
    private Integer id;
    private String typeName;
    private Integer orderNo;

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
