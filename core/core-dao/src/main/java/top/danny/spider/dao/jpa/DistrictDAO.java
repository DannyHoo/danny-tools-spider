package top.danny.spider.dao.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import top.danny.spider.dao.data.DistrictDO;
import top.danny.spider.dao.jpa.base.BaseDao;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DistrictDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-12 23:48:06
 */
public interface DistrictDAO extends BaseDao<DistrictDO>,PagingAndSortingRepository<DistrictDO,Long> {

    public DistrictDO findByDistrictName(String districtName);
}
