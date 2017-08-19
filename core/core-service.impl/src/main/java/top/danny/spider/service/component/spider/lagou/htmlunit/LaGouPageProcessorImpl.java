package top.danny.spider.service.component.spider.lagou.htmlunit;

import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLUListElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.danny.spider.dao.data.SpiderTaskDO;
import top.danny.spider.dao.jpa.SpiderTaskDAO;
import top.danny.spider.dao.jpa.crawleddata.LaGouCompanyDAO;
import top.danny.spider.model.bean.SpiderTask;
import top.danny.spider.model.dto.UrlCache;
import top.danny.spider.service.component.LaGouPageProcessor;
import top.danny.spider.dao.data.crawleddata.LaGouCompanyDO;
import top.danny.spider.htmlunit.base.RequestData;
import top.danny.spider.htmlunit.base.RequestSender;
import top.danny.spider.model.bean.crawleddata.LaGouCompany;
import top.danny.spider.service.component.spider.ShutDownWork;
import top.danny.spider.service.impl.BaseServiceImpl;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LaGouPageProcessorImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-17 22:41:53
 */
@Service
public class LaGouPageProcessorImpl extends BaseServiceImpl implements LaGouPageProcessor {
    final static String htmlBaseUrl = "https://www.lagou.com/jobs/list_Java";
    private static String htmlBeginPageUrl = "https://www.lagou.com/jobs/2749990.html";

    /*待爬取的url缓存*/
    public static UrlCache urlCache = UrlCache.getInstance();

    static {
        //urlCache.push("58到家_资深Java工程师", htmlBeginPageUrl);
        ClassLoader classLoader = LaGouPageProcessorImpl.class.getClassLoader();
        URL url = classLoader.getResource("");
        //String filePath = new StringBuffer(url.getPath()).append("resource/file/historytask").toString();
        String filePath = "/Users/dannyhoo/file/historytask";
        String fileContent = readBaffleContent(filePath);
        List<SpiderTask> spiderTaskList = JSON.parseArray(fileContent, SpiderTask.class);
        urlCache.initUrlCatch(spiderTaskList);
    }

    @Autowired
    private LaGouCompanyDAO laGouCompanyDAO;
    @Autowired
    private SpiderTaskDAO spiderTaskDAO;

    @Override
    public boolean spider() throws InterruptedException {
        //添加程序结束监听
        Runtime.getRuntime().addShutdownHook(ShutDownWork.getInstance(this, "persistenceUrlCatch"));

        System.out.println("进入主方法，开始爬取，上次遗留任务数量："+urlCache.getSize());
        while (urlCache.getSize() > 0) {  // TODO: 17/8/20 多个线程如何安全分配这么多任务？？？ 
            LaGouCompany lagouCompany = getLaGouCompany(urlCache);
            //synchronized (this){
                if (laGouCompanyDAO.findByCompanyNameAndJobName(lagouCompany.getCompanyName(), lagouCompany.getJobName()) == null) {
                    LaGouCompanyDO lagouCompanyDOSaved = laGouCompanyDAO.save(convertIgnoreNullProperty(lagouCompany, LaGouCompanyDO.class));
                    System.out.println("入库成功：" + JSON.toJSONString(lagouCompanyDOSaved));
                }
            //}
            Thread.sleep(10);
        }
        return true;
    }


