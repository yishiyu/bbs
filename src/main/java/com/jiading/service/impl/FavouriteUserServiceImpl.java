package com.jiading.service.impl;


import com.jiading.dao.FavouriteUserDao;
import com.jiading.model.User;
import com.jiading.service.FavouriteUserService;
import com.jiading.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("favouriteUserService")
public class FavouriteUserServiceImpl implements FavouriteUserService {
    @Autowired
    private FavouriteUserDao favouriteUserDao;


    @Override
    public boolean isFavouriteUser(int likedUid, int uid) {
        return favouriteUserDao.findByUid(uid).contains(likedUid);
    }

    @Override
    public void add(int likedUid, int uid) {
        favouriteUserDao.add(uid, TimeUtil.getStringTimeNow(), likedUid);
    }

    @Override
    public void delete(int likedUid, int uid) {
        favouriteUserDao.delete(uid,likedUid);
    }

    @Override
    public List<User> allLikedPeople(User user) {
        return favouriteUserDao.findByUid(user.getUid());
    }
}
