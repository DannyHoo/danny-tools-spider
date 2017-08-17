package top.danny.spider.dao.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import top.danny.spider.dao.data.AreaDO;
import top.danny.spider.dao.jpa.base.BaseDao;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 14:54:43
 */
public interface AreaDAO extends BaseDao<AreaDO>,PagingAndSortingRepository<AreaDO,Long>{

}
