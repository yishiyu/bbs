package com.jiading.service;

import com.jiading.domain.PageBean;
import com.jiading.domain.Post;
import com.jiading.domain.Reply;
import com.jiading.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    public PageBean<Post> pageQueryForSearch(int bid, int currentPage, int pageSize, String postName);

    Post findOne(String pid);

    List<Post> findAllByUid(String uid);

    List<Post> findAllByUid(int uid);

    PageBean<Post> findAllByUidInPages(int uid, int currentPage, int pageSize);

    void writePost(User user, String title, String summary, String content, String bid);

    PageBean<Post> pageQueryForViewByBlock(int bid, int currentPage, int pageSize);

    void writeComment(int uid, int pid, String text);

    List<Reply> allCommentsInThisPost(int pid);

    void viewAddOne(String pid);

    void likedSubOne(String pid);

    void likedAddOne(String pid);
}
