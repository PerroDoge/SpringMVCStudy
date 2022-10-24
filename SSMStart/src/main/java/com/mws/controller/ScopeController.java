package com.mws.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ScopeController {

    public String testScope() {

        return "/static/showDataPage.html";
    }
}
