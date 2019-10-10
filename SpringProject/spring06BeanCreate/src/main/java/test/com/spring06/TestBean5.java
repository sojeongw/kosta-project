package test.com.spring06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean5 {
	private static final Logger logger = LoggerFactory.getLogger(TestBean5.class);
	
	private int num;
	private String id;
	private String pw;

	public TestBean5() {
		// TODO Auto-generated constructor stub
	}

	public TestBean5(int num, String id, String pw) {
		this.num = num;
		this.id = id;
		this.pw = pw;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	
	
/*	private TestBean4 tb;

	// 생성자로 얘를 받아서 위의 tb를 초기화 하겠다
	private TestBean5(TestBean4 tb) {
		logger.info("TestBean5(TestBean tb)");
		this.tb = tb;
	}*/



	
}
