package com.jiading.service.impl;


import com.jiading.dao.UserDao;
import com.jiading.domain.User;
import com.jiading.service.UserService;
import com.jiading.util.MailUtils;
import com.jiading.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao ;

    /*
    注册用户
     */
    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
        User byUsername = userDao.findByUsername(user);
        if (byUsername != null) {
            //用户名存在，注册失败
            return false;
        } else {
            //2.保存用户信息
            //设置激活码
            user.setCode(UuidUtil.getUuid());
            //设置激活状态
            user.setStatus("N");
            userDao.saveUser(user);
            //发送激活邮件
            String context = "<a href='http://localhost/travel/user/active?code=" + user.getCode() + "'>点击激活【黑马旅游网】</a>";
            MailUtils.sendMail(user.getEmail(),context,"激活邮件");
            return true;
        }
    }

    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user=userDao.findByCode(code);
        //2.调用dao的修改激活状态的方法
        if(user!=null){
            userDao.updateStatus(user);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user);
    }
}
