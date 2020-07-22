package com.jiading.dao;


import com.jiading.model.User;
import com.jiading.util.TimeUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: bbs
 * @description: FavouriteUserDao的测试类
 * @author: Yishiyu
 * @create: 2020-07-20 16:12
 **/
public class FavouriteUserTest extends BaseTest {

    @Autowired
    FavouriteUserDao fUDao;

    @Test
    public void testFindByUid(){
        int uid = 1;
        for (User user : fUDao.findByUid(uid)) {
            System.out.println(user.getUid());
        }
    }

    @Test
    public void testFindCount(){
        int uid = 1;
        int count = fUDao.findCount(uid);
        System.out.println(
                uid + "用户的关注列表中有" + count + "个人"
        );
    }

    @Test
    public void testModify(){
        int uid = 1;
        int likedUid = 5;
        String time = TimeUtil.getStringTimeNow();

        // 正常修改
        System.out.println("修改前用户的关注列表:");
        for (User user : fUDao.findByUid(uid)) {
            System.out.print(user.getUid() + " ");
        }

        fUDao.add(uid,time,likedUid);

        System.out.println("\n增加后用户的关注列表:");
        for (User user : fUDao.findByUid(uid)) {
            System.out.print(user.getUid() + " ");
        }

        fUDao.delete(uid,likedUid);
        System.out.println("\n删除后用户的关注列表:");
        for (User user : fUDao.findByUid(uid)) {
            System.out.print(user.getUid() + " ");
        }

        // 重复插入
        fUDao.add(uid,time,likedUid);
        fUDao.add(uid,time,likedUid);
        System.out.println("\n重复插入后用户的关注列表:");
        for (User user : fUDao.findByUid(uid)) {
            System.out.print(user.getUid() + " ");
        }

        // 无效删除
        fUDao.delete(uid,999);
        System.out.println("\n无效删除后用户的关注列表:");
        for (User user : fUDao.findByUid(uid)) {
            System.out.print(user.getUid() + " ");
        }
    }
}
