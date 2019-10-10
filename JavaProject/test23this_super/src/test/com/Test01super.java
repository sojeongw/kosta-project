package test.com;

public class Test01super{

	String id;
	String pw;
	
	public Test01super() {
		System.out.println("Test01super()");
		id = "admin";
		pw = "hi123456";
	}
	
	public Test01super(String id) {
		this();
		System.out.println("Test01super(String id)");
		this.id = id;
	}
	
	
	
	
	
}	// end of class
