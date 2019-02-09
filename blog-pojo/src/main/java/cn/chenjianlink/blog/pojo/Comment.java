package cn.chenjianlink.blog.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 游客评论相关对象
 */
public class Comment implements Serializable {
    private Integer id;
    private String userIp;
    private String userName;
    private Blog blog;
    private String content;
    private Date commentDate;
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
