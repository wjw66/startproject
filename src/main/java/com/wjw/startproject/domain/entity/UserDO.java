package com.wjw.startproject.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : wjwjava01@163.com
 * @date : 19:49 2020/4/16
 * @description :
 */
@Data
@TableName("user")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 6645339030707442455L;

    /*** 用户主体信息 ***/
    private String username;

    private String password;

    private String email;

    private Integer age;

    private String phone;

    /*** 数据库主体信息 ***/

    /**
     * 主键
     * @TableId: 用于自动的id生成策略为 ASSIGN_ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime created;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modified;

    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private String creator;

    /**
     * 最后修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String operator;

    /**
     * 逻辑删除: 0 正常 1 删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer status;

    /**
     * 版本号
     * @Version 在执行(update/insert)sql时自动识别version字段并加1
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Long version;
}
