package com.wjw.startproject.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : wjwjava01@163.com
 * @date : 20:42 2020/4/17
 * @description : 通用分页查询对象
 */
@Data
public class PageQuery<T> implements Serializable {

    private static final long serialVersionUID = 6399264053077803900L;
    /**
     * 当前页,默认为1
     */
    private Integer pageNo = 1;
    /**
     * 每页条数,默认20
     */
    private Integer pageSize = 20;
    /**
     * 动态的查询数据
     */
    private T query;
}
