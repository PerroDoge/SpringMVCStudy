package com.mws.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mws.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class AJAXController {

    @ResponseBody
    @RequestMapping("/testAJAX")
    public User testAJAX(User user) {
        ObjectMapper om = new ObjectMapper();
        String s = "null";
        try {
            s = om.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(s);
        return new User(1, "ShouHe", "Doge1586288");
    }
}
