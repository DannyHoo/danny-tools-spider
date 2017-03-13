package top.danny.spider.dao.data;

import top.danny.spider.dao.data.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DistrictDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-12 14:14:17
 */
@Entity
@Table(name="t_district")
public class DistrictDO extends BaseEntity {
    @Column(name="districtName")
    private String districtName;
    @Column(name="cityID")
    private Long cityID;

    public String getDistrictName() {
        return districtName;
    }

    public DistrictDO setDistrictName(String districtName) {
        this.districtName = districtName;
        return this;
    }

    public Long getCityID() {
        return cityID;
    }

    public DistrictDO setCityID(Long cityID) {
        this.cityID = cityID;
        return this;
    }
}
