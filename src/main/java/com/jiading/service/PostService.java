package com.jiading.service;

import com.jiading.domain.PageBean;
import com.jiading.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postService")
public interface PostService {
    public PageBean<Post> pageQuery(int bid, int currentPage, int pageSize, String postName);

    Post findOne(String pid);
    List<Post> findAllByUid(String uid);
    List<Post> findAllByUid(int uid);
}
