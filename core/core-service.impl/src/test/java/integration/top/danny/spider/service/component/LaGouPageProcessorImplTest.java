package integration.top.danny.spider.service.component;

import integration.BaseServiceSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.danny.spider.service.component.LaGouPageProcessor;
import top.danny.spider.service.component.spider.ShutDownWork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LaGouPageProcessorImplTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-19 00:34:29
 */
public class LaGouPageProcessorImplTest extends BaseServiceSpringTest {

    @Autowired
    private LaGouPageProcessor laGouPageProcessor;

    @Test
    public void testSpider() {
        try {
            /*Thread spiderThread1 = new SpiderThread(laGouPageProcessor);
            Thread spiderThread2 = new SpiderThread(laGouPageProcessor);
            Thread spiderThread3 = new SpiderThread(laGouPageProcessor);
            Thread spiderThread4 = new SpiderThread(laGouPageProcessor);
            Thread spiderThread5 = new SpiderThread(laGouPageProcessor);
            spiderThread1.start();
            spiderThread2.start();
            spiderThread3.start();
            spiderThread4.start();
            spiderThread5.start();
            spiderThread1.join();
            spiderThread2.join();
            spiderThread3.join();
            spiderThread4.join();
            spiderThread5.join();*/
            laGouPageProcessor.spider();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
