package top.danny.spider.dao.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    @Modifying
    @Query("update UserDO u set u.userName=?2 where u.id=?1")
    public int updateUserName(Long userId,String userName);
}
