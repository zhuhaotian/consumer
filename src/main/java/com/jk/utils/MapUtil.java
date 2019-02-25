package com.jk.utils;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @Auther: yjm
 * @Date: 2019/2/25 10:14
 * @Description:  map数据操作工具类
 */
public class MapUtil {
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;

        Object obj = beanClass.newInstance();

        BeanUtils.populate(obj, map);

        return obj;
    }

    /**

     对象转map

     @description

     @author tjz

     @param obj

     @return

     @time 2018年2月23日 下午4:31:34
     */
    public static Map<?, ?> objectToMap(Object obj) {
        if (obj == null)
            return null;

        return new BeanMap(obj);
    }

}
