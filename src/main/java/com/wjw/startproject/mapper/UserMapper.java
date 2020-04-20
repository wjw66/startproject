package com.wjw.startproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjw.startproject.domain.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : wjwjava01@163.com
 * @date : 23:20 2020/4/16
 * @description :
 */

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
