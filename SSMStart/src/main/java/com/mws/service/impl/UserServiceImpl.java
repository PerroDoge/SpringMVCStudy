package com.mws.service.impl;

import com.mws.mapper.UserMapper;
import com.mws.pojo.User;
import com.mws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int findUserByNameAndPassword(User user) {
        User result = userMapper.findUserByNameAndPassword(user);

        return result == null ? 0 : 1;
    }
}
