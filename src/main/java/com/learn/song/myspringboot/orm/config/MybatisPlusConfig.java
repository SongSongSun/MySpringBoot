package com.learn.song.myspringboot.orm.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.learn.song.myspringboot.orm.handler.SongTableNameHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Author Song
 * @Date 2022/7/6 23:50
 * @Version 1.0
 * @Description
 */
@Configuration
@MapperScan("com.baomidou.mybatisplus.samples.dytablename.mapper")
public class MybatisPlusConfig {
    @Resource
    private SongTableNameHandler songTableNameHandler;

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
        dynamicTableNameInnerInterceptor.setTableNameHandler(songTableNameHandler);
        interceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);
        return interceptor;
    }
}
