package com.imooc.homepage.service;

import com.homepage.immoc.UserInfo;
import com.imooc.homepage.vo.CreateUserRequest;
import com.imooc.homepage.vo.UserCourseInfo;

/**
 * @author wyt
 * @description: 用户服务接口
 * @date: 2020/1/5
 * @version: 1.0
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param request 用户参数
     * @return UserInfo
     */
    UserInfo createUser(CreateUserRequest request);

    /**
     * 根据ID获取用户信息
     *
     * @param id 用户ID
     * @return UserInfo
     */
    UserInfo getUserInfo(Long id);

    /**
     * 获取用户课程信息
     * @param id ID
     * @return
     */
    UserCourseInfo getUserCourseInfo(Long id);

}
