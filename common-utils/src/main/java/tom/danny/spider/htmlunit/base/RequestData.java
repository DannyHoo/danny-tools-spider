package tom.danny.spider.htmlunit.base;

import com.gargoylesoftware.htmlunit.util.NameValuePair;

import java.util.List;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: RequestData
 * @Copyright: Copyright (c) 2016
 * @Description: 每次请求条件的风阻昂
 * @Company: lxjr.com
 * @Created on 2016-10-31 14:56:55
 */
public class RequestData {
    private String charset;//请求字符集
    private String requestUrl;//请求地址
    private String httpMethod;//请求http方式
    private String requestBody;//字符串型的requestbody
    Map<String, String> headers;//请求头部
    List<NameValuePair> paramList;//请求参数

    public RequestData(String charset, String requestUrl, String httpMethod) {
        this.charset = charset;
        this.requestUrl = requestUrl;
        this.httpMethod = httpMethod;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public List<NameValuePair> getParamList() {
        return paramList;
    }

    public void setParamList(List<NameValuePair> paramList) {
        this.paramList = paramList;
    }
}