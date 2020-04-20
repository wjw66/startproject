package com.wjw.startproject.common;

import com.wjw.startproject.exception.ExceptionEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : wjwjava01@163.com
 * @date : 22:29 2020/4/16
 * @description : 统一返回前端的格式
 */
@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = -5904053270757657969L;
    /**
     * 是否成功
     */
    private boolean success;

    private Integer code;

    private String msg;

    private T data;

    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> success(T data){
        ResponseResult<T> result = new ResponseResult<>();

        result.setSuccess(Boolean.TRUE);
        result.setData(data);

        return result;
    }

    /**
     * 失败
     * @param code
     * @param msg
     * @return
     */
    public static <T> ResponseResult<T> failure(Integer code,String msg){
        ResponseResult<T> result = new ResponseResult<>();

        result.setSuccess(Boolean.FALSE);
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }/**
     * 失败
     * @param exceptionEnum 异常枚举
     * @return
     */
    public static <T> ResponseResult<T> failure(ExceptionEnum exceptionEnum){
        ResponseResult<T> result = new ResponseResult<>();

        result.setSuccess(Boolean.FALSE);
        result.setCode(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());

        return result;
    }
}
