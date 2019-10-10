package test.com;

public class Test02 {

	Object object;
	Test01Anonymous am;
	
	
	public Test02(Object object) {
		this.object = object;
	}
	
	public Test02(Test01Anonymous am) {
		am.aaa();
		this.am = am;
	}

	public Test02() {
	}


	public void addListener(Test01Anonymous test01Anonymous) {
		am.aaa();
	}

	public void addListener(Test01Anonymous2 test01Anonymous2) {
		// TODO Auto-generated method stub
		
	}


}
