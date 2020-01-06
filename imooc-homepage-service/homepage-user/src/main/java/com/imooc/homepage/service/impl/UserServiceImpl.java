package com.imooc.homepage.service.impl;

import com.homepage.immoc.CourseInfo;
import com.homepage.immoc.CourseInfosRequest;
import com.homepage.immoc.UserInfo;
import com.imooc.homepage.client.CourseClient;
import com.imooc.homepage.dao.HomepageUserCourseDao;
import com.imooc.homepage.dao.HomepageUserDao;
import com.imooc.homepage.entity.HomepageUser;
import com.imooc.homepage.entity.HomepageUserCourse;
import com.imooc.homepage.service.UserService;
import com.imooc.homepage.vo.CreateUserRequest;
import com.imooc.homepage.vo.UserCourseInfo;
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
 * @description: 用户服务业务实现
 * @date: 2020/1/5
 * @version: 1.0
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private HomepageUserDao userDao;

    @Autowired
    private HomepageUserCourseDao userCourseDao;

    @Autowired
    private CourseClient courseClient;

    @Override
    public UserInfo createUser(CreateUserRequest request) {
        if (!request.validate()) {
            return UserInfo.invalid();
        }
        HomepageUser oldUser = userDao.findByUserName(request.getUserName());
        if (oldUser != null) {
            return UserInfo.invalid();
        }
        final HomepageUser newUser = userDao.save(new HomepageUser(request.getUserName(), request.getEmail()));
        return new UserInfo(newUser.getId(), newUser.getUserName(), newUser.getEmail());
    }

    @Override
    public UserInfo getUserInfo(Long id) {
        final Optional<HomepageUser> user = userDao.findById(id);
        if (!user.isPresent()) {
            return UserInfo.invalid();
        }
        final HomepageUser homepageUser = user.get();
        return new UserInfo(homepageUser.getId(), homepageUser.getUserName(), homepageUser.getEmail());
    }

    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {
        final Optional<HomepageUser> user = userDao.findById(id);
        if (!user.isPresent()) {
            return UserCourseInfo.invalid();
        }
        final HomepageUser homepageUser = user.get();
        final UserInfo userInfo = new UserInfo(homepageUser.getId(), homepageUser.getUserName(),
                homepageUser.getEmail());
        final List<HomepageUserCourse> userCourses = userCourseDao.findByUserId(id);
        if (CollectionUtils.isEmpty(userCourses)) {
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }
        final List<CourseInfo> courseInfos =
                courseClient.getCourseInfos(new CourseInfosRequest(userCourses.stream()
                        .map(HomepageUserCourse::getCourseId).collect(Collectors.toList())));
        return new UserCourseInfo(userInfo,courseInfos);
    }
}
