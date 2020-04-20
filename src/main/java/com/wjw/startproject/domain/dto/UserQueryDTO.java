package com.wjw.startproject.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : wjwjava01@163.com
 * @date : 23:05 2020/4/16
 * @description :
 */

@Data
public class UserQueryDTO implements Serializable {

    private static final long serialVersionUID = -4602186315874944610L;

    /*** 用户主体信息 ***/
    private String username;

}
