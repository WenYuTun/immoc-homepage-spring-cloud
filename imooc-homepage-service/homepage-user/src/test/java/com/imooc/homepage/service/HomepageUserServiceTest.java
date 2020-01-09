package com.imooc.homepage.service;

import com.alibaba.fastjson.JSON;
import com.imooc.homepage.HomepageUserApplication;
import com.imooc.homepage.dao.HomepageUserCourseDao;
import com.imooc.homepage.entity.HomepageUserCourse;
import com.imooc.homepage.vo.CreateUserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author wyt
 * @description: 用户服务测试用例
 * @date: 2020/1/9
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HomepageUserApplication.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HomepageUserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private HomepageUserCourseDao userCourseDao;

    @Test
    public void testCreateUser() {
        userService.createUser(new CreateUserRequest("wenyutun","wenyutun@163.com"));
    }

    @Test
    public void testGetUserInfo() {
        System.out.println(JSON.toJSONString(userService.getUserInfo((2L))));
    }

    @Test
    public void testCreateHomepageUserCourse() {
        HomepageUserCourse course1 = new HomepageUserCourse();
        course1.setUserId(2L);
        course1.setCourseId(1L);

        HomepageUserCourse course2 = new HomepageUserCourse();
        course2.setUserId(2L);
        course2.setCourseId(2L);

        userCourseDao.saveAll(Arrays.asList(course1,course2));

    }
}
