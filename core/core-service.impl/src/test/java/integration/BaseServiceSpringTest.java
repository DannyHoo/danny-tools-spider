package integration;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseServiceSpringTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 16:55:49
 */
@ContextConfiguration(locations = { "classpath:/spring/applicationContext-service.xml" })
public abstract class BaseServiceSpringTest extends
		AbstractJUnit4SpringContextTests {

}
