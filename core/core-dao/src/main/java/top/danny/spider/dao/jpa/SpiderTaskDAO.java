package top.danny.spider.dao.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import top.danny.spider.dao.data.SpiderTaskDO;
import top.danny.spider.dao.jpa.base.BaseDao;

/**
 * @author huyuyang@lxfintech.com
 * @Title: SpiderTaskDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-19 10:13:20
 */
public interface SpiderTaskDAO  extends BaseDao<SpiderTaskDO>,PagingAndSortingRepository<SpiderTaskDO,Long> {
}
