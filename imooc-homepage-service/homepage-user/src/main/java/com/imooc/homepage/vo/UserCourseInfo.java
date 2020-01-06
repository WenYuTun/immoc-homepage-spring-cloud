package com.imooc.homepage.vo;

import com.homepage.immoc.CourseInfo;
import com.homepage.immoc.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author wyt
 * @description: 用户课程信息视图模型定义
 * @date: 2020/1/5
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseInfo {

    private UserInfo userInfo;

    private List<CourseInfo> courseInfos;

    public static UserCourseInfo invalid(){
        return new UserCourseInfo(UserInfo.invalid(), Collections.emptyList());
    }
}
