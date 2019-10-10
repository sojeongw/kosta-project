package test.com.spring06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean3 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean3.class);
	
	private TestBean tb;

	public TestBean getTb() {
		logger.info("getTb");
		return tb;
	}

	public void setTb(TestBean tb) {
		logger.info("setTb : " + tb.toString());
		this.tb = tb;
	}

	
}
