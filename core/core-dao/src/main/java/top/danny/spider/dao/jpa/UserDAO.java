package top.danny.spider.dao.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import top.danny.spider.dao.data.UserDO;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 14:54:43
 */
public interface UserDAO extends PagingAndSortingRepository<UserDO,Long> {

}
