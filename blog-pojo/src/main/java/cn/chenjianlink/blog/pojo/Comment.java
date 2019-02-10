package cn.chenjianlink.blog.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 游客评论相关对象
 */
public class Comment implements Serializable {
    //评论id
    private Integer id;
    //评论者ip
    private String userIp;
    //评论者名称
    private String userName;
    //日志
    private Blog blog;
    //评论内容
    private String content;
    //评论日期
    private Date commentDate;
    //评论状态
    private Integer state;/*0:待审核，1：审核通过，2：审核不通过*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
