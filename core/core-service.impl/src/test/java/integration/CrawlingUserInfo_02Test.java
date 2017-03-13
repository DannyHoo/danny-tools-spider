package integration;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import top.danny.spider.service.component.CrawlingUserInfo;

import javax.annotation.Resource;

/**
 * @author huyuyang@lxfintech.com
 * @Title: CrawlingUserInfoTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-25 20:29:36
 */
public class CrawlingUserInfo_02Test extends BaseServiceSpringTest{

    //@Resource(name="crawlingUserInfo_02")
    @Autowired
    @Qualifier("idCardCrawling")
    private CrawlingUserInfo crawlingUserInfo;

    @Test
    public void test() {
        while(true){
            crawlingUserInfo.run();
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