    public LaGouCompany getLaGouCompany(UrlCache urlCache) {

        String htmlPageUrl = urlCache.pop();
        System.out.println("开始爬取：" + htmlPageUrl);
        RequestData requestData = new RequestData("UTF-8", htmlPageUrl, "GET");
        HtmlPage requestResultPage = (HtmlPage) RequestSender.requestAndReturn(requestData);

        List bodyList = requestResultPage.getByXPath("//html/body");
        List container = requestResultPage.getByXPath("//html/body/div[@id='container']");
        List positionHead = requestResultPage.getByXPath("//html/body/div[@class='position-head']/div[@class='position-content-l']");
        List containerRight = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_r']");
        List containerLeft = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_r']/dl[@class='job_company']");
        List salaryRangeNode = requestResultPage.getByXPath("//html/body/div[@class='position-head']/div[@class='position-content ']/div[@class='position-content-l']/dd[1]/p[1]/span[1]");

        /*保存待爬取的URL*/
        supplyUrlCache(urlCache, requestResultPage);

        String pageUrl = htmlPageUrl;
        String companyName = getCompanyName(requestResultPage);
        Long areaId = 1L;
        String areaName = getAreaName(requestResultPage);
        double salaryMin = getSalaryMin(salaryRangeNode);
        double salaryMax = getSalaryMax(salaryRangeNode);
        double salaryAvg = (salaryMax + salaryMin) / 2;
        Date publishTime = getPublishTime(requestResultPage);
        String experience = getExperience(requestResultPage);//工作经验：不限、应届毕业生、3年及以下、3-5年、5-10年、10年以上、不要求
        String education = getEcucation(requestResultPage);//学历要求：不限、大专、本科、硕士、博士、不要求
        String financingStage = getFinancingStage(requestResultPage);//融资阶段：未融资、天使轮、A轮、B轮、C轮、D轮及以上、上市公司、不需要融资
        String finalcingInstitution = getFinancingInstitution(requestResultPage);//行业领域：移动互联网、电子商务、金融、企业服务、教育、文化娱乐、游戏、O2O、硬件、社交网络、旅游、医疗健康、生活服务、信息安全、数据服务、广告营销、分类信息、招聘、其他
        String companyLogo = "&*^#*(!(&@!@adsf8!@HKJND2e12987*(^%*^^^*";
        String companySize = getCompanySize(requestResultPage);
        String companyWebsite = getCompanyWebsite(requestResultPage);
        String industry = getIndustry(requestResultPage);
        String jobAddress = getJobAddress(requestResultPage);
        String jobName = getJobName(requestResultPage);
        String jobDescribe = getJobDescribe(requestResultPage);
        String jobFeature = getJobFeature(requestResultPage);

        LaGouCompany laGouCompany = new LaGouCompany();
        laGouCompany
                .setPageUrl(htmlPageUrl)
                .setCompanyName(companyName)
                .setAreaId(areaId)
                .setAreaName(areaName)
                .setSalaryMax(salaryMax)
                .setSalaryMin(salaryMin)
                .setSalaryAvg(salaryAvg)
                .setPublishTime(publishTime)
                .setExperience(experience)
                .setEducation(education)
                .setFinancingStage(financingStage)
                .setFinancingInstitution(finalcingInstitution)
                .setCompanyLogo(companyLogo)
                .setCompanySize(companySize)
                .setCompanyWebsite(companyWebsite)
                .setIndustry(industry)
                .setJobName(jobName)
                .setJobAddress(jobAddress)
                .setJobDescribe(jobDescribe)
                .setJobFeature(jobFeature);
        System.out.println("拼装爬取结果结束：" + JSON.toJSONString(laGouCompany));
        return laGouCompany;
    }

