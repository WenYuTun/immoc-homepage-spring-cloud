package com.imooc.homepage.dao;

import com.imooc.homepage.entity.HomepageUserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wyt
 * @description: homepage_user_course数据表访问接口定义
 * @date: 2020/1/4
 * @version: 1.0
 */
public interface HomepageUserCourseDao extends JpaRepository<HomepageUserCourse,Long> {

    /**
     * 通过用户ID查询数据记录
     * @param userId 用户ID
     * @return HomepageUserCourse列表
     */
    List<HomepageUserCourse> findByUserId(Long userId);
}
