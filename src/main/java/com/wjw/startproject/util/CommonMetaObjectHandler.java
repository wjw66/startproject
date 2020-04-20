package com.wjw.startproject.util;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author : wjwjava01@163.com
 * @date : 20:02 2020/4/18
 * @description : 元数据处理器，用于自动生成数据库必要的字段默认值
 */
@Slf4j
@Component
public class CommonMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入元对象字段填充（用于插入时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("新建时,开始填充系统字段");
        //传入的对象,字段,类型,值
        //创建时间
        this.strictInsertFill(metaObject, "created", LocalDateTime.class, LocalDateTime.now());
        //修改时间
        this.strictInsertFill(metaObject, "modified", LocalDateTime.class, LocalDateTime.now());
        //创建者
        this.strictInsertFill(metaObject, "creator", String.class, "从登陆人中获取信息");
        //最后修改人
        this.strictInsertFill(metaObject, "operator", String.class, "蛙");
        //逻辑删除: 0 正常 1 删除
        this.strictInsertFill(metaObject, "status", Integer.class, 0);
        //版本号
        this.strictInsertFill(metaObject, "version", Long.class, 1L);

    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        //修改时间
        this.strictUpdateFill(metaObject, "modified", LocalDateTime.class, LocalDateTime.now());
        //最后修改人
        this.strictUpdateFill(metaObject, "operator", String.class, "蛙");
    }
}
