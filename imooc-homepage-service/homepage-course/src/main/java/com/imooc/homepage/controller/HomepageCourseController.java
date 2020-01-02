package com.imooc.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.homepage.immoc.CourseInfo;
import com.homepage.immoc.CourseInfosRequest;
import com.imooc.homepage.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wyt
 * @description: 课程服务对外接口
 * @date: 2020/1/2
 * @version: 1.0
 */
@Slf4j
@RestController
public class HomepageCourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/get/course")
    public CourseInfo getCourseInfo(Long id) {
        log.info("<homepage-course>: get course -> {}", id);
        return courseService.getCourseInfo(id);
    }

    @PostMapping(value = "get/courses")
    public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request) {
        log.info("<homepage-course>: get courses -> {}", JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }
}
