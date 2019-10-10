package test.com.spring06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
*/
@Configuration
public class TestConfig {

	private static final Logger logger = LoggerFactory.getLogger(TestConfig.class);
	
	// 이 어노테이션 방법은 3.0 이상에서만 쓸 수 있다. 보통은 root-context.xml에 있는 방식으로 한다.
	@Bean
	public TestBean5 getTestBean5() {
		logger.info("TestBean5 getTestBean5()");
		
		/*<constructor-arg>
			<value>lee</value>
		</constructor-arg>
		<constructor-arg>
			<value>yang</value>
		</constructor-arg>*/
		return new TestBean5(77,"aaa","bbb");
		/*TestBean5 tb = new TestBean5();
		tb.setNum(99);
		tb.setId("id");
		tb.setPw("pw");
		return tb;*/
	}

}
