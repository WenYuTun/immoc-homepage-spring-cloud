package com.imooc.homepage.client;

import com.homepage.immoc.CourseInfo;
import com.homepage.immoc.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author wyt
 * @description: 通过Feign访问课程服务
 * @date: 2020/1/4
 * @version: 1.0
 */
@FeignClient(value = "eureka-client-homepage-course",fallback = CourseClientHystrix.class)
public interface CourseClient {

    /**
     * 调用课程服务，通过ID获取课程信息接口
     *
     * @param id 课程id
     * @return CourseInfo
     */
    @RequestMapping(value = "homepage-course/get/course", method = RequestMethod.GET)
    CourseInfo getCourseInfo(Long id);

    /**
     * 调用课程服务，通过CourseInfosRequest请求实体获取课程信息列表接口
     *
     * @param request 请求参数实体
     * @return CourseInfo列表
     */
    @RequestMapping(value = "homepage-course/get/courses", method = RequestMethod.POST)
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);
}
