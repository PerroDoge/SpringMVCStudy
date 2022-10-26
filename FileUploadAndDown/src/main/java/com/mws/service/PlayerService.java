package com.mws.service;

import com.mws.pojo.Player;

import java.util.List;


public interface PlayerService {

    int addPlayer(Player player);

    List<Player> getAllPlayer();
}
