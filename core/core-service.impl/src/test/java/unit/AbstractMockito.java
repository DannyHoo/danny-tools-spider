package unit;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * @author huyuyang@lxfintech.com
 * @Title: AbstractMockito
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 17:00:28
 */
public abstract class AbstractMockito {
	@Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }
}
