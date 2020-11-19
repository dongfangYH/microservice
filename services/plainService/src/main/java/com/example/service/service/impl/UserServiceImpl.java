package com.example.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.service.entity.User;
import com.example.service.mapper.UserMapper;
import com.example.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-11-19 11:29
 **/
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> findAll() {
        List<User> users1 = baseMapper.selectList(null);
        System.out.println(users1);
        List<User> users2 = baseMapper.selectList(null);
        return users2;
    }

    @Override
    public void addUser(User user) {
        baseMapper.insert(user);
    }

}
