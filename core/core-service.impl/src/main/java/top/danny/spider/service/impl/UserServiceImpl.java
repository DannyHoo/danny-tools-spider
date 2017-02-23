package top.danny.spider.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import top.danny.spider.dao.data.UserDO;
import top.danny.spider.dao.jpa.UserDAO;
import top.danny.spider.model.bean.User;
import top.danny.spider.service.UserService;

import javax.servlet.ServletContext;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 15:28:45
 */
@Service
public class UserServiceImpl  extends BaseServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;

    @Override
    public User saveUser(User user) {
        UserDO userDo=convertIgnoreNullProperty(user,UserDO.class);
        UserDO userDoSaved = userDao.save(userDo);
        User userSaved=convertIgnoreNullProperty(userDoSaved,User.class);
        return userSaved;
    }
}