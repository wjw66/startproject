package com.wjw.startproject.controller;

import com.wjw.startproject.common.PageResult;
import com.wjw.startproject.common.ResponseResult;
import com.wjw.startproject.domain.dto.UserDTO;
import com.wjw.startproject.domain.dto.UserQueryDTO;
import com.wjw.startproject.exception.ExceptionEnum;
import com.wjw.startproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : wjwjava01@163.com
 * @date : 22:25 2020/4/16
 * @description :
 */
@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/query")
    public ResponseResult<PageResult> query(Integer pageNo, Integer pageSize, UserQueryDTO query){
        //userService.query()
        return ResponseResult.success(new PageResult());
    }

    @PostMapping("/save")
    public ResponseResult save(@RequestBody UserDTO userDTO) {
        int i = userService.save(userDTO);
        if (i < 1){
            return ResponseResult.failure(ExceptionEnum.INSERT_FAILURE);
        }
        return ResponseResult.success("新增成功");
    }

    @PutMapping("/update/{id}")
    public ResponseResult update(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {

        return ResponseResult.success("更新成功");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable("id")Long id){

        return ResponseResult.success("删除成功");
    }


}
