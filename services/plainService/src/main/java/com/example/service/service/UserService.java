package com.example.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.service.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

    List<User> findAll();

    void addUser(User user);
}
