package com.homepage.immoc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wyt
 * @description: 基本的用户信息
 * @date: 2019/12/29
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Long id;
    private String userName;
    private String email;

    public static UserInfo invalid() {
        return new UserInfo(-1L,"","");
    }
}
