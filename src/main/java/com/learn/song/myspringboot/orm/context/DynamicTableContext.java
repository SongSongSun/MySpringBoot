package com.learn.song.myspringboot.orm.context;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import java.util.Map;

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
    private static final ThreadLocal<Map<String, Object>> REQUEST_DATA = new ThreadLocal<>();
    private static final ThreadLocal<Integer> TABLE_INDEX = new ThreadLocal<>();

    /**
     * 设置请求参数
     *
     * @param requestData 请求参数 MAP 对象
     */
    public static void setRequestData(Map<String, Object> requestData) {
        REQUEST_DATA.set(requestData);
    }

    /**
     * 获取请求参数
     *
     * @param param 请求参数
     * @return 请求参数 MAP 对象
     */
    public static <T> T getRequestData(String param) {
        Map<String, Object> dataMap = getRequestData();
        if (CollectionUtils.isNotEmpty(dataMap)) {
            return (T) dataMap.get(param);
        }
        return null;
    }

    /**
     * 获取请求参数
     *
     * @return 请求参数 MAP 对象
     */
    public static Map<String, Object> getRequestData() {
        return REQUEST_DATA.get();
    }

    public static void setTableIndex(Long companyId) {
        int index = generateIndexByCompanyId(companyId);
        TABLE_INDEX.set(index);
    }

    public static Integer getTableIndex() {
        return TABLE_INDEX.get();
    }
}
