package com.cqu.domain;

import java.io.Serializable;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 15:27
 * @description :  add description here
 */
public class Forum implements Serializable {

    private int forumId;
    private String forumName;
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
