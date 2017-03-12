package top.danny.spider.htmlunit.base;

/**
 * @author huyuyang@lxfintech.com
 * @Title: FormatCookie
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2016-11-01 16:00:46
 */
public class FormatCookie {
    public static String formatAlipayCookie(String cookie){
        StringBuffer sbResult=new StringBuffer("[");

        //String cookie="cna=952DEEJAeUgCAWomePLiYHKJ; session.cookieNameId=ALIPAYJSESSIONID; mobileSendTime=-1; credibleMobileSendTime=-1; ctuMobileSendTime=-1; riskMobileBankSendTime=-1; riskMobileAccoutSendTime=-1; riskMobileCreditSendTime=-1; riskCredibleMobileSendTime=-1; riskOriginalAccountMobileSendTime=-1; ctoken=82J8LcRLmcmM0YAD; zone=RZ13B; ALIPAYJSESSIONID.sig=XPH3g4yC4FyCUKTH6XLPvX7yAvjQWLkczyVmfVOQwik; spanner=HebElhSjIVdfBf7TTZWgbGCZuEWyC7t3Xt2T4qEYgj0=; ALIPAYJSESSIONID=RZ13mE5Vy0YJULJNxfOVavgbUXAx6LauthRZ13GZ00";
        String[] cookies=cookie.split("; ");
        for (int i=0;i<cookies.length;i++) {

            StringBuffer sb=new StringBuffer("{");
            String[] strs=cookies[i].split("=");

            sb.append("\"name\":\"");
            sb.append(strs[0]+"\",");
            sb.append("\"value\":\"");
            sb.append(strs[1]+"\",");
            sb.append("\"domain\":\"my.alipay.com\", \"path\":\"/\"}");

            if (i!=cookies.length-1){
                sb.append(",");
            }
            sbResult.append(sb.toString());
        }
        sbResult.append("]");
        System.out.println(sbResult.toString());
        return sbResult.toString();
    }

    public static String formatTaobaoCookie(String cookie){
        StringBuffer sbResult=new StringBuffer("[");

        //String cookie="cna=952DEEJAeUgCAWomePLiYHKJ; session.cookieNameId=ALIPAYJSESSIONID; mobileSendTime=-1; credibleMobileSendTime=-1; ctuMobileSendTime=-1; riskMobileBankSendTime=-1; riskMobileAccoutSendTime=-1; riskMobileCreditSendTime=-1; riskCredibleMobileSendTime=-1; riskOriginalAccountMobileSendTime=-1; ctoken=82J8LcRLmcmM0YAD; zone=RZ13B; ALIPAYJSESSIONID.sig=XPH3g4yC4FyCUKTH6XLPvX7yAvjQWLkczyVmfVOQwik; spanner=HebElhSjIVdfBf7TTZWgbGCZuEWyC7t3Xt2T4qEYgj0=; ALIPAYJSESSIONID=RZ13mE5Vy0YJULJNxfOVavgbUXAx6LauthRZ13GZ00";
        String[] cookies=cookie.split("; ");
        for (int i=0;i<cookies.length;i++) {

            StringBuffer sb=new StringBuffer("{");
            String[] strs=cookies[i].split("=");

            sb.append("\"name\":\"");
            sb.append(strs[0]+"\",");

            sb.append("\"value\":\"");
            if(strs[0].equals("uc1")){
                sb.append(cookies[i].replace((strs[0]+"="),"")+"\",");
            }else{
                sb.append(strs[1]+"\",");
            }

            if(strs[0].equals("abt")){
                sb.append("\"domain\":\".h5.m.taobao.com\",");
            }else if(strs[0].equals("_w_app_lg") || strs[0].equals("_w_tb_nick") ||strs[0].equals("ntm") ||strs[0].equals("ockeqeudmj") ||strs[0].equals("WAPFDFDTGFG")){
                sb.append("\"domain\":\".m.taobao.com\",");
            }else{
                sb.append("\"domain\":\".taobao.com\",");
            }

            sb.append("\"path\":\"/\"}");

            if (i!=cookies.length-1){
                sb.append(",");
            }
            sbResult.append(sb.toString());
        }
        sbResult.append("]");
        System.out.println(sbResult.toString());
        return sbResult.toString();
    }
}
