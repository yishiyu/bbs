package com.jiading.service.impl;


import com.jiading.dao.FavouriteUserDao;
import com.jiading.domain.User;
import com.jiading.service.FavouriteUserService;
import com.jiading.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("favouriteUserService")
public class FavouriteUserServiceImpl implements FavouriteUserService {
    @Autowired
    private FavouriteUserDao favouriteUserDao;


    @Override
    public boolean isFavouriteUser(int linkedUid, int uid) {
        return favouriteUserDao.findByUid(uid).contains(linkedUid);
    }

    @Override
    public void add(int linkedUid, int uid) {
        favouriteUserDao.add(uid, DateUtil.getStringTimeNow(), linkedUid);
    }

    @Override
    public void delete(int linkedUid, int uid) {
        favouriteUserDao.delete(uid,linkedUid);
    }

    @Override
    public List<User> allLinkedPeople(User user) {
        return favouriteUserDao.findByUid(user.getUid());
    }
}
