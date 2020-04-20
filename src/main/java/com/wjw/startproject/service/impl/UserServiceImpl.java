package com.wjw.startproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjw.startproject.common.PageQuery;
import com.wjw.startproject.common.PageResult;
import com.wjw.startproject.domain.dto.UserDTO;
import com.wjw.startproject.domain.dto.UserQueryDTO;
import com.wjw.startproject.domain.entity.UserDO;
import com.wjw.startproject.mapper.UserMapper;
import com.wjw.startproject.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : wjwjava01@163.com
 * @date : 21:04 2020/4/17
 * @description : UserService实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    /**
     * 保存
     *
     * @param userDTO
     * @return
     */
    @Override
    public int save(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        //浅拷贝 属性名必须相同才能拷贝
        BeanUtils.copyProperties(userDTO,userDO);
        return userMapper.insert(userDO);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Long id) {
        return userMapper.deleteById(id);
    }

    /**
     * 修改
     *
     * @param id
     * @param userDTO
     * @return
     */
    @Override
    public int update(Long id, UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO,userDO);
        //保证id的正确性
        userDO.setId(id);
        return userMapper.updateById(userDO);
    }

    /**
     * 分页查询
     *
     * @param pageQuery 分页查询对象
     * @return 返回分页对象
     */
    @Override
    public PageResult<List<UserDTO>> query(PageQuery<UserQueryDTO> pageQuery) {
        //构建一个page参数
        Page page = new Page(pageQuery.getPageNo(), pageQuery.getPageSize());
        UserDO query = new UserDO();
        BeanUtils.copyProperties(pageQuery.getQuery(),query);
        //TODO 如果有属性不一致的情况,需要特殊处理,比如query里要查询从某个时间到某个时间

        //包装一下query
        QueryWrapper queryWrapper = new QueryWrapper(query);
        //查询
        IPage<UserDO> userDOPage = userMapper.selectPage(page, queryWrapper);

        //结果解析
        PageResult pageResult = new PageResult();
        pageResult.setPageNo((int) userDOPage.getCurrent());
        pageResult.setPageSize((int) userDOPage.getSize());
        pageResult.setTotal(userDOPage.getTotal());
        pageResult.setPageNum(userDOPage.getPages());

        //对数据进行转换
        List<UserDTO> userDTOList = Optional.ofNullable(userDOPage.getRecords())
                .map(List::stream)
                .orElseGet(Stream::empty)
                .map(userDO -> {
                    UserDTO userDTO = new UserDTO();
                    BeanUtils.copyProperties(userDO, userDTO);
                    return userDTO;
                }).collect(Collectors.toList());

        pageResult.setData(userDTOList);
        return pageResult;
    }
}
