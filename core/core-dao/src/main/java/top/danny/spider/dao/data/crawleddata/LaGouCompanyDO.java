package top.danny.spider.dao.data.crawleddata;

import org.hibernate.annotations.DynamicUpdate;
import top.danny.spider.dao.data.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LaGouCompanyDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-17 22:45:44
 */
@Entity
@Table(name = "t_lagou_company")
@DynamicUpdate(true)
public class LaGouCompanyDO extends BaseEntity {
    @Column(name = "pageUrl")
    private String pageUrl;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "areaName")
    private String areaName;

    @Column(name = "areaId")
    private Long areaId;

    @Column(name = "salaryMax")
    private Integer salaryMax;

    @Column(name = "salaryMin")
    private Integer salaryMin;

    @Column(name = "publishTime")
    private Date publishTime;

    @Column(name = "experience")
    private String experience;

    @Column(name = "financingStage")
    private String financingStage;

    @Column(name = "financingInstitution")
    private String financingInstitution;

    @Column(name = "companySize")
    private String companySize;

    @Column(name = "companyWebsite")
    private String companyWebsite;

    @Column(name = "companyLogo")
    private String companyLogo;

    @Column(name = "industry")
    private String industry;

    @Column(name = "jobFeature")
    private String jobFeature;

    @Column(name = "jobDescribe")
    private String jobDescribe;

    @Column(name = "jobAddress")
    private String jobAddress;

    public String getPageUrl() {
        return pageUrl;
    }

    public LaGouCompanyDO setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LaGouCompanyDO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public LaGouCompanyDO setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public Long getAreaId() {
        return areaId;
    }

    public LaGouCompanyDO setAreaId(Long areaId) {
        this.areaId = areaId;
        return this;
    }

    public Integer getSalaryMax() {
        return salaryMax;
    }

    public LaGouCompanyDO setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
        return this;
    }

    public Integer getSalaryMin() {
        return salaryMin;
    }

    public LaGouCompanyDO setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
        return this;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public LaGouCompanyDO setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public String getExperience() {
        return experience;
    }

    public LaGouCompanyDO setExperience(String experience) {
        this.experience = experience;
        return this;
    }

    public String getFinancingStage() {
        return financingStage;
    }

    public LaGouCompanyDO setFinancingStage(String financingStage) {
        this.financingStage = financingStage;
        return this;
    }

    public String getFinancingInstitution() {
        return financingInstitution;
    }

    public LaGouCompanyDO setFinancingInstitution(String financingInstitution) {
        this.financingInstitution = financingInstitution;
        return this;
    }

    public String getCompanySize() {
        return companySize;
    }

    public LaGouCompanyDO setCompanySize(String companySize) {
        this.companySize = companySize;
        return this;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public LaGouCompanyDO setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
        return this;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public LaGouCompanyDO setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
        return this;
    }

    public String getIndustry() {
        return industry;
    }

    public LaGouCompanyDO setIndustry(String industry) {
        this.industry = industry;
        return this;
    }

    public String getJobFeature() {
        return jobFeature;
    }

    public LaGouCompanyDO setJobFeature(String jobFeature) {
        this.jobFeature = jobFeature;
        return this;
    }

    public String getJobDescribe() {
        return jobDescribe;
    }

    public LaGouCompanyDO setJobDescribe(String jobDescribe) {
        this.jobDescribe = jobDescribe;
        return this;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public LaGouCompanyDO setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
        return this;
    }
}
