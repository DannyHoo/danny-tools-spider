package top.danny.spider.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import top.danny.spider.dao.data.UserDO;
import top.danny.spider.dao.jpa.UserDAO;
import top.danny.spider.model.bean.PageModel;
import top.danny.spider.model.bean.User;
import top.danny.spider.service.UserService;
import top.danny.spider.utils.IterableUtils;

import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 15:28:45
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @Override
    public User saveUser(User user) {
        UserDO userDo = convertIgnoreNullProperty(user, UserDO.class);
        UserDO userDoSaved = userDao.save(userDo);
        User userSaved = convertIgnoreNullProperty(userDoSaved, User.class);
        return userSaved;
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> findAllUser() {
        List<User> userList = convertList(IterableUtils.convertToList(userDao.findAll()), User.class);
        return userList;
    }

    /**
     * 分页查询用户
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public PageModel<User> findUserPage(int pageNumber, int pageSize) {
        PageModel<User> userPageModel = new PageModel<User>();
        PageRequest request = buildPageRequest(pageNumber, pageSize);
        Page<UserDO> userDOPage = userDao.findAll(request);
        userPageModel.setList(convertList(IterableUtils.convertToList(userDOPage), User.class));
        userPageModel.setTotalRecords(userDOPage.getTotalPages());
        return userPageModel;
    }

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    public User findUserById(Long userId){
        User user=convertIgnoreNullProperty(userDao.findOne(userId),User.class);
        return user;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUser(User user){
        UserDO userDO=convertIgnoreNullProperty(user,UserDO.class);
        int result=userDao.update(userDO);
        return result;
    }

    @Override
    public int deleteUserById(Long userId) {
        userDao.delete(userId);
        return 1;
    }
}