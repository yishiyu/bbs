package com.jiading.service.impl;

import com.jiading.domain.PageBean;
import com.jiading.domain.Post;
import com.jiading.service.PostService;

import java.util.List;

/**
 * @program: bbs
 * @description: postService的实现类
 * @author: JiaDing
 * @create: 2020-07-18 16:53
 **/
public class PostServiceImpl implements PostService {
    @Override
    public PageBean<Post> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        return null;
    }

    @Override
    public Post findOne(String pid) {
        return null;
    }

    @Override
    public List<Post> findAllByUid(String uid) {
        return null;
    }
}
