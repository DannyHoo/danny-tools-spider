package top.danny.spider.service.component;

import org.apache.http.NameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.danny.spider.httpclient.HttpRequest;
import top.danny.spider.model.bean.User;
import top.danny.spider.service.UserService;
import top.danny.spider.utils.ChinesePinYin;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: IdCardCrawling
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-11 22:49:47
 */
@Component("idCardCrawling")
public class IdCardCrawling implements CrawlingUserInfo{
    @Autowired
    private UserService userService;

    private final static String url = "http://shenfenzheng.293.net/";

    //@Scheduled(cron = "0 * * * * ?")
    public void execute() {
        System.out.println("开始爬取……");
        run();
        System.out.println("开始爬取……");
    }

    @Override
    public boolean run() {
        IdCardCrawling crawler = new IdCardCrawling();
        String getData = HttpRequest.sendPost(url,getNameValuePairs());
        List<User> userList = new ArrayList<User>(0);
        try {
            userList = crawler.getUserList(getData);
            for (User user:userList){
                userService.saveUser(user);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static List<NameValuePair> getNameValuePairs() {
        List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
        NameValuePair nameValuePair = new NameValuePair() {
            public String getName() {
                return "id";
            }

            public String getValue() {
                return "reload...";
            }
        };
        nameValuePairList.add(nameValuePair);
        return nameValuePairList;
    }

    /*
     * 使用jsoup解析网页信息
     */
    private List<User> getUserList(String html) throws UnsupportedEncodingException {
        List<User> userInfoList = new ArrayList<User>(0);
        html = new String(html.getBytes("ISO-8859-1"), "UTF-8");
        Document document = Jsoup.parse(html);
        Elements table = document.select("table[bgcolor=#999999]");
        Elements trs = table.get(0).select("tr[bgcolor=#FFFFFF]");
        for (int i = 0; i < trs.size(); i++) {
            Elements tds = trs.get(i).select("td");
            User user=getUser(tds);
            userInfoList.add(user);
        }
        return userInfoList;
    }

    public User getUser(Elements tds) {
        String[] realNameAndIdCard = tds.get(0).html().split(" ");
        String realName = realNameAndIdCard[0];
        String idCard = realNameAndIdCard[1];
        String sexStr = tds.get(1).html();
        String ageStr = tds.get(2).html();
        String address = tds.get(3).html();
        int sex = getSex(sexStr);
        int age = getAge(ageStr);
        return getUser(realName,idCard,sex,age,address);
    }

    private User getUser(String realName, String idCard, int sex, int age, String address) {
        User user = new User().
                setUserName(ChinesePinYin.getPingYin(realName)).
                setRealName(realName)
                .setIdCardNo(idCard)
                .setSex(sex)
                .setAge(26).setAddress(address);
        return user;
    }

    private int getAge(String ageStr) {
        try {
            return Integer.parseInt(ageStr);
        } catch (Exception e) {
            return 0;//年龄未知
        }
    }

    private int getSex(String sex) {
        int sexInt = 0;//性别未知
        if (sex == null || sex == "") {
            return sexInt;//默认未知
        }
        if (sex.equals("男")) {
            sexInt = 1;
        }
        if (sex.equals("女")) {
            sexInt = 2;
        }
        return sexInt;
    }
}

