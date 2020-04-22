package com.wjw.startproject.controller;
import com.wjw.startproject.common.PageQuery;
import com.wjw.startproject.common.PageResult;
import com.wjw.startproject.common.ResponseResult;
import com.wjw.startproject.domain.dto.UserDTO;
import com.wjw.startproject.domain.dto.UserQueryDTO;
import com.wjw.startproject.domain.vo.UserVO;
import com.wjw.startproject.exception.ExceptionEnum;
import com.wjw.startproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        //构造查询条件
        PageQuery<UserQueryDTO> pageQuery = new PageQuery<>();
        pageQuery.setPageNo(pageNo);
        pageQuery.setPageSize(pageSize);
        pageQuery.setQuery(query);

        PageResult<List<UserDTO>> pageResult = userService.query(pageQuery);
        //实体转换
        List<UserVO> userVOList = Optional.ofNullable(pageResult.getData()).map(List::stream)
                .orElseGet(Stream::empty)
                .map(userDTO -> {
                    UserVO userVO = new UserVO();
                    BeanUtils.copyProperties(userDTO, userVO);

                    if(!StringUtils.isEmpty(userDTO.getPhone())) {
                        //对电话字段中间4位做加密处理
                        userDTO.setPhone(userDTO.getPhone()
                                .replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
                    }
                    return userVO;
                }).collect(Collectors.toList());

        //封装返回解果
        PageResult<List<UserVO>> result = new PageResult<>();
        BeanUtils.copyProperties(pageResult,result);
        result.setData(userVOList);
        return ResponseResult.success(result);
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
        int i = userService.update(id,userDTO);
        if (i < 1){
            return ResponseResult.failure(ExceptionEnum.UPDATE_FAILURE);
        }
        return ResponseResult.success("更新成功");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable("id")Long id){
        int i = userService.delete(id);
        if (i < 1){
            return ResponseResult.failure(ExceptionEnum.DELETE_FAILURE);
        }
        return ResponseResult.success("删除成功");
    }


}
