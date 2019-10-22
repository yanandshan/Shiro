package com.qfedu.controller;

import com.qfedu.dao.User;
import com.qfedu.service.UserService;
import com.qfedu.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/10/22 14:47
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/api/user/login")
    public R login(User user){

        System.out.println(user.getUsername());
        System.out.println(user.getPsw());
        return userService.login(user);

    }
}
