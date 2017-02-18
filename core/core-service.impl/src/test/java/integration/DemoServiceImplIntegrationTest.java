package integration;

import com.lxjr.credit.account.model.bean.demo.Demo;
import com.lxjr.credit.account.model.parameter.demo.DemoParameter;
import com.lxjr.credit.account.model.result.CreditAccountResult;
import com.lxjr.credit.account.service.DemoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Title:DemoServiceImplIntegrationTest.java
 * @Copyright: Copyright (c) 2016
 * @Description:
 * <br>
 * @Company: lxfintech
 * @Created on 2016-11-14下午10:14:54
 * @author miaoxuehui@lxfintech.com
 */
public class DemoServiceImplIntegrationTest extends BaseServiceSpringTest {
	@Autowired
	private DemoService demoService;
	
	@Test
	public void insertDemo() {
		DemoParameter demo = new DemoParameter();
		demo.setUserName("un");
		CreditAccountResult<Demo> result = demoService.insertDemo(demo);
		Assert.assertNotNull(result);
		this.print("insertDemo data is [{}]", this.toJsonString(result));
	}
}
