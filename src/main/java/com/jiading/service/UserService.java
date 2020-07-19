package com.jiading.service;


import com.jiading.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public interface UserService {

    boolean register(User user);

    boolean active(String code, String username);

    User login(User user);

}
