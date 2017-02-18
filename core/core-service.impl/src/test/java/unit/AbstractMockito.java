package unit;

import com.lxjr.credit.account.service.AbstractServiceTest;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * @Title:AbstractMockito.java
 * @Copyright: Copyright (c) 2016
 * @Description:
 * <br>
 * @Company: lxfintech
 * @Created on 2016-11-13下午9:57:40
 * @author miaoxuehui@lxfintech.com
 */
public abstract class AbstractMockito extends AbstractServiceTest {
	@Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }
}
