package com.jiading.service;

import com.jiading.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("favouriteUserService")
public interface FavouriteUserService {
    public boolean isFavouriteUser(int linkedUid, int uid);

    public void add(int linkedUid, int uid);
    /**
    * @Description: 查询该用户关注的所有用户
    * @Param: [user]
    * @return: java.util.List<com.jiading.domain.User>
    * @Author: JiaDing
    * @Date: 2020/7/19
    */
    List<User> allLinkedPeople(User user);
}
