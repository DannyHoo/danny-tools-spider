package top.danny.spider.model.bean;


/**
 * @author huyuyang@lxfintech.com
 * @Title: District
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-12 23:54:12
 */
public class District extends BaseBean {
    private String districtName;
    private Long cityID;

    public String getDistrictName() {
        return districtName;
    }

    public District setDistrictName(String districtName) {
        this.districtName = districtName;
        return this;
    }

    public Long getCityID() {
        return cityID;
    }

    public District setCityID(Long cityID) {
        this.cityID = cityID;
        return this;
    }
}
