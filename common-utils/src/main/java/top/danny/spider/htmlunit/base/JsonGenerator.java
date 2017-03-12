package top.danny.spider.htmlunit.base;

import com.gargoylesoftware.htmlunit.util.NameValuePair;

import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: JsonGenerator
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2016-11-23 11:32:32
 */
public class JsonGenerator {
    private static String createLoginReqBody(List<NameValuePair> paramList) {
        StringBuffer xmlReq = new StringBuffer();
        for (NameValuePair nameValuePair : paramList) {

        }

        /*StringBuffer xmlReq = new StringBuffer();
        xmlReq.append("<request><logonEbank ");
        xmlReq.append("phonesecretcode=\"").append(password).append("\" ");
        xmlReq.append("logintype=\"02\" ");
        xmlReq.append("idtype=\"").append(idType).append("\" ");
        xmlReq.append("idnumber=\"").append(loginId).append("\" ");
        xmlReq.append("valicode=\"").append(verifyCode).append("\" ");
        xmlReq.append("from=\"").append(from).append("\" ");
        xmlReq.append("channel=\"").append(channel).append("\" ");
        xmlReq.append("source=\"").append(source).append("\"/>");*/
        xmlReq.append("</request>");

        return xmlReq.toString();
    }
}
