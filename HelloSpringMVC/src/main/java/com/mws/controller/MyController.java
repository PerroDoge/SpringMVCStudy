package com.mws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/firstController.do")
    public String firstController() {
        System.out.println("firstController");
        return "first";
    }
}
