package top.danny.spider.dao.jpa;

import org.codehaus.jackson.map.deser.ValueInstantiators;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import top.danny.spider.dao.data.UserDO;

import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserDAOTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 14:52:21
 */
public class UserDAOTest extends BaseDaoSpringTest {

    @Autowired
    private UserDAO userDao;

    @Test
    @Rollback(false)
    public void saveUserTest(){
        UserDO userDo=getUserDO();
        UserDO userDoSaved=userDao.save(userDo);
        Assert.assertNotNull(userDoSaved);
        System.out.println(userDoSaved.getUserName());
    }

    private UserDO getUserDO() {
        UserDO userDo=new UserDO();
        userDo.setUserName("danny")
                .setPassword("123456")
                .setRealName("胡玉洋")
                .setIdCardNo("187302199009098918")
                .setMobileNo("18730984987")
                .setAge(26)
                .setBirthday(new Date())
        ;
        return userDo;
    }
}