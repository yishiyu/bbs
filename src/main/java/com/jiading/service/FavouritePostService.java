package com.jiading.service;

import com.jiading.domain.PageBean;
import com.jiading.domain.Post;
import com.jiading.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FavouritePostService {
    boolean isFavouritePost(String pid, int uid);

    void add(int pid, int uid);


    PageBean<Post> allLinkedPosts(int intCurrentPage, int intPageSize, User user);

    void cancelLike(Integer valueOf, int uid);
}
