package top.danny.spider.service.component;

import org.apache.http.NameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.stereotype.Component;
import top.danny.spider.httpclient.HttpRequest;
import top.danny.spider.model.bean.User;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: QueryAddressByIdCard
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-31 13:48:17
 */
@Component("queryAddressByIdCard")
public class QueryAddressByIdCard {

    private static final String queryUrl = "http://shenfenzheng.293.net/";

    public String getNewAddress(String idCardNo) {
        IdCardCrawling crawler = new IdCardCrawling();
        String getData = HttpRequest.sendPost(queryUrl, getNameValuePairs(idCardNo));
        String address = "";
        try {
            address = getAddress(getData);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return address;
    }

    /*
     * 使用jsoup解析网页信息
     */
    private String getAddress(String html) throws UnsupportedEncodingException {
        List<User> userInfoList = new ArrayList<User>(0);
        html = new String(html.getBytes("ISO-8859-1"), "UTF-8");
        Document document = Jsoup.parse(html);
        Elements table = document.select("table[width=580]");
        Elements trs = table.get(0).select("tr");
        Elements tds = trs.get(0).select("td");
        Elements ps = tds.get(0).select("p");
        String address = ps.get(2).html();
        address = address.substring(address.indexOf("F\">") + 3, address.indexOf("</font>"));
        return address;
    }

    public static List<NameValuePair> getNameValuePairs(final String idCardNo) {
        List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
        NameValuePair nameValuePair1 = new NameValuePair() {
            public String getName() {
                return "id";
            }

            public String getValue() {
                return idCardNo;
            }
        };
        NameValuePair nameValuePair2 = new NameValuePair() {
            public String getName() {
                return "submits";
            }

            public String getValue() {
                return "身份证查询";
            }
        };
        nameValuePairList.add(nameValuePair1);
        nameValuePairList.add(nameValuePair2);
        return nameValuePairList;
    }
}
