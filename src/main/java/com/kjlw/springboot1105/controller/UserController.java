package com.kjlw.springboot1105.controller;

import com.kjlw.springboot1105.entity.User;
import com.kjlw.springboot1105.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private List<User> userList = Collections.synchronizedList(new ArrayList<User>());

    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public List<User> getUserList(){
        userList = userService.getUserList();
        return userList;
    }
}
