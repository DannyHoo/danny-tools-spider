package perf;

import com.google.gson.Gson;
import junit.framework.TestCase;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Title:AbstractPerfTest.java
 * @Copyright: Copyright (c) 2016
 * @Description:
 * <br>
 * @Company: lxfintech
 * @Created on 2016-11-13下午9:58:35
 * @author miaoxuehui@lxfintech.com
 */
public abstract class AbstractPerfTest extends TestCase {
	public static String SPRING_PATH = "classpath:/bean/service-bean-test.xml";
    protected static ApplicationContext appContext;

    public AbstractPerfTest(String name) {
        super(name);
    }

    protected void setUp() {
        if(appContext != null) {
            print("app context is exist");
            return ;
        }
        appContext = new ClassPathXmlApplicationContext(SPRING_PATH);
    }

    public static ApplicationContext getAppContext() {
        return appContext;
    }

    public void print(Object obj) {
        this.print("{}", this.toJsonString(obj));
    }

    public void print(String message, Object...objects) {
        message =  MessageFormatter.arrayFormat(message, objects).getMessage();
        System.out.println(message);
    }

    public String toJsonString(Object obj) {
        if(obj == null) {
            return null;
        }
        if(obj instanceof String) {
            return obj.toString();
        }
        return new Gson().toJson(obj);
    }

    protected String generateAlphanumeric(int bit) {
        return RandomStringUtils.randomAlphanumeric(bit);
    }

    protected String generatenumeric(int bit) {
        return RandomStringUtils.randomNumeric(bit);
    }

    protected String getMobile() {
        return this.generatenumeric(11);
    }

    protected String getSmsCode() {
        return this.generatenumeric(6);
    }

    protected String getToken() {
        return this.generateAlphanumeric(32);
    }
}
