package top.danny.spider.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ApplicationContextHelper
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-23 15:47:47
 */
@Component
public class ApplicationContextHelper implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext contex) throws BeansException {
        ApplicationContextHelper.context = contex;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
