package com.wjw.startproject.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : wjwjava01@163.com
 * @date : 22:23 2020/4/16
 * @description :
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = -5224188223546669850L;

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
