package com.homepage.immoc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wyt
 * @description: 课程信息请求对象定义
 * @date: 2019/12/29
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfosRequest {
    private List<Long> ids;
}
