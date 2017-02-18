package top.danny.spider.controller.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DemoTimer
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 20:59:43
 */
@Component
public class DemoTimer {

    @Scheduled(cron = "1/5 * * * * ?" )
    public void demoTest(){
        System.out.println("test");
    }
}
