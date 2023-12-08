package com.pichill.util;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

public class testUtil {
    public static <T> T paramMappingFunction(Map<String, String[]> parameterMap, T obj){
        Map<String, Object> map = parameterMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> (Object) entry.getValue()));

        map.forEach((k, v) -> {
            try {
                if(checkFieldExist(obj, k)){
                    if (StringUtils.isNotEmpty(v.toString())) {

                        PropertyUtils.setProperty(obj, k, v);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return obj;
    }

    public static boolean checkFieldExist(Object obj, String fieldName) throws NoSuchFieldException {
        Class<?> clazz = obj.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        System.out.println(field.getName());
        return field != null;
    }
}
