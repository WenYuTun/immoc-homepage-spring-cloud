package com.imooc.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author wyt
 * @description: 课程服务启动类
 * @date: 2019/12/30
 * @version: 1.0
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
public class HomepageCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomepageCourseApplication.class, args);
    }

}
