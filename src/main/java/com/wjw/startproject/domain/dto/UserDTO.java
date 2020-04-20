package com.wjw.startproject.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : wjwjava01@163.com
 * @date : 22:21 2020/4/16
 * @description :
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -7345971789519889763L;

    /*** 用户主体信息 ***/
    private String username;

    private String password;

    private String email;

    private Integer age;

    private String phone;

    /**
     * 版本号
     */
    private Long version;
}
