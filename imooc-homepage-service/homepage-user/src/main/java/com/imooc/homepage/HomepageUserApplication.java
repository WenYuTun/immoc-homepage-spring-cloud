package com.imooc.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author wyt
 * @description: 用户服务入口
 * @date: 2020/1/4
 * @version: 1.0
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class HomepageUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomepageUserApplication.class, args);
    }
}
