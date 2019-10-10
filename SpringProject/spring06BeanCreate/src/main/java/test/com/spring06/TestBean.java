package test.com.spring06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean {
	private static final Logger logger = LoggerFactory.getLogger(TestBean.class);
	
	public String name = "kim";
	public String name2 = "kim2";

	
	public TestBean() {
		logger.info("TestBean()...");
	}
	
	public TestBean(String name, String name2) {
		logger.info("TestBean(String name, String name2)...");
		this.name = name;
		this.name2 = name2;
	}
	
	public void test() {
		System.out.println("Test()...");
	}

}
