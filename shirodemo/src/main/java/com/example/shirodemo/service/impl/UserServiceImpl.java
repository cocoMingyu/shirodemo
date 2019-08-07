package com.example.shirodemo.service.impl;

import com.example.shirodemo.mapper.UserMapper;
import com.example.shirodemo.mapper.UserRoleMapper;
import com.example.shirodemo.model.dao.Users;
import com.example.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author kn
 * @ Description
 * @ Date 2019/8/3 16:49
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Users getUserByName(String name){
        Users userByName = userMapper.findUserByName(name);
        return userByName;
    }

    @Override
    public List<Integer> getRoleByUserid(Integer userid){
        List<Integer> roleList = userRoleMapper.getRoleByUserid(userid);
        return roleList;
    }
}
