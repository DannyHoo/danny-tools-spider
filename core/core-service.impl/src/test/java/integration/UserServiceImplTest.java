package integration;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.danny.spider.model.bean.User;
import top.danny.spider.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserServiceImplTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 16:54:44
 */
public class UserServiceImplTest extends BaseServiceSpringTest {
    @Autowired
    private UserService userService;

    @Test
    public void saveUserTest(){
        User user=getUser();
        User userSaved=userService.saveUser(user);
        Assert.assertNotNull(userSaved);
    }

    private User getUser() {
        User user=new User();
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

    @Test
    public void findUserPageTest(){
        List<User> userList=userService.findUserPage(1,10);
        for (User user:userList){
            System.out.println(user.getRealName());
        }
    }
}
