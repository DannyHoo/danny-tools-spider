package top.danny.spider.dao.jpa.crawleddata;

import org.springframework.data.repository.PagingAndSortingRepository;
import top.danny.spider.dao.data.crawleddata.LaGouCompanyDO;
import top.danny.spider.dao.jpa.base.BaseDao;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 14:54:43
 */
public interface LaGouCompanyDAO extends BaseDao<LaGouCompanyDO>,PagingAndSortingRepository<LaGouCompanyDO,Long>{

    LaGouCompanyDO findByCompanyNameAndJobName(String companyName,String jobName);

}
