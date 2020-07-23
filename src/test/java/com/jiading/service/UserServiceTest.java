package com.jiading.service;


import com.jiading.dao.UserDao;
import com.jiading.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: bbs
 *
 * @description: 测试user类型
 *
 * @author: Laojieduo
 *
 * @create: 2020-07-21 11:24
 **/

public class UserServiceTest extends BaseTest {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Test
    public void testRegister(){
        User userTest = new User();

        //用户名已注册
        userTest.setUsername("毕展语");
        System.out.println("用户已注册");
        System.out.println(userService.register(userTest));

        //用户未注册并注册
        userTest.setUsername("毕展宇");
        userTest.setCode("2345678");
        userTest.setAdmin_permission(false);
        userTest.setComment("我是猪");
        userTest.setEmail("bizhanyu2@163.com");
        userTest.setHead_portrait("4");
        userTest.setLikedTime(2);
        userTest.setMyPostsLikedTime(3);
        userTest.setPassword("12341234234");
        userService.register(userTest);
        System.out.println("输出注册后的状态，未激活");
        System.out.println(userService.findByUsername("毕展宇"));
    }

    @Test
    public void testActivate(){
        String code="6666";
        String username="李泽宇";
        //未激活

        System.out.println("未成功激活");
        System.out.println(userService.active(code));
        //测试成功
        code="s8cr";
        System.out.println("成功激活");
        System.out.println(userService.active(code));
    }

    @Test
    public void testLogin(){
        //测试正确用户名和密码
        User userTest = new User();
        userTest.setPassword("a642a77abd7d4f51bf9226ceaf891fcbb5b299b8");
        userTest.setUsername("毕展语");
        System.out.println("正确的用户名密码显示");
        System.out.println(userService.login(userTest));

        //测试错误的用户名或密码
        userTest.setPassword("a642a77abd7d4f51bf9226ceaf891fcbb5b29999");
        userTest.setUsername("毕展语");
        System.out.println("错误的密码");
        System.out.println(userService.login(userTest));

        userTest.setPassword("a642a77abd7d4f51bf9226ceaf891fcbb5b299b8");
        userTest.setUsername("毕展宇");
        System.out.println("错误的用户名");
        System.out.println(userService.login(userTest));
    }

    @Test
    public void testFindByUserId(){
        int uid=1;
        //查询成功
        System.out.println("查询成功");
        System.out.println(userService.findByUserId(uid));

        uid=777;
        //查询失败
        System.out.println("查询失败");
        System.out.println(userService.findByUserId(uid));
    }

    @Test
    public void testFindByUsername(){
        String username="毕展语";
        //查询成功
        System.out.println("查询成功");
        System.out.println(userService.findByUsername(username));

        username="李狗蛋";
        //查询失败
        System.out.println("查询失败");
        System.out.println(userService.findByUsername(username));
    }

    @Test
    public void testUpdateUser(){
        //输出初始状态
        System.out.println("输出初始状态");
        System.out.println(userService.findByUsername("毕展语"));

        User userTest = new User();
        userTest.setUid(4);
        userTest.setCode("2345678");
        userTest.setAdmin_permission(false);
        userTest.setComment("我是猪");
        userTest.setEmail("bizhanyu@163.com");
        userTest.setHead_portrait("4");
        userTest.setLikedTime(2);
        userTest.setMyPostsLikedTime(3);
        userTest.setPassword("12341234234");
        userTest.setStatus("Y");
        userTest.setUsername("毕展语");
        userService.updateUser(userTest);
        //进行修改
        System.out.println("输出修改后状态");
        System.out.println(userService.findByUsername("毕展语"));
    }

    @Test
    public void testLikedPostAddOneToUserBean(){
        String pidTest="1";
        System.out.println("原始的");
        System.out.println(userService.findByUserId(1));

        userService.likedPostAddOneToUserBean(pidTest);
        System.out.println("更改后的");
        System.out.println(userService.findByUserId(1));
    }

    @Test
    public void testLikedPostSubOneToUserBean(){
        String pidTest="1";
        System.out.println("原始的");
        System.out.println(userService.findByUserId(1));

        userService.likedPostSubOneToUserBean(pidTest);
        System.out.println(userService.findByUserId(1));
    }

    @Test
    public void testLikedUserAddOneToUserBean(){
        String uidTest="1";
        System.out.println("原始的");
        System.out.println(userService.findByUserId(1));

        userService.likedUserAddOneToUserBean(uidTest);
        System.out.println("更改后的");
        System.out.println(userService.findByUserId(1));
    }

    @Test
    public void testLikedUserSubOneToUserBean(){
        String uidTest="1";
        System.out.println("原始的");
        System.out.println(userService.findByUserId(1));

        userService.likedUserSubOneToUserBean(uidTest);
        System.out.println("更改后的");
        System.out.println(userService.findByUserId(1));
    }

}
