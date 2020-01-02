package com.imooc.homepage.service.impl;

import com.homepage.immoc.CourseInfo;
import com.homepage.immoc.CourseInfosRequest;
import com.imooc.homepage.dao.HomepageCourseDao;
import com.imooc.homepage.entity.HomepageCourse;
import com.imooc.homepage.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author wyt
 * @description: 课程服务业务实现
 * @date: 2020/1/2
 * @version: 1.0
 */
@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private HomepageCourseDao homepageCourseDao;

    @Override
    public CourseInfo getCourseInfo(Long id) {
        final Optional<HomepageCourse> course = homepageCourseDao.findById(id);
        return buildCourseInfo(course.orElse(HomepageCourse.invalid()));

    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        if(CollectionUtils.isEmpty(request.getIds())) {
            return Collections.emptyList();
        }
        final List<HomepageCourse> courses = homepageCourseDao.findAllById(request.getIds());
        return courses.stream().map(this::buildCourseInfo).collect(Collectors.toList());
    }

    /**
     * 根据数据记录构造对象信息
     *
     * @param course HomepageCourse信息
     * @return
     */
    private CourseInfo buildCourseInfo(HomepageCourse course) {
        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseIcon(course.getCourseIcon())
                .courseType(course.getCourseType() == 0 ? "免费课程" : "实战课程")
                .courseIntro(course.getCourseIntro())
                .build();
    }
}
