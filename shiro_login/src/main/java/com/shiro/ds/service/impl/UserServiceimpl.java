package com.shiro.ds.service.impl;

import com.shiro.ds.mapper.RoleMapper;
import com.shiro.ds.mapper.UserMapper;
import com.shiro.ds.pojo.AccountUser;
import com.shiro.ds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public AccountUser getUserInfoByName(String username) {
//        使用xml查询
        return userMapper.getUserInfo(username);
    }

    @Override
    public LinkedList<Integer> findUserByName(String username) {
        return roleMapper.findUserByName(username);
    }




}
