package com.jiading.service.impl;

import com.jiading.dao.PostDao;
import com.jiading.domain.PageBean;
import com.jiading.domain.Post;
import com.jiading.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bbs
 * @description: postService的实现类
 * @author: JiaDing
 * @create: 2020-07-18 16:53
 **/
public class PostServiceImpl implements PostService {
    @Autowired
    PostDao postDao;

    @Override
    public PageBean<Post> pageQuery(int bid, int currentPage, int pageSize, String postNameKeyWord) {
        //封装PageBean
        PageBean<Post> pb = new PageBean<Post>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        Post post = new Post();
        post.setBid(bid);
        post.setTitle(postNameKeyWord);
        //设置总记录数
        int totalCount = postDao.findTotalCount(post);
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;
        List<Post> list = postDao.findByPage(post, start, pageSize);
        pb.setList(list);
        //设置总页数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public Post findOne(String pid) {
        Integer pidInt = Integer.parseInt(pid);
        Post post = new Post();
        post.setPid(pidInt);
        Post one = postDao.findOne(post);
        return one;
    }

    @Override
    public List<Post> findAllByUid(String uid) {
        return postDao.findAllByUid(uid);
    }

    @Override
    public List<Post> findAllByUid(int uid) {
        return postDao.findAllByUid(String.valueOf(uid));
    }
}
