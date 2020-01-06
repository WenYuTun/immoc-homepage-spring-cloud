package com.imooc.homepage.client;

import com.homepage.immoc.CourseInfo;
import com.homepage.immoc.CourseInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author wyt
 * @description: 课程服务熔断降级策略
 * @date: 2020/1/4
 * @version: 1.0
 */
@Component
public class CourseClientHystrix implements CourseClient {
    @Override
    public CourseInfo getCourseInfo(Long id) {
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
