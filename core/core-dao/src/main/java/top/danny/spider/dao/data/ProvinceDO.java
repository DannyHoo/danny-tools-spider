package top.danny.spider.dao.data;

import top.danny.spider.dao.data.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ProvinceDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-12 14:04:55
 */
@Entity
@Table(name="t_province")
public class ProvinceDO extends BaseEntity {
    @Column(name="provinceName")
    private  String provinceName;

    public String getProvinceName() {
        return provinceName;
    }

    public ProvinceDO setProvinceName(String provinceName) {
        this.provinceName = provinceName;
        return this;
    }
}
