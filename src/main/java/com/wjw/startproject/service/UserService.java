package com.wjw.startproject.service;

import com.wjw.startproject.common.PageQuery;
import com.wjw.startproject.common.PageResult;
import com.wjw.startproject.domain.dto.UserDTO;
import com.wjw.startproject.domain.dto.UserQueryDTO;

import java.util.List;

/**
 * @author : wjwjava01@163.com
 * @date : 20:35 2020/4/17
 * @description : user的增删改查
 */
public interface UserService {
    /**
     * 保存
     * @param userDTO
     * @return
     */
    int save(UserDTO userDTO);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 修改
     * @param id
     * @param userDTO
     * @return
     */
    int update(Long id,UserDTO userDTO);

    /**
     * 分页查询
     * @param pageQuery 分页查询对象
     * @return 返回分页对象
     */
    PageResult<List<UserDTO>> query(PageQuery<UserQueryDTO> pageQuery);
}
