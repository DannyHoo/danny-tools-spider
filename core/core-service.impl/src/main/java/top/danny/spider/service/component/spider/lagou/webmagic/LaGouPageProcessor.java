package top.danny.spider.service.component.spider.lagou.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LaGouPageProcessor
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-17 22:26:45
 */
public class LaGouPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(10000);

    @Override
    public void process(Page page) {
        System.out.println("adfadf");
        String html=page.getHtml().toString();
        System.out.println(html);
        System.out.println("adfadf");
        /*page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
*/
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor()).addUrl("https://www.lagou.com/jobs/list_Java?px=default&gx=&isSchoolJob=1&city=%E5%8C%97%E4%BA%AC#filterBox").thread(5).run();
    }
}
