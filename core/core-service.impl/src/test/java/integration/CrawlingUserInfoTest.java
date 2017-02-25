package integration;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tom.danny.spider.htmlunit.base.RequestData;
import tom.danny.spider.htmlunit.base.RequestSender;
import top.danny.spider.model.bean.User;
import top.danny.spider.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: CrawlingUserInfoTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-25 20:29:36
 */
public class CrawlingUserInfoTest extends BaseServiceSpringTest{

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        saveUser();
        System.out.println("d");
    }

    public void saveUser() {
        List<User> userList = new ArrayList<User>();
        try {
            userList = getUserList();
            System.out.println("userList大小：" + userList.size());
        } catch (Exception e) {
            System.out.println("发生异常");
        }

        long startTime = System.currentTimeMillis();
        System.out.println("开始插入:");
        for (User user : userList) {
            User userSaved = userService.saveUser(user);
            System.out.println("插入数据:" + user.getRealName());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("插入结束，插入数据行数：+" + userList.size() + "；耗时：" + (endTime - startTime));
    }


    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>(100);
        final String url = "http://www.bangnishouji.com/idcard/201501/154142_6.html";
        RequestData requestData = new RequestData("UTF-8", url, "GET");
        HtmlPage requestResultPage = (HtmlPage) RequestSender.requestAndReturn(requestData);

        List list = requestResultPage.getByXPath("/html/body/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/table");
        HtmlTable table = (HtmlTable) list.get(0);
        List<HtmlTableRow> htmlTableRowList = table.getRows();
        for (HtmlTableRow htmlTableRow : htmlTableRowList) {
            String a = htmlTableRow.getAlignAttribute();
            List<HtmlTableCell> htmlTableCellList = htmlTableRow.getCells();
            String nameAndIdCardStr = htmlTableCellList.get(0).asText();//41150319740118630 唐玄子
            String sexStr = htmlTableCellList.get(1).asText();//女
            String ageStr = htmlTableCellList.get(2).asText();//40
            String address = htmlTableCellList.get(3).asText();//河南 信阳 平桥区

            String[] nameAndIdCardArr = nameAndIdCardStr.split(" ");
            String idCard = nameAndIdCardArr[0];
            String realName = nameAndIdCardStr.replace(idCard, "");
            int sex = getSex(sexStr);
            int age = getAge(ageStr);
            userList.add(getUser(realName, idCard, sex, age, address));
        }
        return userList;
    }

    private int getAge(String ageStr) {
        try {
            return Integer.parseInt(ageStr);
        } catch (Exception e) {
            return 0;//年龄未知
        }
    }

    private User getUser(String realName, String idCard, int sex, int age, String address) {
        User user = new User().
                setUserName(idCard).
                setRealName(realName)
                .setIdCardNo(idCard)
                .setSex(sex)
                .setAge(26).setAddress(address);
        return user;
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
