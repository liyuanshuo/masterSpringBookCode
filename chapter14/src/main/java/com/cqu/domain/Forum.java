package com.cqu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 16:09
 * @description :  add description here
 */
@Entity
@Table(name = "t_forum")
public class Forum implements Serializable {

    @Id
    @Column(name = "FORUM_ID")
    private int forumId;

    @Column(name = "FORUM_NAME")
    private String forumName;

    @Column(name = "FORUM_DESC")
    private String forumDesc;

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public String getForumDesc() {
        return forumDesc;
    }

    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "forumId=" + forumId +
                ", forumName='" + forumName + '\'' +
                ", forumDesc='" + forumDesc + '\'' +
                '}';
    }
}
