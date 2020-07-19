package com.jiading.service;

public interface FavouriteUserService {
    public boolean isFavouriteUser(int linkedUid, int uid);

    public void add(int linkedUid, int uid);
}
