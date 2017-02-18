package top.danny.spider.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.NestedRuntimeException;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 16:33:41
 */
public class BaseServiceImpl {

    protected <T> T convertIgnoreNullProperty(Object source, Class<T> targetClass) {
        return convert(source, targetClass);
    }

    protected  <T> List<T> convertList(List<?> sourceList, Class<T> targetClass) {
        return convert(sourceList, targetClass);
    }

    private static <T> T convert(Object source, Class<T> targetClass) {
        return convert(source, targetClass, (String[])null);
    }

    private static <T> List<T> convert(List<?> sourceList, Class<T> targetClass) {
        return convert(sourceList, targetClass, false);
    }

    private static <T> List<T> convert(List<?> sourceList, Class<T> targetClass, boolean isIgnoreProperties) {
        if (sourceList == null || sourceList.size() == 0) {
            return new ArrayList<T>(0);
        }
        List<T> list = new ArrayList<T>(sourceList.size());
        for (Object obj: sourceList) {
            String[] ignoreProperties = (String[])null;
            if (isIgnoreProperties) {
                ignoreProperties = getNullPropertyNames(obj);
            }
            list.add(convert(obj, targetClass, ignoreProperties));
        }
        return list;
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (PropertyDescriptor pd: pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    private static <T> T convert(Object source, Class<T> targetClass, String... ignoreProperties) {
        if (source == null) {
            return null;
        }
        try {
            T target = targetClass.newInstance();
            BeanUtils.copyProperties(source, target, ignoreProperties);
            return target;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
