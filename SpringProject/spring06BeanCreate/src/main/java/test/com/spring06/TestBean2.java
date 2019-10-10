package test.com.spring06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean2 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean2.class);
	
	private String name = "kim";

	public String getName() {
		logger.info("getName()");
		return name;
	}

	public void setName(String name) {
		logger.info("setName(String name) : " + name);
		this.name = name;
	}
	
	

}
