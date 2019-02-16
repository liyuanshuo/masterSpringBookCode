package com.cqu.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/16 15:16
 * @description :  add description here
 */
public class Post implements Serializable {
    private int postId;
    private int topicId;
    private int forumId;
    private int userId;
    private String postText;
    private byte[] postAttach;
    private Date postTime;


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public byte[] getPostAttach() {
        return postAttach;
    }

    public void setPostAttach(byte[] postAttach) {
        this.postAttach = postAttach;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", topicId=" + topicId +
                ", forumId=" + forumId +
                ", userId=" + userId +
                ", postText='" + postText + '\'' +
                ", postAttach=" + Arrays.toString(postAttach) +
                ", postTime=" + postTime +
                '}';
    }
}
