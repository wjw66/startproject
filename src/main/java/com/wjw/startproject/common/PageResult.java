package com.wjw.startproject.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : wjwjava01@163.com
 * @date : 23:08 2020/4/16
 * @description :
 */
@Data
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 8502166200409228321L;

    /**
     * 当前页号
     */
    private Integer pageNo;

    /**
     * 每页行数
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 总页数
     */
    private Long pageNum;

    /**
     * 动态内容,作为数据信息的载体
     */
    private T data;
}
