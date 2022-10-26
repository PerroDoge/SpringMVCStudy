package com.mws.mapper;

import com.mws.pojo.Player;

import java.util.List;

public interface PlayerMapper {

    int addPlayer(Player player);

    List<Player> getAllPlayer();
}
