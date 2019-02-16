package com.cqu.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/16 15:22
 * @description :  add description here
 */
public class Topic implements Serializable {
    private int topicId;
    private int forumId;
    private String topicTitle;
    private int userId;
    private Date topicTime;
    private int topicViews;
    private int topicReplies;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTopicTime() {
        return topicTime;
    }

    public void setTopicTime(Date topicTime) {
        this.topicTime = topicTime;
    }

    public int getTopicViews() {
        return topicViews;
    }

    public void setTopicViews(int topicViews) {
        this.topicViews = topicViews;
    }

    public int getTopicReplies() {
        return topicReplies;
    }

    public void setTopicReplies(int topicReplies) {
        this.topicReplies = topicReplies;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", forumId=" + forumId +
                ", topicTitle='" + topicTitle + '\'' +
                ", userId=" + userId +
                ", topicTime=" + topicTime +
                ", topicViews=" + topicViews +
                ", topicReplies=" + topicReplies +
                '}';
    }
}
