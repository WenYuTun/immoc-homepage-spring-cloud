package com.imooc.homepage.dao;

import com.imooc.homepage.entity.HomepageCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wyt
 * @description: 课程dao
 * @date: 2019/12/30
 * @version: 1.0
 */
@Repository
public interface HomepageCourseDao extends JpaRepository<HomepageCourse,Long> {


}
