package com.mws.service.impl;

import com.mws.mapper.PlayerMapper;
import com.mws.pojo.Player;
import com.mws.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerMapper playerMapper;
    @Override
    public int addPlayer(Player player) {
        return playerMapper.addPlayer(player);
    }

    @Override
    public List<Player> getAllPlayer() {
        return playerMapper.getAllPlayer();
    }
}
