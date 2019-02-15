package com.cqu.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 15:31
 * @description :  add description here
 */
public class Topic implements Serializable {
    private static final long serialVersionUID = 1L;
    private int topicId;
    private String topicTitle;
    private Date topicTime;
    private Post post;

    private int topicViews;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicTitle='" + topicTitle + '\'' +
                ", topicTime=" + topicTime +
                ", post=" + post +
                ", topicViews=" + topicViews +
                '}';
    }
}
