package com.jiading.service;

public interface FavouritePostService {
    public boolean isFavourite(String rid, int uid);

    void add(int parseInt, int uid);
}
