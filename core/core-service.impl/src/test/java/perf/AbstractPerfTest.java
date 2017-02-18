package perf;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huyuyang@lxfintech.com
 * @Title: AbstractPerfTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 16:55:49
 */
public abstract class AbstractPerfTest extends TestCase {
	public static String SPRING_PATH = "classpath:/bean/service-bean-test.xml";
    protected static ApplicationContext appContext;

    public AbstractPerfTest(String name) {
        super(name);
    }

    protected void setUp() {
        if(appContext != null) {
            System.out.println("app context is exist");
            return ;
        }
        appContext = new ClassPathXmlApplicationContext(SPRING_PATH);
    }

    public static ApplicationContext getAppContext() {
        return appContext;
    }


}
