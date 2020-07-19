package com.jiading.controller;

import com.jiading.domain.PageBean;
import com.jiading.domain.Post;
import com.jiading.domain.User;
import com.jiading.service.FavouritePostService;
import com.jiading.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @program: bbs
 * @description: 与帖子相关的servlet
 * @author: JiaDing
 * @create: 2020-07-16 16:44
 **/
@Controller
@RequestMapping("/post")
public class PostServlet extends BaseServlet{
    @Autowired
    private PostService postService;
    @Autowired
    private FavouritePostService favouritePostService;
    public static int NOLOGIN = -1;
    public static int FAVOURITED = 1;
    public static int NOTFAVOURITED = 0;
    /*
    TODO
    按分类返回
     */
     */
    /**
    * @Description: 用于搜索功能，给出关键字进行搜索，返回结果列表和总页数，查询的时候会根据当前页面来在sql中设置只返回对应结果
     * 前端需要传入的参数有四个
     * currentPage:现在到第几页了
     * pageSize:一页显示多少个结果
     * bid:属于哪个分类
     * postName:搜索的关键字
    * @Param: [req, resp]
    * @return: void
    * @Author: JiaDing
    * @Date: 2020/7/19
    */
    @RequestMapping("/pageQuery")
    public void pageQuery(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1. 接受参数
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        String bid = req.getParameter("bid");
        //这里rname输入中文会产生乱码，需要处理乱码问题
        String postName = req.getParameter("postName");
        if (postName != null)
            //重新编码
            postName = new String(postName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        int intBid = 0;
        int intCurrentPage = 1;
        int intPageSize = 5;//每页显示条数，默认为5条
        if (bid != null && bid.length() > 0) {
            intBid = Integer.parseInt(bid);
        }
        if (currentPage != null && currentPage.length() > 0) {
            intCurrentPage = Integer.parseInt(currentPage);
        }
        if (pageSize != null && pageSize.length() > 0) {
            intPageSize = Integer.parseInt(pageSize);
        }
        //调用service查询PageBean对象
        PageBean<Post> pb = postService.pageQuery(intBid, intCurrentPage, intPageSize, postName);
        writeValue(pb, resp);
    }
    @RequestMapping("/findOne")
    public void findOne(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1.接收参数id
        String pid = req.getParameter("pid");
        //2.调用service查询route对象
        Post post = postService.findOne(pid);
        //3.转为json写回客户端
        writeValue(post, resp);
    }

    @RequestMapping("/isFavourite")
    public void isFavourite(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int ans = NOTFAVOURITED;
        //1.获取帖子的id
        String pid = req.getParameter("pid");
        //2.获取当前登录的用户User
        User user = (User) req.getSession().getAttribute("user");
        int uid;//用户id
        if (user == null) {
            ans = NOLOGIN;
            //用户尚未登录
            writeValue(ans, resp);
            return;
        } else {
            uid = user.getUid();
        }
        //3.调用FavouriteService查询是否收藏
        boolean favourite = favouritePostService.isFavouritePost(pid, uid);
        if (favourite == true) {
            ans = FAVOURITED;
        } else {
            ans = NOTFAVOURITED;
        }
        writeValue(ans, resp);
    }

    /*
    TODO
    取消收藏
     */
    @RequestMapping("/cancelFavourite")
    public void cancelFavourite(HttpServletRequest req,HttpServletResponse resp){
        String pid = req.getParameter("pid");
        User user = (User) req.getSession().getAttribute("user");
        favouritePostService.cancelLike(Integer.valueOf(pid),user.getUid());
    }
    @RequestMapping("/addFavourite")
    public void addFavourite(HttpServletRequest req, HttpServletResponse resp) {
        String pid = req.getParameter("pid");
        User user = (User) req.getSession().getAttribute("user");
        favouritePostService.add(Integer.parseInt(pid), user.getUid());
    }
    /**
    * @Description: 所有收藏的帖子
     * TODO
     * 分页显示
    * @Param: [req, resp]
    * @return: void
    * @Author: JiaDing
    * @Date: 2020/7/19
    **/
    @RequestMapping("/likedPosts")
    public void allLikedPosts(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Object objectUser = req.getSession().getAttribute("user");
        User user=(User)objectUser;
        List<Post> list=favouritePostService.allLinkedPosts(user);
        writeValue(list,resp);
    }
    /*
    TODO
    分页显示
     */

    @RequestMapping("/myPosts")
    public void myPosts(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Object objectUser = req.getSession().getAttribute("user");
        User user=(User)objectUser;
        List<Post> myPosts = postService.findAllByUid(user.getUid());
        writeValue(myPosts,resp);
    }
    /*
    TODO
    发帖
     */
    /*
    TODO
    评论
     */
    /*
    TODO
    显示该文章对应的所有评论
     */
    /*
    TODO
    浏览计数
     */
    /*
    TODO
    收藏计数
     */
}
