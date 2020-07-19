package com.jiading.service.impl;


import com.jiading.dao.FavouriteUserDao;
import com.jiading.domain.FavoriteUser;
import com.jiading.service.FavouritePostService;
import com.jiading.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("favouriteUserService")
public class FavouriteUserServiceImpl implements FavouritePostService {
    @Autowired
    private FavouriteUserDao favouriteUserDao;

    @Override
    public boolean isFavouritePost(String rid, int uid) {
        FavoriteUser byRidAndUid = favouriteUserDao.findByLinkedUidAndUid(uid, Integer.parseInt(rid));
        if (byRidAndUid == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void add(int linkedUid, int uid) {
        favouriteUserDao.add(uid, DateUtil.getStringTimeNow(), linkedUid);
    }
}