    private static void supplyUrlCache(UrlCache urlCache, HtmlPage requestResultPage) {
        List containerRight = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_r']/div[@id='jobs_similar']/div[@id='jobs_similar_content']/div[@id='jobs_similar_detail']/ul/li");
        List<HtmlListItem> htmlListItemListRight = containerRight;
        for (int i = 1; i <= htmlListItemListRight.size(); i++) {
            List a = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_r']/div[@id='jobs_similar']/div[@id='jobs_similar_content']/div[@id='jobs_similar_detail']/ul/li[" + i + "]/a");
            HtmlAnchor htmlAnchor = ((HtmlAnchor) a.get(0));
            String url = htmlAnchor.getHrefAttribute();
            List jobNameNode = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_r']/div[@id='jobs_similar']/div[@id='jobs_similar_content']/div[@id='jobs_similar_detail']/ul/li[" + i + "]/a[1]/div[@class='similar_list_item_pos']/h2[1]");
            List companyNameNode = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_r']/div[@id='jobs_similar']/div[@id='jobs_similar_content']/div[@id='jobs_similar_detail']/ul/li[" + i + "]/a[1]/div[@class='similar_list_item_pos']/p[@class='similar_company_name']");
            HtmlHeading2 htmlHeading2 = (HtmlHeading2) jobNameNode.get(0);
            HtmlParagraph htmlParagraph = (HtmlParagraph) companyNameNode.get(0);
            String jobName = htmlHeading2.getTextContent();
            String companyName = htmlParagraph.getTextContent().replace(" ", "").replace("\n", "");//颗豆互动 [北京·朝阳区]
            companyName = companyName.split("[\\[; ]")[0];//"[\\[\\]; ]"
            urlCache.push(companyName + "_" + jobName, url);
        }

        List containerLeft = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_l fl']/dl[@class='view_again module-container']/div[@class='view_again_area']/ul/li");
        List<HtmlListItem> htmlListItemListLeft = containerLeft;
        for (int i = 1; i <= htmlListItemListLeft.size(); i++) {
            List a1 = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_l fl']/dl[@class='view_again module-container']/div[@class='view_again_area']/ul/li[" + i + "]/a[2]");
            HtmlAnchor htmlAnchor1 = ((HtmlAnchor) a1.get(0));
            String url = htmlAnchor1.getHrefAttribute();
            String jobName = htmlAnchor1.getTextContent().replace("\n", "").replace(" ", "");
            List a2 = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_l fl']/dl[@class='view_again module-container']/div[@class='view_again_area']/ul/li[" + i + "]/a[3]");
            HtmlAnchor htmlAnchor2 = ((HtmlAnchor) a2.get(0));
            String companyName = htmlAnchor2.getTextContent().replace("\n", "").replace(" ", "");
            urlCache.push(companyName + "_" + jobName, url);
        }
    }

    /*行业*/
    private static String getIndustry(HtmlPage requestResultPage) {
        String areaName = "";
        try {
            List areaNameNode = requestResultPage.getByXPath("//html/body/div[@class='position-head']/div[@class='position-content ']/div[@class='position-content-l']/dd[1]/p[1]/span[2]");
            return areaName;
        } catch (Exception e) {
            return areaName;
        }
    }

    /*公司网址*/
    private static String getCompanyWebsite(HtmlPage requestResultPage) {
        String areaName = "";
        try {
            List areaNameNode = requestResultPage.getByXPath("//html/body/div[@class='position-head']/div[@class='position-content ']/div[@class='position-content-l']/dd[1]/p[1]/span[2]");
            return areaName;
        } catch (Exception e) {
            return areaName;
        }
    }

    /*公司规模*/
    private static String getCompanySize(HtmlPage requestResultPage) {
        String areaName = "";
        try {
            List areaNameNode = requestResultPage.getByXPath("//html/body/div[@class='position-head']/div[@class='position-content ']/div[@class='position-content-l']/dd[1]/p[1]/span[2]");
            return areaName;
        } catch (Exception e) {
            return areaName;
        }
    }

    /*融资机构*/
    private static String getFinancingInstitution(HtmlPage requestResultPage) {
        String areaName = "";
        try {
            List areaNameNode = requestResultPage.getByXPath("//html/body/div[@class='position-head']/div[@class='position-content ']/div[@class='position-content-l']/dd[1]/p[1]/span[2]");
            return areaName;
        } catch (Exception e) {
            return areaName;
        }
    }

    /*融资阶段*/
    private static String getFinancingStage(HtmlPage requestResultPage) {
        String areaName = "";
        try {
            List areaNameNode = requestResultPage.getByXPath("//html/body/div[@class='position-head']/div[@class='position-content ']/div[@class='position-content-l']/dd[1]/p[1]/span[2]");
            areaName = ((HtmlSpan) areaNameNode.get(0)).getFirstChild().asText().replace("/", "").trim();
            return areaName;
        } catch (Exception e) {
            return areaName;
        }
    }


