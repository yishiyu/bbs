package com.jiading.dao;

import com.jiading.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        // 应该成功找到
        User user1 = userDao.findByUserId(4);
        System.out.println(user1);
        // 查询应该失败
        User user2 = userDao.findByUserId(999);
        System.out.println(user2);
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
        // 应该查找成功
        User user1 = userDao.findByUsername("狗管理一号");
        System.out.println(user1);
        // 应该查找失败
        User user2 = userDao.findByUsername("狗管理999号");
        System.out.println(user2);
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
        // 应该成功插入
        User user = new User();
        user.setUsername("yishiyu");
        user.setUid(6);
        user.setPassword("123456");
        user.setHead_portrait("http");
        user.setAdmin_admin(true);
        userDao.saveUser(user);
        user = userDao.findByUserId(6);
        System.out.println(user);
        // 重复插入
        user.setUsername("无敌");
        userDao.saveUser(user);
        user = userDao.findByUserId(6);
        System.out.println(user);
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
        user.setCode("123456");
        userDao.updateUser(user);
    }

    /**
     * @Description: 测试FindUserByCode
     * @Param: null
     * @return: void
     * @Author: Yishiyu
     * @Date: 2020/7/20
     */
    @Test
    public void testFindUserByCode(){
        // 成功查找
        User user = userDao.findByCode("1k4g");
        System.out.println(user);
        // 失败查找
        user = userDao.findByCode("gggg");
        System.out.println(user);
    }

    /**
     * @Description: 测试 updateStatus
     * @Param: null
     * @return: void
     * @Author: Yishiyu
     * @Date: 2020/7/20
     */
    @Test
    public void testUpdateStatus(){
        User user = userDao.findByUserId(4);
        System.out.println("初始信息："+user);
        user.setStatus("N");
        userDao.updateUser(user);
        User userModified = userDao.findByUserId(4);
        System.out.println("修改后：\n"+userModified);
        userDao.updateStatus(userModified);
        User userFinal = userDao.findByUserId(4);
        System.out.println("再次修改后：\n"+userFinal);
    }

    /**
     * @Description: 测试findByUsernameAndPassword
     * @Param: null
     * @return: void
     * @Author: Yishiyu
     * @Date: 2020/7/20
     */
    @Test
    public void testFindByUsernameAndPassword(){
        // 成功查找
        User user = new User();
        user.setUsername("毕展语");
        user.setPassword("a642a77abd7d4f51bf9226ceaf891fcbb5b299b8");
        User userFound = userDao.findByUsernameAndPassword(user);
        System.out.println(userFound);
        // 失败查找
        user = new User();
        user.setUsername("由比滨结衣");
        user.setPassword("a642a77abd7d4f51bf9226ceaf891fcbb5b299b8");
        userFound = userDao.findByUsernameAndPassword(user);
        System.out.println(userFound);
    }

    /**
     * @Description: 测试findByCodeAndUsername
     * @Param: null
     * @return: void
     * @Author: Yishiyu
     * @Date: 2020/7/20
     */
    @Test
    public void testFindByCodeAndUsername(){
        // 成功查找
        User userFound = userDao.findByCodeAndUsername("1k4g","毕展语");
        System.out.println(userFound);
        // 失败查找
        userFound = userDao.findByCodeAndUsername("9999","由比滨结衣");
        System.out.println(userFound);
    }
}
