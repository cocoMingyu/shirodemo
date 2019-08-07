package com.example.shirodemo.service;

import com.example.shirodemo.model.dao.Users;

import java.util.List;

/**
 * @ Author kn
 * @ Description
 * @ Date 2019/8/3 16:48
 */
public interface UserService {
    Users getUserByName(String name);

    List<Integer> getRoleByUserid(Integer userid);
}