    /**
     * 发布日期
     *
     * @param requestResultPage
     */
    private static Date getPublishTime(HtmlPage requestResultPage) {
        Date publisTime = null;
        try {
            List areaNameNode = requestResultPage.getByXPath("//html/body/div[@class='position-head']/div[@class='position-content ']/div[@class='position-content-l']/dd[1]/p[2]");
            String publisTimeStr = ((HtmlParagraph) areaNameNode.get(0)).getFirstChild().asText().trim();
            publisTime = new Date();
            return publisTime;
        } catch (Exception e) {
            return new Date();
        }
    }

    /**
     * 公司名称
     */
    private static String getCompanyName(HtmlPage requestResultPage) {
        try {
            List companyNameTempList = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_r']/dl[@class='job_company']/dt[1]/a[1]/div[1]/h2[1]");
            String companyNameTemp = ((HtmlHeading2) companyNameTempList.get(0)).getFirstChild().asText().trim();
            return companyNameTemp;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 薪资最大值
     */
    private static double getSalaryMax(List salaryRangeNode) {
        double salaryMax = 0;
        try {
            String salaryRange = ((HtmlSpan) salaryRangeNode.get(0)).getFirstChild().asText().trim();//20k-40k
            String[] salaryRanges = salaryRange.split("-");
            salaryMax = salaryRanges.length > 1
                    ? getDoubleVal(salaryRanges[1].replace("k", ""))
                    : getDoubleVal(salaryRanges[0].replace("k", ""));
            return salaryMax * 1000;
        } catch (Exception e) {
            return salaryMax;
        }
    }

    /**
     * 薪资最小值
     */
    private static double getSalaryMin(List salaryRangeNode) {
        double salaryMin = 0;
        try {
            String salaryRange = ((HtmlSpan) salaryRangeNode.get(0)).getFirstChild().asText().trim();//20k-40k
            String[] salaryRanges = salaryRange.split("-");
            salaryMin = salaryRanges.length > 0
                    ? getDoubleVal(salaryRanges[0].replace("k", ""))
                    : 0;
            return salaryMin * 1000;
        } catch (Exception e) {
            return 0;
        }
    }

    public static double getDoubleVal(String doubleVal) {
        return Double.valueOf(doubleVal);
    }

    /**
     * 地区名称
     */
    private static String getAreaName(HtmlPage requestResultPage) {
        String areaName = "";
        try {
            List areaNameNode = requestResultPage.getByXPath("//html/body/div[@class='position-head']/div[@class='position-content ']/div[@class='position-content-l']/dd[1]/p[1]/span[2]");
            areaName = ((HtmlSpan) areaNameNode.get(0)).getFirstChild().asText().replace("/", "").trim();
            return areaName;
        } catch (Exception e) {
            return areaName;
        }
    }

    /*工作经验*/
    private static String getExperience(HtmlPage requestResultPage) {
        String experience = "";
        try {
            List experienceNode = requestResultPage.getByXPath("//html/body/div[@class='position-head']/div[@class='position-content ']/div[@class='position-content-l']/dd[1]/p[1]/span[3]");
            experience = ((HtmlSpan) experienceNode.get(0)).getFirstChild().asText().replace("经验", "").replace("/", "").trim();
            return experience;
        } catch (Exception e) {
            return experience;
        }
    }

    /*学历*/
    private static String getEcucation(HtmlPage requestResultPage) {
        String education = "";
        try {
            List educationNode = requestResultPage.getByXPath("//html/body/div[@class='position-head']/div[@class='position-content ']/div[@class='position-content-l']/dd[1]/p[1]/span[4]");
            education = ((HtmlSpan) educationNode.get(0)).getFirstChild().asText().replace("及以上", "").replace("/", "").trim();
            return education;
        } catch (Exception e) {
            return education;
        }
    }

    /*职位诱惑*/
    private static String getJobFeature(HtmlPage requestResultPage) {
        String jobFeature = "";
        try {
            List jobFeatureNode = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_l fl']/dl[@class='job_detail']/dd[@class='job-advantage']/p[1]");
            jobFeature = ((HtmlParagraph) jobFeatureNode.get(0)).getFirstChild().asText().trim();
            return jobFeature;
        } catch (Exception e) {
            return jobFeature;
        }
    }

    /*工作地址*/
    private static String getJobAddress(HtmlPage requestResultPage) {
        String jobAddress = "";
        try {
            List jobAddressNode = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_l fl']/dl[@class='job_detail']/dd[@class='job-address clearfix']/div[1]");
            jobAddress = ((HtmlDivision) jobAddressNode.get(0)).getTextContent().replace("\n", "").replace(" ", "").replace("查看地图", "");
            return jobAddress;
        } catch (Exception e) {
            return jobAddress;
        }
    }

    /*职位名称*/
    private static String getJobName(HtmlPage requestResultPage) {
        String jobName = "";
        try {
            List jobNameNode = requestResultPage.getByXPath("//html/body/div[@class='position-head']/div[@class='position-content ']/div[@class='position-content-l']/div[@class='job-name']/span[1]");
            jobName = ((HtmlSpan) jobNameNode.get(0)).getFirstChild().asText().trim();
            return jobName;
        } catch (Exception e) {
            return jobName;
        }
    }

    /*职位描述*/
    private static String getJobDescribe(HtmlPage requestResultPage) {
        String jobDescribe = "";
        try {
            List jobDescribeNode = requestResultPage.getByXPath("//html/body/div[@id='container']/div[@class='content_l fl']/dl[@class='job_detail']/dd[@class='job_bt']/div[1]");
            jobDescribe = ((HtmlDivision) jobDescribeNode.get(0)).getTextContent();
            return jobDescribe;
        } catch (Exception e) {
            return jobDescribe;
        }
    }

    /*持久化待爬取的任务*/
    public void persistenceUrlCatch() {
        try {
            List<SpiderTask> spiderTaskList = getSpiderTaskList(urlCache.getUrlCacheMap());
            System.out.println("中断爬取任务，开始持久化遗留任务…… request:" + JSON.toJSONString(spiderTaskList));
            //spiderTaskDAO.batchInsert(convertList(spiderTaskList, SpiderTaskDO.class));
            String path = System.getProperty("user.dir");
            //String filePath =path+"/core/core-service.impl/src/test/resources/resource/file/"+ UUID.randomUUID();
            String filePath ="/Users/dannyhoo/file/"+ UUID.randomUUID();
            writeBaffleContent(filePath,JSON.toJSONString(spiderTaskList));
            System.out.println("中断爬取任务，持久化遗留任务结束…… 遗留任务数量："+spiderTaskList.size()+"，执行数量："+urlCache.getUrlCacheMapHistory().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<SpiderTask> getSpiderTaskList(Map<String, String> urlCacheMap) {
        List<SpiderTask> spiderTaskList = new ArrayList<>();
        for (String key : urlCacheMap.keySet()) {
            SpiderTask spiderTask = new SpiderTask()
                    .setTaskName("拉勾网")
                    .setTitle(key)
                    .setUrl(urlCacheMap.get(key).toString());
            spiderTaskList.add(spiderTask);
        }
        return spiderTaskList;
    }

    /**
     * 读取数据挡板模板的内容
     *
     * @param filePath
     * @return
     */
    public static String readBaffleContent(String filePath) {
        try {
            File file = new File(filePath);
            FileInputStream in = new FileInputStream(file);
            int size = in.available(); //size为字串的长度这里一次性读完
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            String str = new String(buffer, "UTF-8");
            return str;
        } catch (IOException e) {
            return "";
        }
    }

    public static void writeBaffleContent(String filePath, String fileContent) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file.getName(), true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(fileContent);
            bufferWritter.close();
            System.out.println("遗留任务已经写入文件：" + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath ="/Users/dannyhoo/file/"+ UUID.randomUUID();
        writeBaffleContent(filePath,"adfadf");
        System.out.println();
    }
}
