package com.jiading.service;

import com.jiading.domain.Post;
import com.jiading.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("favouritePostService")
public interface FavouritePostService {
    public boolean isFavouritePost(String pid, int uid);

    void add(int pid, int uid);


    List<Post> allLinkedPosts(User user);
}
