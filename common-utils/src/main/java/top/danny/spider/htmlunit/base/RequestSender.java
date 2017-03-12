package top.danny.spider.htmlunit.base;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebRequest;

import java.net.URL;

/**
 * @author huyuyang@lxfintech.com
 * @Title: RequestSender
 * @Copyright: Copyright (c) 2016
 * @Description: 请求发送处理
 * @Company: lxjr.com
 * @Created on 2016-10-31 14:44:39
 */
public class RequestSender {
    /**
     * 发送请求，并返回页面
     * @param requestData 请求必备条件（请求地址、httpmethod、请求参数等）
     * @return
     */
    public static Page requestAndReturn(RequestData requestData){
        Page page = null;

        try {

            //实例化http请求－request，需要参数：url，method
            WebRequest request = new WebRequest(new URL(requestData.getRequestUrl()), HttpMethod.valueOf(requestData.getHttpMethod()));

            //http请求设置编码
            request.setCharset(requestData.getCharset());

            //http请求设置header
            if (requestData.getHeaders() != null) {
                request.getAdditionalHeaders().putAll(requestData.getHeaders());
            }

            //http请求设置请求参数
            if (requestData.getParamList() != null) {
                request.setRequestParameters(requestData.getParamList());
            } else if (requestData.getRequestBody() != null) {
                //http请求设置requestbody
                request.setRequestBody(requestData.getRequestBody());
            }

            int retryTimes = 3;
            for (int i = 0; page == null && i < retryTimes; i++) {
                try {
                    page = WebClientFactory.getWebClient().getPage(request);

                    //请求成功之后获得响应码
                    if (page != null) {
                        int responseCode = page.getWebResponse().getStatusCode();
                        String responseMsg = page.getWebResponse().getStatusMessage();
                        //后续处理Y(^_^)Y
                    }
                } catch (Exception e) {
                    System.out.println("页面加载失败:" + requestData.getRequestUrl());
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return page;
    }
}
