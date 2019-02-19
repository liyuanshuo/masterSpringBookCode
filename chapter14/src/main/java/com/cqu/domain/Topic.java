package com.cqu.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 16:12
 * @description :  add description here
 */
@Entity
@Table(name = "T_TOPIC")
public class Topic implements Serializable {
    private static final long serivalVersionUID = 1L;

    @Id
    @Column(name = "TOPIC_ID")
    private int topicId;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "TOPIC_TITLE")
    private String topicTitle;

    @Column(name = "TOPIC_TIME")
    private Date topicTime;

    @ManyToOne
    @JoinColumn(name = "FORUM_ID")
    private Forum forum;

    @Column(name = "TOPIC_VIEWS")
    private int topicViews;

    @Column(name = "TOPIC_REPLIES")
    private int topicReplies;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Post> posts;

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                ", userId=" + userId +
                ", topicTitle='" + topicTitle + '\'' +
                ", topicTime=" + topicTime +
                ", forum=" + forum +
                ", topicViews=" + topicViews +
                ", topicReplies=" + topicReplies +
                ", posts=" + posts +
                '}';
    }
}
