package com.mws.controller;

import com.mws.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PojoController {

    @RequestMapping("hello")
    public String testPojo(User user) {
        System.out.println(user);
        return "success";
    }
}
