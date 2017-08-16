package top.danny.spider.controller;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.danny.spider.model.bean.User;
import top.danny.spider.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * @author huyuyang@lxfintech.com
 * @Title: IndexController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 17:51:34
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {

        /*String agent = request.getHeader("user-agent");
        System.out.println(agent);
        StringTokenizer st = new StringTokenizer(agent, ";");
        st.nextToken();
        String userbrowser = st.nextToken();
        System.out.println(userbrowser);
        String useros = st.nextToken();
        System.out.println(useros);
        System.out.println(System.getProperty("os.name")); //win2003竟然是win xp？
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(request.getHeader("user-agent")); //返回客户端浏览器的版本号、类型
        System.out.println(request.getMethod()); //：获得客户端向服务器端传送数据的方法有get、post、put等类型
        System.out.println(request.getRequestURI()); //：获得发出请求字符串的客户端地址
        System.out.println(request.getServletPath()); //：获得客户端所请求的脚本文件的文件路径
        System.out.println(request.getServerName()); //：获得服务器的名字
        System.out.println("ServerPort: " +request.getServerPort()); //：获得服务器的端口号
        System.out.println("RemoteAddr: " +request.getRemoteAddr()); //：获得客户端的ip地址
        System.out.println("RemoteHost: " +request.getRemoteHost()); //：获得客户端电脑的名字，若失败，则返回客户端电脑的ip地址
        System.out.println("Protocol: " +request.getProtocol()); //：
        System.out.println("HeaderNames: " +request.getHeaderNames()); //：返回所有request header的名字，结果集是一个enumeration（枚举）类的实例
        System.out.println("Scheme: " + request.getScheme());
        System.out.println("Server Name: " + request.getServerName());
        System.out.println("Server Port: " + request.getServerPort());
        System.out.println("Protocol: " + request.getProtocol());
        System.out.println("Server Info: " );
        System.out.println("Remote Addr: " + request.getRemoteAddr());
        System.out.println("Remote Host: " + request.getRemoteHost());
        System.out.println("Character Encoding: " + request.getCharacterEncoding());
        System.out.println("Content Length: " + request.getContentLength());
        System.out.println("Content Type: " + request.getContentType());
        System.out.println("Auth Type: " + request.getAuthType());
        System.out.println("HTTP Method: " + request.getMethod());
        System.out.println("Path Info: " + request.getPathInfo());
        System.out.println("Path Trans: " + request.getPathTranslated());
        System.out.println("Query String: " + request.getQueryString());
        System.out.println("Remote User: " + request.getRemoteUser());
        System.out.println("Session Id: " + request.getRequestedSessionId());
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("Servlet Path: " + request.getServletPath());
        System.out.println("Accept: " + request.getHeader("Accept"));
        System.out.println("Host: " + request.getHeader("Host"));
        System.out.println("Referer : " + request.getHeader("Referer"));
        System.out.println("Accept-Language : " + request.getHeader("Accept-Language"));
        System.out.println("Accept-Encoding : " + request.getHeader("Accept-Encoding"));
        System.out.println("User-Agent : " + request.getHeader("User-Agent"));
        System.out.println("Connection : " + request.getHeader("Connection"));
        System.out.println("Cookie : " + request.getHeader("Cookie"));
*/

        /*User user = new User();
        user.setUserName("danny")
                .setPassword("123456")
                .setRealName("访问者")
                .setIdCardNo("187302199009098918")
                .setMobileNo("18730984987")
                .setAge(26)
                .setBirthday(new Date())
                .setComment("IP:"+request.getRemoteAddr()+";Host:"+request.getRemoteHost())
        ;
        User userSaved = userService.saveUser(user);*/
        return "index";
    }

    public void saveUserTest() {
        User user = getUser();
        User userSaved = userService.saveUser(user);
        Assert.assertNotNull(userSaved);
    }

    private User getUser() {
        User user = new User();
        user.setUserName("danny")
                .setPassword("123456")
                .setRealName("访问者")
                .setIdCardNo("187302199009098918")
                .setMobileNo("18730984987")
                .setAge(26)
                .setBirthday(new Date())
        .setComment("IP:")
        ;
        return user;
    }
}
