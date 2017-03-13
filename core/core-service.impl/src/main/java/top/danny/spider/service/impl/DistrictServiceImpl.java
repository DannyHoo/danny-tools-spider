package top.danny.spider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.danny.spider.dao.data.DistrictDO;
import top.danny.spider.dao.jpa.DistrictDAO;
import top.danny.spider.model.bean.District;
import top.danny.spider.service.DistrictService;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DistrictServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-12 23:56:33
 */
@Service
public class DistrictServiceImpl extends BaseServiceImpl implements DistrictService{

    @Autowired
    private DistrictDAO districtDAO;

    /**
     * 根据地区名称查询地区
     * @param districtName
     * @return
     */
    public District findDistrictByName(String districtName){
        DistrictDO districtDO=districtDAO.findByDistrictName(districtName);
        District district=convertIgnoreNullProperty(districtDO,District.class);
        return district;
    }
}
