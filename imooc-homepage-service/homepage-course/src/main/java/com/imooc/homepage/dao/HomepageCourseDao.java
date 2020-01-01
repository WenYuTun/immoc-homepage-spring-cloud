package com.imooc.homepage.dao;

import com.imooc.homepage.entity.HomepageCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wyt
 * @description: 课程dao
 * @date: 2019/12/30
 * @version: 1.0
 */
public interface HomepageCourseDao extends JpaRepository<HomepageCourse,Long> {


}
