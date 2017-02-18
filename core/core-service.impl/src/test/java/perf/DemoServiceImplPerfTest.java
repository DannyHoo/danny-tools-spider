package perf;

import com.clarkware.junitperf.ConstantTimer;
import com.clarkware.junitperf.LoadTest;
import com.clarkware.junitperf.TimedTest;
import com.clarkware.junitperf.Timer;
import com.lxjr.credit.account.model.bean.demo.Demo;
import com.lxjr.credit.account.model.parameter.demo.DemoParameter;
import com.lxjr.credit.account.model.result.CreditAccountResult;
import com.lxjr.credit.account.service.DemoService;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * @Title:DemoServiceImplPerfTest.java
 * @Copyright: Copyright (c) 2016
 * @Description:
 * <br>
 * @Company: lxfintech
 * @Created on 2016-11-14下午10:22:22
 * @author miaoxuehui@lxfintech.com
 */
public class DemoServiceImplPerfTest extends AbstractPerfTest {
	private static DemoService demoService;

    @org.junit.Test
    public void testIngore() {

    }
	
	public DemoServiceImplPerfTest(String name) {
		super(name);
	}
	
	@Override
    @SuppressWarnings({ "resource", "unchecked" })
    protected void setUp() {
        synchronized (DemoServiceImplPerfTest.class) {
            if(demoService !=null) {
                return;
            }
            super.setUp();
            demoService = (DemoService)getAppContext().getBean("demoService");
        }
    }
	
	public void insertDemoTest() {
		DemoParameter demo = new DemoParameter();
		demo.setUserName(this.generateAlphanumeric(10));
		CreditAccountResult<Demo> result = demoService.insertDemo(demo);
		 this.print("insert by demo [{}] data is {}",
	                demo, result.getBusinessResult());
	}
	
	public static Test  defineLoginLoadSuite() {
        String name = "insertDemoTest";
        Test loginTestCase = new DemoServiceImplPerfTest(name);
        TestSuite testSuite = new TestSuite();
        //模拟多少个并发用户
        int users = 10;
        //每个用户执行次数
        int iterations = 40;
        //设定最大总执行时间(毫秒)
        long maxElapsedTimeInMillis = 10000;
        //每个线程间隔多少毫秒启动
        Timer timer = new ConstantTimer(50);
        testSuite.addTest(new TimedTest(new LoadTest(loginTestCase, users, iterations, timer)
                , maxElapsedTimeInMillis));

        return testSuite;
    }
	
	 public static void main(String[] args) {
	        TestRunner.run(defineLoginLoadSuite());
	 }
}
