package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByLoginName(String loginName) {
        User u = userMapper.selectByLoginName(loginName);
        return u;
    }

    @Override
    public boolean verifyPassword(User user) {
        String password = userMapper.selectPasswordByEmpId(user.getEmpId());
        if (password.equals(user.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public int updatePassword(User user) {
        int update = userMapper.updatePasswordByEmpId(user);
        return update;
    }
}
