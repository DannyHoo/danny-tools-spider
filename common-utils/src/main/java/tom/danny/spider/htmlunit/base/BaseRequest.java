package tom.danny.spider.htmlunit.base;

import com.gargoylesoftware.htmlunit.util.NameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseRequest
 * @Copyright: Copyright (c) 2016
 * @Description: 所有请求公共数据的抽象类
 * @Company: lxjr.com
 * @Created on 2016-11-01 22:43:15
 */
public class BaseRequest {

    //调用方ID(由91征信提供,如DFDA7161-B077-4F65-A15B-2829F8CE9FC3)
    protected final static String jytoken = "DFDA7161-B077-4F65-A15B-2829F8CE9FC3";

    //每次请求的唯一用户标识 userid(一次完整的抓取 userid 保持不变;新的抓取需要新的 userid)
    protected static String userId = "";

    //获取基本参数集合
    protected static List<NameValuePair> getBasicParams() {
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new NameValuePair("jytoken", jytoken));
        return paramList;
    }

}
