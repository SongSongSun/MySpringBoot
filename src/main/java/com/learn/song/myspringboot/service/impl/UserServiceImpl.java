package com.learn.song.myspringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.song.myspringboot.orm.context.DynamicTableContext;
import com.learn.song.myspringboot.entity.User;
import com.learn.song.myspringboot.service.UserService;
import com.learn.song.myspringboot.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Song
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-02-23 11:55:49
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(User user) {
        DynamicTableContext.setTableIndex(12312L);
        this.save(user);
        //modifyUser(user);
    }

    @Override
    public void modifyUser(User user) {
        user.setAge(20);
        this.updateById(user);
    }
}




