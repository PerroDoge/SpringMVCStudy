package com.mws.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

    @RequestMapping("/hello/{id}/{name}")
    public String testRestful(@PathVariable String id, @PathVariable String name) {
        System.out.println(id + ":" + name);
        return "success";
    }

}
