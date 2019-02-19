package com.cqu.dao.mybatis;

import com.cqu.domain.Post;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 20:19
 * @description :  add description here
 */
public interface PostMybatisDao {
    void addPost(Post post);
    Post getPost(int postId);
}
