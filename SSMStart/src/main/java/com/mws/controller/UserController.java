package com.mws.controller;

import com.mws.pojo.User;
import com.mws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("findUserByNameAndPassword")
    public int findUserByNameAndPassword(User user) {
        System.out.println(user.getUser_name());
        System.out.println(user.getUser_password());
        return userService.findUserByNameAndPassword(user);
    }

}
