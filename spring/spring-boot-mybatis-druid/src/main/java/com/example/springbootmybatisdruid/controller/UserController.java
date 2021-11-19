package com.example.springbootmybatisdruid.controller;


import com.example.springbootmybatisdruid.mapper.UserMapper;
import com.example.springbootmybatisdruid.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/users")
    public List<User> queryUsers(){
        return userMapper.selectAll();
    }
}
