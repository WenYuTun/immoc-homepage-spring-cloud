package com.imooc.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.homepage.immoc.UserInfo;
import com.imooc.homepage.service.UserService;
import com.imooc.homepage.vo.CreateUserRequest;
import com.imooc.homepage.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyt
 * @description: 用户服务对外接口
 * @date: 2020/1/9
 * @version: 1.0
 */
@Slf4j
@RestController
public class HomepageUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request){
        log.info("<homepage-user>:create user -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }

    @GetMapping("/get/user")
    public UserInfo getUserInfo(Long id) {
        return userService.getUserInfo(id);
    }

    @GetMapping("/get/user/course")
    public UserCourseInfo getUserCourseInfo(Long id){
        return userService.getUserCourseInfo(id);
    }
}
