package com.mws.controller;

import com.mws.pojo.Player;
import com.mws.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    PlayerService playerService;


    @RequestMapping("addPlayer")
    public String addPlayer(Player player) {
        System.out.println(player);
        int result = playerService.addPlayer(player);
        System.out.println(result);
        return "redirect:/static/showPlayerPage.html";
    }

    @ResponseBody
    @RequestMapping("getAllPlayer")
    public List<Player> getAllPlayer() {
        System.out.println("getAllPlayer invoked");
        return playerService.getAllPlayer();
    }
}
