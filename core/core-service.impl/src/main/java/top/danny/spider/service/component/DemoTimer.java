package top.danny.spider.service.component;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.danny.spider.model.bean.User;
import top.danny.spider.service.UserService;

import java.util.Date;

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
    @Autowired
    private UserService userService;

    @Scheduled(cron = "0/5 * * * * ?" )
    public void demoTest(){

        System.out.println("hello");
    }

    public void saveUserTest() {
        User user = getUser();
        User userSaved = userService.saveUser(user);
        Assert.assertNotNull(userSaved);
    }

    private User getUser() {
        User user = new User();
        user.setUserName("danny")
                .setPassword("123456")
                .setRealName("定时器")
                .setIdCardNo("187302199009098918")
                .setMobileNo("18730984987")
                .setAge(26)
                .setBirthday(new Date())
        ;
        return user;
    }
}
