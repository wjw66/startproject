package com.wjw.startproject.mapper;

import com.wjw.startproject.StartprojectApplicationTests;
import com.wjw.startproject.domain.entity.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author : wjwjava01@163.com
 * @date : 0:06 2020/4/17
 * @description :
 */
@Slf4j
public class UserMapperTest extends StartprojectApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    public void selectById() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","蛙");
        List<UserDO> userDOS = userMapper.selectByMap(map);
        for (UserDO userDO : userDOS) {
            log.info("{}",userDO);
        }
    }

}