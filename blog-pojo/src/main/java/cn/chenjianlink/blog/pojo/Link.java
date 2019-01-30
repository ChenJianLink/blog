package cn.chenjianlink.blog.pojo;

import java.io.Serializable;

/**
 * 友情链接对象
 */
public class Link implements Serializable {
    private Integer id;
    //链接名称
    private String linkName;
    //链接路径
    private String linkUrl;
    //排序序号
    private Integer orderNo;

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
