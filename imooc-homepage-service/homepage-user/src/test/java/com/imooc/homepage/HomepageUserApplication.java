package com.imooc.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wyt
 * @description: 用户服务测试入口
 * @date: 2020/1/2
 * @version: 1.0
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.imooc.homepage"})
public class HomepageUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomepageUserApplication.class,args);
    }

}
