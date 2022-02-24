package com.learn.song.myspringboot.service.impl;

import com.learn.song.myspringboot.entity.domain.User;
import com.learn.song.myspringboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yijinsong@lingxing.com
 * @since 2022-02-23
 */
@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    void testAddUser() {
        User user = new User();
        user.setName("B");
        user.setAge(60);
        user.setEmail("test1@qq.com");
        userService.addUser(user);
    }
}