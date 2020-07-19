package com.jiading.service;

public interface FavouritePostService {
    public boolean isFavouritePost(String pid, int uid);

    void add(int pid, int uid);
}
