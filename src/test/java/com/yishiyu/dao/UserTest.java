package com.yishiyu.dao;

import com.jiading.dao.UserDao;
import com.jiading.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.font.TrueTypeFont;

/**
 * @program: bbs
 * @description: UserDao层测试类
 * @author: Yishiyu
 * @create: 2020-07-20 09:06
 **/
public class UserTest extends BaseTest {
    @Autowired
    UserDao userDao;

    /**
    * @Description: 测试findByUserId
    * @Param: [null]
    * @return: void
    * @Author: Yishiyu
    * @Date: 2020/7/20
    */
    @Test
    public void testFindByUserId(){
        User user = userDao.findByUserId(4);
        System.out.println(user);
    }

    /**
    * @Description: 测试findByUsername
    * @Param: null
    * @return: void
    * @Author: Yishiyu
    * @Date: 2020/7/20
    */
    @Test
    public void testFindByUsername(){
        User user = userDao.findByUsername("狗管理一号");
        System.out.println(user);
    }

    /**
    * @Description: 测试SaveUser
    * @Param: null
    * @return: void
    * @Author: Yishiyu
    * @Date: 2020/7/20
    */
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("yishiyu");
        user.setUid(6);
        user.setPassword("123456");
        user.setHead_portrait("http");
        user.setAdmin_admin(true);
        userDao.saveUser(user);
    }

    /**
     * @Description: 测试UpdateUser
     * @Param: null
     * @return: void
     * @Author: Yishiyu
     * @Date: 2020/7/20
     */
    @Test
    public void testUpdateUser(){
        User user = userDao.findByUserId(6);
        user.setUsername("http");
        userDao.updateUser(user);
    }
    
}
