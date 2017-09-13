package integration.top.danny.spider.service.component;

import top.danny.spider.service.component.LaGouPageProcessor;

/**
 * @author huyuyang@lxfintech.com
 * @Title: SpiderThread
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-19 20:55:28
 */
public class SpiderThread extends Thread{

    private LaGouPageProcessor laGouPageProcessor;
    private String beginUrl;

    public SpiderThread(LaGouPageProcessor laGouPageProcessor,String beginUrl){
        this.laGouPageProcessor=laGouPageProcessor;
        this.beginUrl=beginUrl;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程："+Thread.currentThread().getName()+"启动……");
            laGouPageProcessor.spider(beginUrl);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
