package com.mws.mapper;

import com.mws.pojo.User;

public interface UserMapper {

    public User findUserByNameAndPassword(User user);
}
