package com.sunny.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.sunny.springbootdemo.model.pojo.UserInfo;
import com.sunny.springbootdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: springboot-demo
 * @package: com.sunny.springbootdemo.controller
 * @className: UserInfoController
 * @author: sunyingtao
 * @description: TODO
 * @date: 2022/11/13 14:38
 * @version: 1.0
 */

@RestController
@RequestMapping(value = "/test")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public List<UserInfo> queryAll(){
        List<UserInfo> userInfoList = userInfoService.queryAll();
        return userInfoList;
    }

    //使用了RestFull风格
    @GetMapping("/{id}")
    public String query(@PathVariable(value = "id")Integer id){
        UserInfo userInfo = userInfoService.queryById(id);
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(userInfo);
        return JSON.toJSONString(userInfoList);
    }

    //post请求
    //@RequestBody 表示接收请求是JSON格式的数据
    @PostMapping
    public String add(@RequestBody UserInfo userInfo){
        userInfoService.add(userInfo);
        return "添加OK";
    }

    //Delete请求
    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id")Integer id){
        userInfoService.delete(id);
        return "删除成功";
    }

    //Put请求
    @PutMapping("/{id}")
    public String update(@PathVariable("id")Integer id,
                         @RequestBody UserInfo userInfo){
        userInfo.setId(id);
        userInfoService.update(userInfo);
        return "修改成功";
    }
}

