package top.danny.spider.service.impl;

import org.springframework.stereotype.Service;
import top.danny.spider.model.bean.User;
import top.danny.spider.service.UserService;
import top.danny.spider.utils.StringUtilsDanny;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 15:28:45
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User saveUser(User user) {
        UserDO userDo=new UserDO();
        return null;
    }
}