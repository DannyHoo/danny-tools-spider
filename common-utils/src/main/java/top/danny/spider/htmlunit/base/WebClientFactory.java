package top.danny.spider.htmlunit.base;

import com.gargoylesoftware.htmlunit.CollectingAlertHandler;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;

/**
 * @author huyuyang@lxfintech.com
 * @Title: WebClientFactory
 * @Copyright: Copyright (c) 2016
 * @Description: 获取webClient并初始化
 * @Company: lxjr.com
 * @Created on 2016-10-31 18:53:16
 */
public class WebClientFactory {
    private volatile static WebClient webClient;
    private WebClientFactory(){}
    public static WebClient getWebClient() {
        if(webClient==null){
            synchronized (WebClient.class){
                if (webClient==null){
                    webClient=new WebClient();
                    //webClient.getCache().clear();
                    //webClient.getCookieManager().clearCookies();
                    webClient.getOptions().setJavaScriptEnabled(true);
                    webClient.getOptions().setCssEnabled(false);
                    webClient.getOptions().setActiveXNative(false);
                    webClient.getOptions().setPopupBlockerEnabled(false);
                    webClient.getOptions().setRedirectEnabled(true);
                    webClient.getOptions().setTimeout(300000);
                    webClient.getOptions().setDoNotTrackEnabled(true);
                    webClient.getCookieManager().setCookiesEnabled(true);
                    webClient.getOptions().setThrowExceptionOnFailingStatusCode(true);
                    webClient.getOptions().setThrowExceptionOnScriptError(false);
                    webClient.getOptions().setUseInsecureSSL(true);
                    webClient.setAjaxController(new NicelyResynchronizingAjaxController());
                    webClient.setAlertHandler(new CollectingAlertHandler());
                }
            }
        }
        return webClient;
    }

}
