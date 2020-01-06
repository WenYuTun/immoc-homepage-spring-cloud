package com.imooc.homepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @author wyt
 * @description: 用户创建请求类
 * @date: 2020/1/4
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String userName;

    private String email;

    public boolean validate() {
        return StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(email);
    }
}
