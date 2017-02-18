package unit;

import com.lxjr.credit.account.domain.demo.DemoDomainRepository;
import com.lxjr.credit.account.model.bean.demo.Demo;
import com.lxjr.credit.account.model.parameter.demo.DemoParameter;
import com.lxjr.credit.account.model.result.CreditAccountResult;
import com.lxjr.credit.account.service.impl.DemoServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * @Title:DemoServiceImplUnitTest.java
 * @Copyright: Copyright (c) 2016
 * @Description:
 * <br>
 * @Company: lxfintech
 * @Created on 2016-11-13下午10:02:38
 * @author miaoxuehui@lxfintech.com
 */
public class DemoServiceImplUnitTest extends AbstractMockito {
	@Mock
    private DemoDomainRepository demoDomainRepository;
    @InjectMocks
    private DemoServiceImpl demoService;
    
    @Before
    public void before() {
        super.before();
    }
    
    @Test
    public void insertDemo() {
    	Demo demo = new Demo();
    	demo.setUserName("un");
    	Mockito.when(demoDomainRepository.insertDemo(Mockito.any(DemoParameter.class))).thenReturn(demo);
    	CreditAccountResult<Demo> result = demoService.insertDemo(null);
    	Assert.assertNotNull(result);
    	Assert.assertEquals(demo.getUserName(), result.getBusinessObject().getUserName());
    	this.print("insertDemo data is {}", this.toJsonString(result));
    }
}
