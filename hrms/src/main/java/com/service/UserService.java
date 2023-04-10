package com.service;

import com.pojo.User;

public interface UserService {

    User selectByLoginName(String loginName);

    boolean verifyPassword(User user);

    int updatePassword(User user);

}
