package test.com.spring06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean4 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean4.class);
	
	private TestBean tb;

	// 생성자로 얘를 받아서 위의 tb를 초기화 하겠다
	private TestBean4(TestBean tb) {
		logger.info("TestBean4(TestBean tb)");
		this.tb = tb;
	}

	
}
