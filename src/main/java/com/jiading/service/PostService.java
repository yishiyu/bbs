package com.jiading.service;

import com.jiading.domain.PageBean;
import com.jiading.domain.Post;
import com.jiading.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postService")
public interface PostService {
    public PageBean<Post> pageQuery(int bid, int currentPage, int pageSize, String postName);

    Post findOne(String pid);
    List<Post> findAllByUid(String uid);
    List<Post> findAllByUid(int uid);

    void writePost(User user, String title, String summary, String content,String bid);
}
