package com.imooc.homepage.dao;

import com.imooc.homepage.entity.HomepageUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wyt
 * @description: homepage_user数据表访问接口定义
 * @date: 2020/1/4
 * @version: 1.0
 */
public interface HomepageUserDao extends JpaRepository<HomepageUser,Long> {

    /**
     * 通过用户名查询
     * @param userName 用户名
     * @return HomepageUser
     */
    HomepageUser findByUserName(String userName);
}
