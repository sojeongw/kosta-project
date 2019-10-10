package test.com;

public class Test03Score {
	
	Test03Student st;
	
	public Test03Score(){
		st = new Test03Student();
	}
	
	public Test03Score(Test03Student st) {
		System.out.println("Test03Score(Test03Student st)");
		this.st = st;
	}

}
