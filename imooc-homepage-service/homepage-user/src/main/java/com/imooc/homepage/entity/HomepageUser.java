package com.imooc.homepage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wyt
 * @description: home-age_user对应的实体类定义
 * @date: 2020/1/4
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "homepage_user")
public class HomepageUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "user_name",nullable = false)
    private String userName;

    @Basic
    @Column(name = "email" ,nullable = false)
    private String email;

    @Basic
    @Column(name = "create_time", nullable = false)
    @CreatedDate
    private Date createTime;

    @Basic
    @Column(name = "update_time", nullable = false)
    @LastModifiedDate
    private Date updateTime;

    public HomepageUser(String userName,String email){
       this.userName = userName;
       this.email = email;
    }

    public static HomepageUser invalid() {
        final HomepageUser homepageUser = new HomepageUser("", "");
        homepageUser.setId(-1L);
        return homepageUser;
    }


}
