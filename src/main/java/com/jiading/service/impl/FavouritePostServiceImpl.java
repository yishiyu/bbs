package com.jiading.service.impl;


import com.jiading.dao.FavouriteUserDao;
import com.jiading.service.FavouritePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("favouritePostService")
public class FavouritePostServiceImpl implements FavouritePostService {
    @Autowired
    private FavouriteUserDao favouriteUserDao;
    @Override
    public boolean isFavourite(String rid, int uid) {
        Favorite byRidAndUid = favouriteUserDao.findByRidAndUid(uid, Integer.parseInt(rid));
        if(byRidAndUid==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void add(int rid, int uid) {
        favouriteUserDao.add(rid,new Date(),uid);
    }
}
