package com.jiading.service.impl;


import com.jiading.dao.FavouritePostDao;
import com.jiading.domain.Post;
import com.jiading.domain.User;
import com.jiading.service.FavouritePostService;
import com.jiading.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("favouritePostService")
public class FavouritePostServiceImpl implements FavouritePostService {
    @Autowired
    private FavouritePostDao favouritePostDao;

    @Override
    public boolean isFavouritePost(String pid, int uid) {
        Post byRidAndUid = favouritePostDao.findByPidAndUid(uid, Integer.parseInt(pid));
        if (byRidAndUid == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void add(int pid, int uid) {
        favouritePostDao.add(uid, pid, DateUtil.getStringTimeNow());
    }

    @Override
    public List<Post> allLinkedPosts(User user) {
        return favouritePostDao.findByUid(user.getUid());
    }


}
