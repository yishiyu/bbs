package com.jiading.service;


import com.jiading.domain.User;
import org.springframework.stereotype.Service;

@Service("userService")
public interface UserService {

    boolean regist(User user);

    boolean active(String code);

    User login(User user);
}
