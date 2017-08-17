package top.danny.spider.service.component.spider.lagou.htmlunit;

import com.gargoylesoftware.htmlunit.html.HtmlHeading2;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import top.danny.spider.htmlunit.base.RequestData;
import top.danny.spider.htmlunit.base.RequestSender;
import top.danny.spider.model.bean.crawleddata.LaGouCompany;

import java.util.Date;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LaGouPageProcessor
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-17 22:41:53
 */
public class LaGouPageProcessor {
    final static String htmlBaseUrl = "https://www.lagou.com/jobs/list_Java";
    private static String htmlPageUrl = "https://www.lagou.com/jobs/2749990.html";

    public static void main(String[] args) {
        get();
    }

    public static LaGouCompany get() {
        RequestData requestData = new RequestData("UTF-8", htmlPageUrl, "GET");
        HtmlPage requestResultPage = (HtmlPage) RequestSender.requestAndReturn(requestData);
        List bodyList = requestResultPage.getByXPath("//html/body");
        List container = requestResultPage.getByXPath("//html/body/div[@id='container']");
        List containerRight = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_r']");
        List containerLeft = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_r']/dl[@class='job_company']");
        List list4 = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_r']/dl[@class='job_company']/dt[1]/a[1]/div[1]/h2[1]");
        String companyNameTemp= ((HtmlHeading2)list4.get(0)).getFirstChild().asText();

        String pageUrl = htmlPageUrl;
        String companyName = companyNameTemp;
        Long areaId = 1L;
        String areaName = "";
        Integer salaryMin = 0;
        Integer salaryMax = 0;
        Date publishTime = new Date();
        String experience = "";
        String financingStage = "";
        String finalcingInstitution = "";
        String companyLogo = "";
        String companySize = "";
        String companyWebsite = "";
        String industry = "";
        String jobAddress = "";
        String jobDescribe = "";
        String jobFeature = "";

        LaGouCompany laGouCompany = new LaGouCompany();
        laGouCompany
                .setPageUrl("www.lagou.com")
                .setCompanyName("拉勾网")
                .setAreaId(1L)
                .setAreaName("北京市")
                .setSalaryMax(30000)
                .setSalaryMin(25000)
                .setPublishTime(new Date())
                .setExperience("应届")
                .setFinancingStage("A轮")
                .setFinancingInstitution("洪泰基金(A轮)")
                .setCompanyLogo("&*^#*(!(&@!@adsf8!@HKJND2e12987*(^%*^^^*")
                .setCompanySize("2000人")
                .setCompanyWebsite("www.lagou.com")
                .setIndustry("招聘行业")
                .setJobAddress("北京市海淀区中关村")
                .setJobDescribe("java工程师")
                .setJobFeature("妹子多");
        return laGouCompany;
    }
}
