package top.danny.spider.service;

import top.danny.spider.model.bean.District;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DistrictService
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-12 23:53:33
 */
public interface DistrictService {

    /**
     * 根据地区名称查询地区
     * @param districtName
     * @return
     */
    public District findDistrictByName(String districtName);
}
