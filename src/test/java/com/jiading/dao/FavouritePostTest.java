package com.jiading.dao;


import com.jiading.model.Post;
import com.jiading.util.TimeUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: bbs
 * @description: FavouritePostDao的测试类
 * @author: Yishiyu
 * @create: 2020-07-20 15:43
 **/
public class FavouritePostTest extends BaseTest {

    @Autowired
    FavouritePostDao fPDao;

    @Test
    public void testFindByUidInPages() {
        int uid = 2;
        int currentPage = 0;
        int pageSize = 2;
        for (Post post : fPDao.findByUidInPages(uid, currentPage, pageSize)) {
            System.out.println(post);
        }
    }

    @Test
    public void testFindTotalCountByUser() {
        int uid = 2;
        System.out.println(
                "uid=" + uid + "的post数量为" +
                        fPDao.findTotalCountByUser(uid)
        );
    }

    @Test
    public void testAdd() {
        int uid = 4;
        int pid = 1;
        System.out.println("插入前用户"+uid+"的收藏列表:");
        for (Post post : fPDao.findByUidInPages(uid, 0, 20)) {
            System.out.println(post.getPid());
        }

        // 普通插入
        fPDao.add(
                uid,
                pid,
                TimeUtil.getStringTimeNow()
        );
        System.out.println("插入后用户"+uid+"的收藏列表:");
        for (Post post : fPDao.findByUidInPages(uid, 0, 20)) {
            System.out.println(post.getPid());
        }
        // 重复插入
        fPDao.add(
                uid,
                pid,
                TimeUtil.getStringTimeNow()
        );
        System.out.println("插入后用户"+uid+"的收藏列表:");
        for (Post post : fPDao.findByUidInPages(uid, 0, 20)) {
            System.out.println(post.getPid());
        }

        // 错误插入(pid不存在)
        fPDao.add(
                uid,
                9999,
                TimeUtil.getStringTimeNow()
        );
        System.out.println("插入后用户"+uid+"的收藏列表:");
        for (Post post : fPDao.findByUidInPages(uid, 0, 20)) {
            System.out.println(post.getPid());
        }

        // 错误插入(uid不存在)
        uid = 9999;
        fPDao.add(
                uid,
                pid,
                TimeUtil.getStringTimeNow()
        );
        System.out.println("插入后用户"+uid+"的收藏列表:");
        for (Post post : fPDao.findByUidInPages(uid, 0, 20)) {
            System.out.println(post.getPid());
        }
    }

    @Test
    public void testFindByPidAndUid(){
        int uid = 0;
        int pid = 0;
        Post post = null;
        // 正常查找
        uid = 3;
        pid = 1;
        post = fPDao.findByPidAndUid(uid,pid);
        System.out.println(post);
        // 错误查找,这个关系不存在
        uid = 999;
        pid = 666;
        post = fPDao.findByPidAndUid(uid,pid);
        System.out.println(post);
    }

    @Test
    public void testCancelLike(){
        int uid = 3;
        int pid = 1;
        System.out.println("取消收藏前");
        System.out.println(fPDao.findByPidAndUid(uid,pid));

        fPDao.cancelLike(pid,uid);

        System.out.println("取消收藏后");
        System.out.println(fPDao.findByPidAndUid(uid,pid));
    }
}
