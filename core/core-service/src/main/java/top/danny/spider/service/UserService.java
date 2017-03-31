package top.danny.spider.service;

import top.danny.spider.model.bean.PageModel;
import top.danny.spider.model.bean.User;

import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserService
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 15:28:58
 */
public interface UserService {

    /**
     * 保存用户
     * @param user
     * @return
     */
    public User saveUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAllUser();

    /**
     * 分页查询用户
     * @param pageNumber
     * @param pagzSize
     * @return
     */
    public PageModel<User> findUserPage(int pageNumber, int pagzSize);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    public User findUserById(Long userId);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    public int deleteUserById(Long userId);
}
