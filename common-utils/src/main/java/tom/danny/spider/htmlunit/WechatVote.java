package tom.danny.spider.htmlunit;

import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import org.eclipse.jetty.util.security.Credential;
import org.junit.Test;
import tom.danny.spider.htmlunit.base.BaseRequest;
import tom.danny.spider.htmlunit.base.RequestData;
import tom.danny.spider.htmlunit.base.RequestSender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: TaoBao
 * @Copyright: Copyright (c) 2016
 * @Description: 微信刷票
 * @Company: lxjr.com
 * @Created on 2016-11-01 16:43:15
 */
public class WechatVote extends BaseRequest {

    // 接口请求地址
    private static String loginUrl = "http://9344.vote.m.weimob.com/55880193/9108?playerId=95602&from=groupmessage";

    /**
     * 第一步 获取页面
     */
    @Test
    public void generateUserId() {
        //封装参数
        List<NameValuePair> paramList = getBasicParams();
        paramList.add(new NameValuePair("method", "generateUserId"));

        //请求头部
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Host", "9344.vote.m.weimob.com");
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/wxpc,*/*;q=0.8");
        headers.put("User-Agent", "Mozilla/5.0 (Linux; Android 5.1; m1 metal Build/LMY47I) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/37.0.0.0 Mobile MQQBrowser/6.8 TBS/036872 Safari/537.36 MicroMessenger/6.3.31.940 NetType/WIFI Language/zh_CN");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,en-US;q=0.8");

        //发送请求
        RequestData requestData = new RequestData("UTF-8", loginUrl, "GET");
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


    /*************************登录采集淘宝数据－begin*********************/
    @Test
    public void doPost() {
        final String url = "http://172.30.8.74:9999/api/v1/hfq/loan/status";

        //封装参数
        //List<NameValuePair> paramList = getBasicParams();
        //paramList.add(new NameValuePair("method", "generateUserId"));

        String secretKey = "secretKey";
        String imei = "HUIFENQI";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String nonce = "adfadfadfadsfd";
        String requestBody = "{\"channelOrderId\":\"HUIFENQI2016122815209104\"}";
        String sign = Credential.MD5.digest(requestBody + imei + timestamp + nonce + secretKey);

        //请求头部
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("imei", imei);
        headers.put("timestamp", timestamp);
        headers.put("nonce", nonce);
        headers.put("sign", sign);

        System.out.println(timestamp);
        System.out.println(requestBody);
        System.out.println(sign);
        System.out.println();

        //发送请求
        RequestData requestData = new RequestData("UTF-8", url, "POST");
        requestData.setRequestBody(requestBody);
        requestData.setHeaders(headers);

        HtmlPage requestResultPage = (HtmlPage) RequestSender.requestAndReturn(requestData);

        //获取结果
        WebResponse loginResponse = requestResultPage.getWebResponse();
        String resHtml = loginResponse.getContentAsString();
        System.out.println("请求结果");
        System.out.println(resHtml);

    }

}
