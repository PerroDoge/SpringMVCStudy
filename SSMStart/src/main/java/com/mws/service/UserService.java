package com.mws.service;

import com.mws.pojo.User;

public interface UserService {

    public int findUserByNameAndPassword(User user);
}
