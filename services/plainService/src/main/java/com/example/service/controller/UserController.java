package com.example.service.controller;

import com.example.service.entity.User;
import com.example.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-11-19 13:12
 **/
@Slf4j
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PutMapping("/user/add")
    public String addUser(){
        User user = new User();
        user.setName("tom");
        user.setAge(14);
        user.setEmail("tom-hammas@qq.com");
        user.setCreateTime(new Date());
        userService.addUser(user);
        return "success!";
    }

    @GetMapping("/user/all")
    public List<User> findUser(){
        return userService.findAll();
    }
}
