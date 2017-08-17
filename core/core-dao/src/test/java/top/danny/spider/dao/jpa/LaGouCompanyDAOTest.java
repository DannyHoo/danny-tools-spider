package top.danny.spider.dao.jpa;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import top.danny.spider.dao.data.crawleddata.LaGouCompanyDO;
import top.danny.spider.dao.jpa.crawleddata.LaGouCompanyDAO;

import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LaGouCompanyDAOTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-17 22:52:15
 */
public class LaGouCompanyDAOTest extends BaseDaoSpringTest {

    @Autowired
    private LaGouCompanyDAO laGouCompanyDAO;

    @Test
    @Rollback(false)
    public void saveTest(){
        LaGouCompanyDO laGouCompanyDO=getLaGouCompanyDO();
        LaGouCompanyDO laGouCompanyDOSaved=laGouCompanyDAO.save(laGouCompanyDO);
        Assert.assertNotNull(laGouCompanyDOSaved);
    }

    private LaGouCompanyDO getLaGouCompanyDO() {
        return new LaGouCompanyDO()
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

    }
}
