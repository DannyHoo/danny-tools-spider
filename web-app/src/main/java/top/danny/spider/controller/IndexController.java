package top.danny.spider.controller;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.danny.spider.model.bean.User;
import top.danny.spider.service.UserService;

import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: IndexController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 17:51:34
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        saveUserTest();
        return "index";
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
                .setRealName("胡玉洋")
                .setIdCardNo("187302199009098918")
                .setMobileNo("18730984987")
                .setAge(26)
                .setBirthday(new Date())
        ;
        return user;
    }
}
