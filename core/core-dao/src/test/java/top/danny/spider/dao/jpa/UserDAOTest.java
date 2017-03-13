package top.danny.spider.dao.jpa;

import org.codehaus.jackson.map.deser.ValueInstantiators;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import top.danny.spider.dao.data.UserDO;
import top.danny.spider.utils.ChinesePinYin;
import top.danny.spider.utils.IterableUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public void findUserTest(){
        UserDO userDoSaved=userDao.findOne(1767L);
        System.out.println(userDoSaved.getUserName());
    }

    @Test
    @Rollback(true)
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

    @Test
    @Rollback(false)
    public void updateUserTest(){
        List<UserDO> userList= IterableUtils.convertToList(userDao.findAll());
        for (UserDO user:userList){
            user.setUserName(ChinesePinYin.getPingYin(user.getRealName()));
            userDao.updateUserName(user.getId(),user.getUserName());
        }

    }
}
