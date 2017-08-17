package top.danny.spider.dao.data;

import org.hibernate.annotations.DynamicUpdate;
import top.danny.spider.dao.data.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author huyuyang@lxfintech.com
 * @Title: AreaDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-17 21:34:54
 */
@Entity
@Table(name = "t_area")
@DynamicUpdate(true)
public class AreaDO extends BaseEntity {

    @Column(name = "areaName")
    private String areaName;

    @Column(name = "parentId")
    private Long parentId;

    @Column(name = "shortName")
    private String shortName;

    @Column(name = "areaCode")
    private String areaCode;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "lng")
    private String lng;

    @Column(name = "lat")
    private String lat;

    @Column(name = "level")
    private Integer level;

    @Column(name = "sort")
    private Integer sort;

    public String getAreaName() {
        return areaName;
    }

    public AreaDO setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public AreaDO setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public AreaDO setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public AreaDO setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public AreaDO setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getLng() {
        return lng;
    }

    public AreaDO setLng(String lng) {
        this.lng = lng;
        return this;
    }

    public String getLat() {
        return lat;
    }

    public AreaDO setLat(String lat) {
        this.lat = lat;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public AreaDO setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public AreaDO setSort(Integer sort) {
        this.sort = sort;
        return this;
    }
}
