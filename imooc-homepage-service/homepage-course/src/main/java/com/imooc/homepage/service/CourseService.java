package com.imooc.homepage.service;

import com.homepage.immoc.CourseInfo;
import com.homepage.immoc.CourseInfosRequest;

import java.util.List;

/**
 * @author wyt
 * @description: 课程服务接口
 * @date: 2020/1/2
 * @version: 1.0
 */
public interface CourseService {

    /**
     * 通过ID获取课程信息
     *
     * @param id 课程ID
     * @return CourseInfo
     */
    CourseInfo getCourseInfo(Long id);

    /**
     * 通过ids获取课程信息列表
     *
     * @param request 课程请求对象
     * @return
     */
    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}
