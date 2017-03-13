package top.danny.spider.dao.jpa.base;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import top.danny.spider.dao.data.UserDO;

import java.io.Serializable;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseDao
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-12 14:41:17
 */
@NoRepositoryBean
public interface BaseDao<T> extends PagingAndSortingRepository<T,Long>{

    int update(T t);

    void batchInsert(List<T> list);

    void batchUpdate(List<T> list);
}
