package com.jiading.service;

import com.jiading.model.Post;
import com.jiading.model.Reply;
import com.jiading.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bbs
 * @description: PostService的测试类
 * @author: Yishiyu
 * @create: 2020-07-21 10:43
 **/
public class PostServiceTest extends BaseTest {

    @Autowired
    PostService postService;

    @Test
    public void testPageQueryForViewByBlock(){
        int bid = 1;
        List<Post> posts = postService.pageQueryForViewByBlock(
                bid,
                0,
                10
        ).getList();
        for (Post p : posts) {
            System.out.println(p);
        }
    }

    @Test
    public void testWriteCommentAndAllCommentsInThisPost(){
        String  pidString = "1";
        int pidInt = 1;
        int uid = 1;
        String comment = "这是一个评论";
        // 原始评论
        System.out.println("原始评论");
        List<Reply> replies = postService.allCommentsInThisPost(pidString);
        for (Reply reply : replies) {
            System.out.println(reply);
        }

        // 正常写入
        postService.writeComment(
                uid,
                pidInt,
                comment
        );
        System.out.println("插入后的评论");
        replies = postService.allCommentsInThisPost(pidString);
        for (Reply reply : replies) {
            System.out.println(reply);
        }

        // 重复写入
        postService.writeComment(
                uid,
                pidInt,
                comment
        );
        System.out.println("重复插入后的评论");
        replies = postService.allCommentsInThisPost(pidString);
        for (Reply reply : replies) {
            System.out.println(reply);
        }

        // 错误写入,文章不存在
        pidInt = 456;
        pidString = "456";
        postService.writeComment(
                uid,
                pidInt,
                comment
        );
        System.out.println("文章不存在");
        replies = postService.allCommentsInThisPost(pidString);
        for (Reply reply : replies) {
            System.out.println(reply);
        }

        // 错误写入,用户不存在
        pidInt = 1;
        pidString = "1";
        uid = 789;
        postService.writeComment(
                uid,
                pidInt,
                comment
        );
        System.out.println("用户不存在");
        replies = postService.allCommentsInThisPost(pidString);
        for (Reply reply : replies) {
            System.out.println(reply);
        }

        // 错误写入,用户文章都不存在
        pidInt = 456;
        pidString = "456";
        uid = 789;
        postService.writeComment(
                uid,
                pidInt,
                comment
        );
        System.out.println("用户文章都不存在");
        replies = postService.allCommentsInThisPost(pidString);
        for (Reply reply : replies) {
            System.out.println(reply);
        }
    }

    @Test
    public void testFindOne(){
        String pid = "1";
        System.out.println("普通查找");
        Post post = postService.findOne(pid);
        System.out.println(post);

        pid = "896";
        System.out.println("文章不存在查找");
        post = postService.findOne(pid);
        System.out.println(post);
    }

    @Test
    public void testViewAddOne(){
        int pidInt = 1;
        String pidString = "1";
        Post post = null;

        post = postService.findOne(pidString);
        System.out.println("添加前 views:" + post.getView());

        postService.viewAddOne(pidString);

        post = postService.findOne(pidString);
        System.out.println("添加后 views:" + post.getView());
    }

    @Test
    public void testModifyLiked(){
        int pidInt = 1;
        String pidString = "1";
        Post post = null;

        post = postService.findOne(pidString);
        System.out.println("修改前 liked:" + post.getLiked());

        postService.likedAddOne(pidString);

        post = postService.findOne(pidString);
        System.out.println("添加后 liked:" + post.getLiked());

        postService.likedSubOne(pidString);

        post = postService.findOne(pidString);
        System.out.println("减少后 liked:" + post.getLiked());
    }

    @Test
    public void testGetNMostPopularPosts(){
        List<Post> posts = postService.getNMostPopularPosts(3);
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    public void testPageQueryForSearch(){
        List<Post> posts = postService.pageQueryForSearch(
                1,
                0,
                3,
                "学校"
        ).getList();
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    public void testFindAllByUid(){
        int uidInt = 1;
        String uidString = "1";

        List<Post> posts = postService.findAllByUid(uidInt);
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    public void testFindAllByUidInPages(){
        int uidInt = 1;
        String uidString = "1";

        List<Post> posts = postService.findAllByUidInPages(
                uidInt,
                0,
                3
        ).getList();

        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    public void testWritePost(){
        User user = new User();
        user.setUid(1);
        int uidInt = 1;

        System.out.println("写入之前");
        List<Post> posts = postService.findAllByUid(uidInt);
        for (Post post : posts) {
            System.out.println(post);
        }

        postService.writePost(
                user,
                "Title 标题",
                "Summary 总结",
                "Content 内容",
                "1"
        );

        System.out.println("写入之后");
        posts = postService.findAllByUid(uidInt);
        for (Post post : posts) {
            System.out.println(post);
        }
    }

}
