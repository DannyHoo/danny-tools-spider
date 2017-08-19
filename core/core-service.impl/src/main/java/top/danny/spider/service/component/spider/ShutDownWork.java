package top.danny.spider.service.component.spider;

import org.springframework.stereotype.Service;
import top.danny.spider.model.bean.SpiderTask;
import top.danny.spider.model.dto.UrlCache;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ShutDownWork
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-19 10:24:06
 */
public class ShutDownWork extends Thread{

    private Object shutDownTask;
    private String methodName;

    public ShutDownWork(Object shutDownTask,String methodName){
        this.shutDownTask=shutDownTask;
        this.methodName=methodName;
    }

    public static ShutDownWork getInstance(Object shutDownTask,String methodName){
        return new ShutDownWork(shutDownTask,methodName);
    }

    /**
     * This is the right work that will do before the system shutdown
     * 为应用程序的退出增加了一个事件处理，当应用程序退出时候，将剩余任务写入数据库
     */
    @Override
    public void run() {
        try {
            executeMethod(shutDownTask,methodName);

        } catch (Exception ex) {
            System.err.println("exception at ShutDownWork#run()...");
        }
    }

    public void executeMethod(Object shutDownTask,String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz=shutDownTask.getClass();
        Method method=clazz.getMethod(methodName);
        method.setAccessible(true);
        method.invoke(shutDownTask);
    }


}
