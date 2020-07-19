package com.jiading.controller;

import com.jiading.dao.FavouriteUserDao;
import com.jiading.domain.ResultInfo;
import com.jiading.domain.User;
import com.jiading.service.FavouriteUserService;
import com.jiading.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")//使用通配符匹配多个方法
public class UserServlet extends BaseServlet {
    //调用Service查询
    @Autowired
    private UserService service;
    @Autowired
    private FavouriteUserService favouriteUserService;

    @RequestMapping("/register")
    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1.获取用户名和密码
        Map<String, String[]> parameterMap = req.getParameterMap();
        //2.封装user对象
        //实体类就直接new
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        ResultInfo resultInfo = new ResultInfo();
        if (service.register(user)) {
            resultInfo.setFlag(true);
        } else {
            resultInfo.setFlag(false);
        }
        //7.响应数据
        writeValue(resultInfo, resp);
    }

    @RequestMapping("/active")
    public void active(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1.获取激活码
        String code = req.getParameter("code");
        String username = req.getParameter("username");
        if (code != null) {
            boolean flag = service.active(code, username);
            String msg;
            if (flag) {
                //激活成功
                msg = "激活成功，请<a href='login.html'>登录</a>";
            } else {
                //激活失败
                msg = "激活失败，请联系管理员!";
            }
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(msg);
        }
    }

    @RequestMapping("/exit")
    public void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1.销毁session
        req.getSession().invalidate();
        //2.跳转
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }

    @RequestMapping("/findUser")
    public void findUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //从session中获取登录用户
        Object user = req.getSession().getAttribute("user");
        writeValue(user, resp);
    }

    @RequestMapping("/login")
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1.获取用户名和密码
        Map<String, String[]> parameterMap = req.getParameterMap();
        //2.封装user对象
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ResultInfo resultInfo = new ResultInfo();
        String checkcode = (String) req.getSession().getAttribute("CHECKCODE_SERVER");
        req.getSession().removeAttribute("CHECKCODE_SERVER");
        if (!user.getCode().toUpperCase().equals(checkcode.toUpperCase())) {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误");
            writeValue(resultInfo, resp);
            return;
        }
        User u = service.login(user);

        //4.判断用户名或密码是否正确
        if (u == null) {
            //用户名密码错误
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名或密码错误");
        }
        //5.判断用户是否激活
        if (u != null && !"Y".equals(u.getStatus())) {
            //用户尚未激活
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("您尚未激活，请登录邮箱激活");
        }
        //6.判断登录成功
        if (u != null && "Y".equals(u.getStatus())) {
            //登录成功
            resultInfo.setFlag(true);
            req.getSession().setAttribute("user", u);
        }
        writeValue(resultInfo, resp);
    }
    /**
    * @Description: 返回该用户所有关注的用户
    * @Param: [req,resp]
    * @return: void
    * @Author: JiaDing
    * @Date: 2020/7/19
    */
    @RequestMapping("/likedPeople")
    public void allLikedPeople(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Object objectUser = req.getSession().getAttribute("user");
        User user=(User)objectUser;
        List<User> list=favouriteUserService.allLinkedPeople(user);
        writeValue(list,resp);
    }
    /**
    * @Description: 添加用户到关注列表
    * @Param: [req, resp]
    * @return: void
    * @Author: JiaDing
    * @Date: 2020/7/19
    */
    @RequestMapping("/addFavourite")
    public void addFavourite(HttpServletRequest req, HttpServletResponse resp) {
        String uid = req.getParameter("uid");
        User user = (User) req.getSession().getAttribute("user");
        favouriteUserService.add(Integer.parseInt(uid), user.getUid());
    }
}
