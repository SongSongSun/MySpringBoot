package com.learn.song.myspringboot.orm.toolkit;

/**
 * @Author Song
 * @Date 2022/7/7 0:00
 * @Version 1.0
 * @Description
 */
public class TableIndexUtil {
    public static int generateIndexByCompanyId(Long companyId) {
        return (companyId.hashCode() >>> 16) & 7;
    }
}
