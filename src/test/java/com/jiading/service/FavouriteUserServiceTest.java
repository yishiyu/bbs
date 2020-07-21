package com.jiading.service;


import com.jiading.model.Post;
import com.jiading.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bbs
 *
 * @description: 测试user
 *
 * @author: Laojieduo
 *
 * @create: 2020-07-21 10:42
 **/

public class FavouriteUserServiceTest extends BaseTest{

    @Autowired
    FavouriteUserService fUService;

    @Test
    public void testIsFavouriteUser(){
        int uid=2;
        int likedUid=3;

        // 成功测试
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );
        // 失败测试
        likedUid = 4;
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );
    }


    @Test
    public void testAdd(){
        int uid = 2;
        int likedUid = 4;
        System.out.println("普通添加");
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );
        fUService.add(likedUid,uid);
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );

        System.out.println("重复添加");
        fUService.add(likedUid,uid);
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );

        System.out.println("失败添加(用户不存在)");
        uid = 999;
        fUService.add(likedUid,uid);
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );

        System.out.println("失败添加(喜欢的用户不存在)");
        uid = 2;
        likedUid = 999;
        fUService.add(likedUid,uid);
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );

        System.out.println("失败添加(用户和喜欢的用户都不存在)");
        uid = 777;
        likedUid = 777;
        fUService.add(likedUid,uid);
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );
    }

    @Test
    public void testDelete(){
        int uid = 1;
        int likedUid = 2;
        System.out.println("普通取消");
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );
        fUService.delete(likedUid,uid);
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );

        System.out.println("重复取消");
        fUService.delete(likedUid,uid);
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );

        System.out.println("失败取消(用户不存在)");
        uid = 999;
        fUService.delete(likedUid,uid);
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );

        System.out.println("失败取消(被喜欢不存在)");
        uid = 1;
        likedUid = 999;
        fUService.delete(likedUid,uid);
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );

        System.out.println("失败取消(用户和被喜欢的用户都不存在)");
        uid = 777;
        likedUid = 777;
        fUService.delete(likedUid,uid);
        System.out.println(
                "uid:" + uid + " likedUid:" + likedUid + " " + fUService.isFavouriteUser(likedUid,uid)
        );
    }

    public void testAllLikedPeople(){
        User user = new User();
        user.setUid(1);
        List<User> users = fUService.allLikedPeople(
                user
        );
        for (User u : users) {
            System.out.println(u);
        }
    }

}
