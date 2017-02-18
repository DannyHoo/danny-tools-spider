package integration;

import com.google.gson.Gson;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @Title:BaseServiceSpringTest.java
 * @Copyright: Copyright (c) 2016
 * @Description:
 * <br>
 * @Company: lxfintech
 * @Created on 2016-11-13下午9:59:57
 * @author miaoxuehui@lxfintech.com
 */
@ContextConfiguration(locations = { "classpath:/bean/service-bean-test.xml" })
public abstract class BaseServiceSpringTest extends
		AbstractJUnit4SpringContextTests {
	public void fail(Exception e) {
		e.printStackTrace();
		Assert.fail(e.getMessage());
	}
	
	public void fail(String message) {
		Assert.fail(message);
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
