package com.learn.song.myspringboot.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.song.myspringboot.entity.User;

/**
 * @author Song
 * @description 针对表【user】的数据库操作Service
 * @createDate 2022-02-23 11:55:49
 */
public interface UserService extends IService<User> {


    /**
     * 新增用户
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    void modifyUser(User user);

}
