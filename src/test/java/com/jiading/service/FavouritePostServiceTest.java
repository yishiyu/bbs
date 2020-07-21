package com.jiading.service;

import com.jiading.model.Post;
import com.jiading.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;

import java.util.List;

/**
 * @program: bbs
 * @description: FavouritePostService 的测试类
 * @author: Yishiyu
 * @create: 2020-07-21 10:10
 **/
public class FavouritePostServiceTest extends BaseTest {

    @Autowired
    FavouritePostService fPService;

    @Test
    public void testIsFavouritePost(){
        int uid=1;
        // 成功测试
        String pid = "1";
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pid,uid)
        );
        // 失败测试
        pid = "999";
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pid,uid)
        );
    }

    @Test
    public void testAdd(){
        int uid = 1;
        String pidString = "5";
        int pid = 5;
        System.out.println("普通添加");
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pidString,uid)
        );
        fPService.add(pid,uid);
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pidString,uid)
        );

        System.out.println("重复添加");
        fPService.add(pid,uid);
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pidString,uid)
        );

        System.out.println("失败添加(用户不存在)");
        uid = 999;
        fPService.add(pid,uid);
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pidString,uid)
        );

        System.out.println("失败添加(文章不存在)");
        uid = 1;
        pid = 999;
        pidString = "999";
        fPService.add(pid,uid);
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pidString,uid)
        );

        System.out.println("失败添加(用户文章都不存在)");
        uid = 777;
        pid = 777;
        pidString = "777";
        fPService.add(pid,uid);
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pidString,uid)
        );
    }

    @Test
    public void testAllLinkedPosts(){
        User user = new User();
        user.setUid(2);
        List<Post> posts = fPService.allLinkedPosts(
                0,
                5,
                user
        ).getList();
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    public void testCancel(){
        int uid = 1;
        String pidString = "1";
        int pid = 1;
        System.out.println("普通取消");
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pidString,uid)
        );
        fPService.cancelLike(pid,uid);
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pidString,uid)
        );

        System.out.println("重复取消");
        fPService.cancelLike(pid,uid);
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pidString,uid)
        );

        System.out.println("失败取消(用户不存在)");
        uid = 999;
        fPService.cancelLike(pid,uid);
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pidString,uid)
        );

        System.out.println("失败取消(文章不存在)");
        uid = 1;
        pid = 999;
        pidString = "999";
        fPService.cancelLike(pid,uid);
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pidString,uid)
        );

        System.out.println("失败取消(用户文章都不存在)");
        uid = 777;
        pid = 777;
        pidString = "777";
        fPService.cancelLike(pid,uid);
        System.out.println(
                "uid:" + uid + " pid:" + pid + " " + fPService.isFavouritePost(pidString,uid)
        );
    }

}
