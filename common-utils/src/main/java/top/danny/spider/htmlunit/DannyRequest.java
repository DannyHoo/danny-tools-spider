package top.danny.spider.htmlunit;

import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.Test;
import top.danny.spider.htmlunit.base.RequestData;
import top.danny.spider.htmlunit.base.RequestSender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DannyRequest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-01-24 16:31:00
 */
public class DannyRequest {

    //final String url = "http://tool7001.com/";
    //HtmlTable table=(HtmlTable)(requestResultPage.getByXPath("/html/body/div[3]/div[2]/table"));

    @Test
    public void doPost() {
        final String url = "http://www.bangnishouji.com/idcard/201501/154142_6.html";

        //封装参数
        //List<NameValuePair> paramList = getBasicParams();
        //paramList.add(new NameValuePair("method", "generateUserId"));

        String Accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8";
        String AcceptEncoding = "gzip, deflate, sdch";
        String AcceptLanguage = "zh-CN,zh;q=0.8,en;q=0.6";
        String CacheControl = "max-age=0";
        String Connection = "keep-alive";
        String Host = "tool7001.com";
        String UpgradeInsecureRequests ="1";
        String UserAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";

        //请求头部
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Host", Host);
        //headers.put("Connection", Connection);
        //headers.put("Cache-Control", CacheControl);
        //headers.put("Upgrade-Insecure-Requests", UpgradeInsecureRequests);
        headers.put("User-Agent", UserAgent);
        headers.put("Accept", Accept);
        headers.put("Accept-Encoding", AcceptEncoding);
        headers.put("Accept-Language", AcceptLanguage);

        //发送请求
        RequestData requestData = new RequestData("UTF-8", url, "GET");
        /*requestData.setRequestBody(requestBody);*/
        //requestData.setHeaders(headers);

        HtmlPage requestResultPage = (HtmlPage) RequestSender.requestAndReturn(requestData);


        List list=requestResultPage.getByXPath("/html/body/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/table");
        HtmlTable table=(HtmlTable)list.get(0);
        //HtmlImage valiCodeImg=(HtmlImage)(requestResultPage.getByXPath("/html/body/div[2]/div[1]/form/p[5]/img").get(0));
        List<HtmlTableRow> htmlTableRowList=table.getRows();
        for (HtmlTableRow htmlTableRow:htmlTableRowList){
            String a=htmlTableRow.getAlignAttribute();
            List<HtmlTableCell> htmlTableCellList=htmlTableRow.getCells();
            String b=htmlTableCellList.get(0).asText();//41150319740118630 唐玄子
            String b2=htmlTableCellList.get(1).asText();//女
            String b12=htmlTableCellList.get(2).asText();//40
            String b11=htmlTableCellList.get(3).asText();//河南 信阳 平桥区
        }

        //获取结果
        WebResponse loginResponse = requestResultPage.getWebResponse();
        String resHtml = loginResponse.getContentAsString();
        System.out.println("请求结果");
        System.out.println(resHtml);

    }

    public static void main(String[] args) {
        final ThreadLocal<Long> threadLocal=new ThreadLocal<Long>();
        for (int i=0;i<20;i++){
            Thread thread=new Thread(new Runnable() {
                public void run() {
                    threadLocal.set(0L);
                    while(true){
                        doRequest();
                        threadLocal.set(threadLocal.get()+1);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"第 "+threadLocal.get()+" 次访问");
                    }
                }
            });
            thread.start();
        }
    }
    public static void doRequest(){
        final String url = "http://www.icloud-applyine.com/ids?20170124=6291313-1-1.html";
        RequestData requestData = new RequestData("UTF-8", url, "GET");
        com.gargoylesoftware.htmlunit.TextPage textPage=(TextPage) RequestSender.requestAndReturn(requestData);
        //HtmlPage requestResultPage = (HtmlPage) RequestSender.requestAndReturn(requestData);
        //WebResponse loginResponse = requestResultPage.getWebResponse();
        WebResponse loginResponse = textPage.getWebResponse();
        String resHtml = loginResponse.getContentAsString();
        /*System.out.println("请求结果");
        System.out.println(resHtml);*/
    }
}
