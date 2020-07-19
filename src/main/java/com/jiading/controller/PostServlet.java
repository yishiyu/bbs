package com.jiading.controller;

import com.jiading.domain.PageBean;
import com.jiading.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping("/pageQuery")
    public void pageQuery(HttpServletRequest req,HttpServletRequest resp){
        //1. 接受参数
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        String cid = req.getParameter("cid");
        //这里rname输入中文会产生乱码，需要处理乱码问题
        String rname = req.getParameter("rname");
        if (rname != null)
            //重新编码
            rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        int intCid = 0;
        int intCurrentPage = 1;
        int intPageSize = 5;//每页显示条数，默认为5条
        if (cid != null && cid.length() > 0) {
            intCid = Integer.parseInt(cid);
        }
        if (currentPage != null && currentPage.length() > 0) {
            intCurrentPage = Integer.parseInt(currentPage);
        }
        if (pageSize != null && pageSize.length() > 0) {
            intPageSize = Integer.parseInt(pageSize);
        }
        //调用service查询PageBean对象
        PageBean<Route> pb = routeService.pageQuery(intCid, intCurrentPage, intPageSize, rname);
        writeValue(pb, resp);
    }
}
