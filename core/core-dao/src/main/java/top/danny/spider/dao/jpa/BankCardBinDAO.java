package top.danny.spider.dao.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import top.danny.spider.dao.data.BankCardBinDO;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BankCardDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-04 11:25:06
 */
public interface BankCardBinDAO extends PagingAndSortingRepository<BankCardBinDO,Long> {
}
