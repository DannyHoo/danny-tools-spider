package top.danny.spider.model.bean.crawleddata;

import top.danny.spider.model.bean.BaseBean;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LaGouCompany
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-17 23:03:34
 */
public class LaGouCompany extends BaseBean {
    private String pageUrl;

    private String companyName;

    private String areaName;

    private Long areaId;

    private double salaryMax;

    private double salaryMin;

    private double salaryAvg;

    private Date publishTime;

    private String experience;

    private String education;

    private String financingStage;

    private String financingInstitution;

    private String companySize;

    private String companyWebsite;

    private String companyLogo;

    private String industry;

    private String jobName;

    private String jobFeature;

    private String jobDescribe;

    private String jobAddress;

    public String getPageUrl() {
        return pageUrl;
    }

    public LaGouCompany setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LaGouCompany setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public LaGouCompany setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public double getSalaryMax() {
        return salaryMax;
    }

    public LaGouCompany setSalaryMax(double salaryMax) {
        this.salaryMax = salaryMax;
        return this;
    }

    public double getSalaryMin() {
        return salaryMin;
    }

    public LaGouCompany setSalaryMin(double salaryMin) {
        this.salaryMin = salaryMin;
        return this;
    }

    public double getSalaryAvg() {
        return salaryAvg;
    }

    public LaGouCompany setSalaryAvg(double salaryAvg) {
        this.salaryAvg = salaryAvg;
        return this;
    }

    public Long getAreaId() {
        return areaId;
    }

    public LaGouCompany setAreaId(Long areaId) {
        this.areaId = areaId;
        return this;
    }



    public Date getPublishTime() {
        return publishTime;
    }

    public LaGouCompany setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public String getExperience() {
        return experience;
    }

    public LaGouCompany setExperience(String experience) {
        this.experience = experience;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public LaGouCompany setEducation(String education) {
        this.education = education;
        return this;
    }

    public String getFinancingStage() {
        return financingStage;
    }

    public LaGouCompany setFinancingStage(String financingStage) {
        this.financingStage = financingStage;
        return this;
    }

    public String getFinancingInstitution() {
        return financingInstitution;
    }

    public LaGouCompany setFinancingInstitution(String financingInstitution) {
        this.financingInstitution = financingInstitution;
        return this;
    }

    public String getCompanySize() {
        return companySize;
    }

    public LaGouCompany setCompanySize(String companySize) {
        this.companySize = companySize;
        return this;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public LaGouCompany setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
        return this;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public LaGouCompany setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
        return this;
    }

    public String getIndustry() {
        return industry;
    }

    public LaGouCompany setIndustry(String industry) {
        this.industry = industry;
        return this;
    }

    public String getJobName() {
        return jobName;
    }

    public LaGouCompany setJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public String getJobFeature() {
        return jobFeature;
    }

    public LaGouCompany setJobFeature(String jobFeature) {
        this.jobFeature = jobFeature;
        return this;
    }

    public String getJobDescribe() {
        return jobDescribe;
    }

    public LaGouCompany setJobDescribe(String jobDescribe) {
        this.jobDescribe = jobDescribe;
        return this;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public LaGouCompany setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
        return this;
    }
}
