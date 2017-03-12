package top.danny.spider.htmlunit;


import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import top.danny.spider.htmlunit.base.BaseRequest;
import top.danny.spider.htmlunit.base.RequestData;
import top.danny.spider.htmlunit.base.RequestSender;

/**
 * @author huyuyang@lxfintech.com
 * @Title: JSTest
 * @Copyright: Copyright (c) 2016
 * @Description: http://www.dsdwwe.com/cheng/kaKNgDiB/1_1.jpg
 * @Company: lxjr.com
 * @Created on 2016-11-27 00:14:48
 */
public class JSTest extends BaseRequest {
    // 接口请求地址
    private static String indexUrl="http://www.3jiuseteng.com/";
    private static String loginUrl = "http://www.dsdwwe.com/cheng/kaKNgDiB/1_1.jpg";

    /**
     * 第一步 获取页面
     */
    @Test
    public void getIndex(){
        //封装参数
        /*List<NameValuePair> paramList = getBasicParams();
        paramList.add(new NameValuePair("method", "generateUserId"));*/

        //请求头部
//        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("Host", "9344.vote.m.weimob.com");
//        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/wxpc,*/*;q=0.8");
//        headers.put("User-Agent", "Mozilla/5.0 (Linux; Android 5.1; m1 metal Build/LMY47I) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/37.0.0.0 Mobile MQQBrowser/6.8 TBS/036872 Safari/537.36 MicroMessenger/6.3.31.940 NetType/WIFI Language/zh_CN");
//        headers.put("Accept-Encoding", "gzip, deflate");
//        headers.put("Accept-Language", "zh-CN,en-US;q=0.8");

        //发送请求
        RequestData requestData = new RequestData("UTF-8", indexUrl, "GET");
        //requestData.setParamList(paramList);

        HtmlPage requestResultPage = (HtmlPage) RequestSender.requestAndReturn(requestData);

        //获取结果
        WebResponse loginResponse = requestResultPage.getWebResponse();
        String resHtml = loginResponse.getContentAsString();
        System.out.println("第一步 获取页面：");
        System.out.println(resHtml);

        //返回结果示例
        //{"result":true,"code":0,"msg":"002201611031522299959487"}
    }
}
