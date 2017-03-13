package top.danny.spider.dao.data;

import top.danny.spider.dao.data.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author huyuyang@lxfintech.com
 * @Title: CityDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-12 14:11:16
 */
@Entity
@Table(name="t_city")
public class CityDO extends BaseEntity {
    @Column(name="cityName")
    private String cityName;
    @Column(name="zipCode")
    private String zipCode;
    @Column(name="provinceId")
    private Long provinceId;

    public String getCityName() {
        return cityName;
    }

    public CityDO setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public CityDO setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public CityDO setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
        return this;
    }
}
