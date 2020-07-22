package com.jiading.dao;

import com.jiading.model.Post;
import com.jiading.model.Reply;
import com.jiading.util.TimeUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: bbs
 * @description: PostDao的测试类
 * @author: Yishiyu
 * @create: 2020-07-20 14:44
 **/
public class PostTest extends BaseTest {

    @Autowired
    PostDao postDao;

    @Test
    public void testFindTotalCountByTitleKeyWordAndBlock() {
        Post post = new Post();

        // 查找 1 + 学校
        post.setBid(1);
        post.setTitle("%学校%");
        int count = postDao.findTotalCountByTitleKeyWordAndBlock(post);
        System.out.println(count);


        // 查找 1 + 吃
        post.setBid(1);
        post.setTitle("%吃%");
        System.out.println(
                postDao.findTotalCountByTitleKeyWordAndBlock(post)
        );
    }

    @Test
    public void testFindByPageInSearch() {
        Post post = new Post();
        post.setBid(1);
        post.setTitle("%学校%");
        // 查找 1 + 学校
        for (Post p : postDao.findByPageInSearch(post.getBid(), post.getTitle(), 0, 2)) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByPageInBlockView() {
        Post post = new Post();
        post.setBid(1);
        post.setTitle("%学校%");
        // 查找 bid == 1
        for (Post p : postDao.findByPageInSearch(post.getBid(), post.getTitle(), 0, 2)) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindOne() {
        Post post = new Post();
        int pid = 0;
        // 成功查找 pid = 5
        pid = 5;
        post.setPid(pid);
        System.out.println(
                postDao.findOne(post)
        );
        // 失败查找 pid = 999
        pid = 999;
        post.setPid(pid);
        System.out.println(
                postDao.findOne(post)
        );
    }

    @Test
    public void testFindAllByUid() {
        // 查找 uid == 2
        for (Post post : postDao.findAllByUid("2")) {
            System.out.println(post);
        }
    }

    @Test
    public void testFindAllByUidInPages() {
        // 查找 uid == 2
        int uid = 2;
        for (Post post : postDao.findAllByUidInPages(uid, 0, 2)) {
            System.out.println(post);
        }
    }

    @Test
    public void testCountAllByUid() {
        // 查找 uid == 2
        int uid = 2;
        System.out.println(
                "共" + postDao.countAllByUid(uid) + "个post"
        );
    }

    @Test
    public void testFindTotalCountByBlock() {
        // 查找 bid == 1
        int bid = 1;
        System.out.println(
                "共" + postDao.findTotalCountByBlock(bid) + "个post"
        );
    }

    @Test
    public void testWritePostChinese() {

        String time = TimeUtil.getStringTimeNow();
        // 没有返回pid,没办法查看是否插入成功,需要手动到数据库查看...
        // 正常插入
        postDao.writePost(
                1,
                1,
                "这是一个标题",
                "这是summary",
                "这是正文",
                time
        );
        System.out.println("第一个插入成功");
        // 重复插入
        postDao.writePost(
                1,
                1,
                "这又是一个标题",
                "这又是summary",
                "这又是正文",
                time
        );
        System.out.println("第二个插入合适");
    }
    @Test
    public void testWritePostEnglish() {
        String time = TimeUtil.getStringTimeNow();
        // 没有返回pid,没办法查看是否插入成功,需要手动到数据库查看...
        // 正常插入
        postDao.writePost(
                1,
                1,
                "Thisisanarticle",
                "Thisisasummary",
                "Thisisacontent",
                time
        );
        System.out.println("第一个插入成功");
        // 重复插入
        postDao.writePost(
                1,
                1,
                "Thisisanarticle",
                "Thisisasummary",
                "Thisisacontent",
                time
        );
        System.out.println("第二个插入成功");
    }

    @Test
    public void testWriteCommentAndAllCommentsInThisPost() {
        Date date = new Date();
        SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String time = temp.format(date);

        int pid = 1;

        System.out.println("插入评论前:");
        for (Reply reply : postDao.allCommentsInThisPost(pid)) {
            System.out.println(reply);
        }
        // 正常插入
        postDao.writeComment(
                5,
                pid,
                "这是评论",
                time
        );
        System.out.println("插入评论后:");
        for (Reply reply : postDao.allCommentsInThisPost(pid)) {
            System.out.println(reply);
        }
        // 重复插入
        postDao.writeComment(
                5,
                pid,
                "这是评论",
                time
        );
        System.out.println("重复插入评论后:");
        System.out.println(
                postDao.allCommentsInThisPost(pid)
        );
    }

    @Test
    public void testModifyView() {
        int pid = 5;
        Post post = new Post();
        post.setPid(pid);

        System.out.println("增加前" + postDao.findOne(post).getView());
        postDao.viewAddOne(pid);
        System.out.println("增加后" + postDao.findOne(post).getView());
    }

    @Test
    public void testModifyLiked() {
        int pid = 5;
        Post post = new Post();
        post.setPid(pid);

        System.out.println("增加前" + postDao.findOne(post).getLiked());
        postDao.likedAddOne(pid);
        System.out.println("增加后" + postDao.findOne(post).getLiked());
        postDao.likedSubOne(pid);
        System.out.println("增加后减少" + postDao.findOne(post).getLiked());
    }

    @Test
    public void testNMostPopularPosts() {
        for (Post post : postDao.nMostPopularPosts(3)) {
            System.out.println(post);
        }
    }
}
