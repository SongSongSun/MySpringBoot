package com.learn.song.myspringboot.orm.context;


import org.springframework.util.Assert;

import static com.learn.song.myspringboot.orm.toolkit.TableIndexUtil.generateIndexByCompanyId;

/**
 * @Author Song
 * @Date 2022/7/6 23:52
 * @Version 1.0
 * @Description
 */
public class DynamicTableContext {
    /**
     * 请求参数存取
     */
    private static final ThreadLocal<Integer> TABLE_INDEX = new ThreadLocal<>();


    public static void setTableIndexByCompanyId(Long companyId) {
        int index = generateIndexByCompanyId(companyId);
        setTableIndex(index);
    }

    public static void setTableIndex(Integer tableIndex) {
        Assert.notNull(tableIndex, "分表参数不能为空");
        TABLE_INDEX.set(tableIndex);
    }


    public static Integer getTableIndex() {
        return TABLE_INDEX.get();
    }
}
