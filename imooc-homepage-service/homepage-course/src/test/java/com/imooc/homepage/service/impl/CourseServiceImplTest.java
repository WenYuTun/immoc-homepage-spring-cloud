package com.imooc.homepage.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.homepage.immoc.CourseInfo;
import com.homepage.immoc.CourseInfosRequest;
import com.imooc.homepage.HomepageCourseApplication;
import com.imooc.homepage.dao.HomepageCourseDao;
import com.imooc.homepage.entity.HomepageCourse;
import com.imooc.homepage.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HomepageCourseApplication.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CourseServiceImplTest {

    @Autowired
    private HomepageCourseDao courseDao;

    @Autowired
    private CourseService courseService;

    @Test
    public void getCourseInfo() {
        final CourseInfo courseInfo = courseService.getCourseInfo(1L);
        System.out.println(JSON.toJSONString(courseInfo));

        final CourseInfo courseInfo1 = courseService.getCourseInfo(3L);

        System.out.println(JSON.toJSONString(courseInfo1));

    }

    @Test
    public void getCourseInfos() {
        final List<CourseInfo> courseInfos = courseService.getCourseInfos(new CourseInfosRequest(Arrays.asList(1L,
                2L)));
        System.out.println(JSON.toJSONString(courseInfos));
    }

    @Test
    public void testCreatCourseInfo() {
        HomepageCourse course = new HomepageCourse(
                "JDK11新特性解读",
                0,
                "http://www/imooc.com",
                "解读JDK11的版本新特新");
        HomepageCourse course1 = new HomepageCourse(
                "SpringBoot2.X实战",
                1,
                "http://www.immoc.com",
                "SpringBoot2.X实战课程");

        courseDao.saveAll(Arrays.asList(course,course1));
    }



}