package cn.chenjianlink.blog.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 留言对象
 */
public class Message implements Serializable {
    private Integer id;
    //留言者ip
    private String userIp;
    //留言者名称
    private String userName;
    //留言内容
    private String content;
    //留言时间
    private Date leaveMessageDate;
    //留言状态
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLeaveMessageDate() {
        return leaveMessageDate;
    }

    public void setLeaveMessageDate(Date leaveMessageDate) {
        this.leaveMessageDate = leaveMessageDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
