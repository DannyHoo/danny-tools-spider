package integration.top.danny.spider.service.component;

import com.alibaba.fastjson.JSON;
import integration.BaseServiceSpringTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.danny.spider.dao.data.crawleddata.LaGouCompanyDO;
import top.danny.spider.model.bean.crawleddata.LaGouCompany;
import top.danny.spider.model.dto.UrlCache;
import top.danny.spider.service.component.LaGouPageProcessor;
import top.danny.spider.service.component.spider.ShutDownWork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LaGouPageProcessorImplTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-19 00:34:29
 * SELECT *
FROM t_lagou_company
WHERE !(jobName like '%JAVA%'
OR jobName like '%Java%'
OR jobName like '%java%'
OR jobName like '%后台%'
OR jobName like '%后端%'
OR jobName like '%服务器%'
OR jobName like '%架构%'
OR jobName like '%大数据%'
OR jobName like '%技术%')

SELECT count(*)
FROM t_lagou_company
WHERE (!(jobName like '%JAVA%'
OR jobName like '%Java%'
OR jobName like '%java%'
OR jobName like '%后台%'
OR jobName like '%后端%'
OR jobName like '%服务器%'
OR jobName like '%架构%'
OR jobName like '%大数据%'
OR jobName like '%技术%'))
AND salaryMin>10000
AND salaryMax<50000
 */
public class LaGouPageProcessorImplTest extends BaseServiceSpringTest {

    @Autowired
    private LaGouPageProcessor laGouPageProcessor;
    private ExecutorService pool;
    private Thread spiderThread1;
    private Thread spiderThread2;
    private Thread spiderThread3;
    private Thread spiderThread4;
    private Thread spiderThread5;

    @Before
    public void before() {
        pool = Executors.newFixedThreadPool(2);
    }

    @Test
    public void testSpider() {
        //添加程序结束监听
        Runtime.getRuntime().addShutdownHook(ShutDownWork.getInstance(laGouPageProcessor, "persistenceUrlCatch"));

        try {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) pool;

            /*spiderThread1.start();
            spiderThread2.start();
            spiderThread3.start();
            spiderThread4.start();
            spiderThread5.start();
            spiderThread1.join();
            spiderThread2.join();
            spiderThread3.join();
            spiderThread4.join();
            spiderThread5.join();*/

            UrlCache urlCache = laGouPageProcessor.getUrlCache();
            while (urlCache.getSize() > 0) {  // TODO: 17/8/20 多个线程如何安全分配这么多任务？？？

                String beginUrl = urlCache.pop();
                laGouPageProcessor.spider(beginUrl);
                /*threadPoolExecutor.execute(new SpiderThread(laGouPageProcessor, beginUrl));
                System.out.println("poolsize:" + threadPoolExecutor.getCorePoolSize()+
                        "task:" + threadPoolExecutor.getActiveCount()+
                        "active:" + threadPoolExecutor.getActiveCount());*/
            }
            //laGouPageProcessor.spider();

            try {
                boolean loop = true;
                do {    //等待所有任务完成
                    loop = !threadPoolExecutor.awaitTermination(2, TimeUnit.SECONDS);  //阻塞，直到线程池里所有任务结束
                } while (loop);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("==================end====================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cleanDataTest() {
        laGouPageProcessor.cleanData();
    }

    @Test
    public void shutDownTest() throws InterruptedException {
        //添加程序结束监听
        Runtime.getRuntime().addShutdownHook(new ShutDownWork(this, "shutDownWork"));

        System.out.println("开始执行");
        long startTime = System.currentTimeMillis();
        Thread.sleep(100000);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime));
    }

    public void shutDownWork() {
        System.out.println("shutdown");
    }
}
