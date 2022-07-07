package com.learn.song.myspringboot.orm.handler;

import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.learn.song.myspringboot.orm.context.DynamicTableContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Song
 * @Date 2022/7/6 23:54
 * @Version 1.0
 * @Description
 */
@Component
@Slf4j
public class SongTableNameHandler implements TableNameHandler {
    private final List<String> handleTableNameList = Arrays.asList("user");

    @Override
    public String dynamicTableName(String sql, String tableName) {
        log.info("拦截前的sql:{}", sql);
        if (handleTableNameList.contains(tableName)) {
            Integer tableIndex = DynamicTableContext.getTableIndex();
            return StrUtil.join(StrPool.UNDERLINE, tableName, tableIndex);
        } else {
            return tableName;
        }
    }

}


