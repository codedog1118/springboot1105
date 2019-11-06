package com.kjlw.springboot1105.service;

import com.kjlw.springboot1105.entity.User;
import com.kjlw.springboot1105.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.showAllUser();
    }
}
