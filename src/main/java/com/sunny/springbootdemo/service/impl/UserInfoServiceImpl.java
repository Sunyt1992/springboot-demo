package com.sunny.springbootdemo.service.impl;

import com.sunny.springbootdemo.mapper.UserInfoMapper;
import com.sunny.springbootdemo.model.pojo.UserInfo;
import com.sunny.springbootdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: springboot-demo
 * @package: com.sunny.springbootdemo.service.impl
 * @className: UserInfoServiceImpl
 * @author: sunyingtao
 * @description: TODO
 * @date: 2022/11/13 14:36
 * @version: 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void add(UserInfo userInfo) {
        userInfoMapper.add(userInfo);
    }

    @Override
    public void delete(Integer id) {
        userInfoMapper.delete(id);
    }

    @Override
    public void update(UserInfo userInfo) {
        userInfoMapper.update(userInfo);
    }

    @Override
    public UserInfo queryById(Integer id) {
        return userInfoMapper.queryById(id);
    }

    @Override
    public List<UserInfo> queryAll() {
        return userInfoMapper.queryAll();
    }
}

