package com.learn.song.myspringboot.service.impl;

import com.learn.song.myspringboot.orm.context.DynamicTableContext;
import com.learn.song.myspringboot.entity.User;
import com.learn.song.myspringboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;

import java.util.List;

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
        user.setName("A");
        user.setAge(60);
        user.setEmail("test1@qq.com");
        userService.addUser(user);
    }

    @Test
    void testSelect() {
        DynamicTableContext.setTableIndex(12312L);
        List<User> list = userService.list();
        Assert.notEmpty(list, "查询结果为空");
    }
}