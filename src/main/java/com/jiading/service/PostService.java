package com.jiading.service;

import com.jiading.domain.PageBean;
import com.jiading.domain.Post;

public interface PostService {
    public PageBean<Post>pageQuery(int cid,int currentPage,int pageSize,String rname);
    Post findOne(String rid);
}
