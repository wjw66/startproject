package com.wjw.startproject.service.impl;

import com.wjw.startproject.StartprojectApplicationTests;
import com.wjw.startproject.domain.dto.UserDTO;
import com.wjw.startproject.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : wjwjava01@163.com
 * @date : 23:02 2020/4/17
 * @description :
 */
public class UserServiceImplTest extends StartprojectApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void save() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("小娃");
        userDTO.setPassword("1243243");
        userDTO.setEmail("1312@163.com");
        userDTO.setAge(20);
        userDTO.setPhone("124324");
        userDTO.setVersion(1L);
        int save = userService.save(userDTO);

        Assert.assertEquals(1,save);
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
        UserDTO userDTO = new UserDTO();

    }

    @Test
    public void query() {
    }
}