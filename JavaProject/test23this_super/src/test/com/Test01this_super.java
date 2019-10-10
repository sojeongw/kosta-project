package test.com;

public class Test01this_super extends Test01super{
	
	String name;
	int age;
	int age2;
	int age3;
	
	public Test01this_super() {
		// Test01super 상속을 받고 나면 Test01super의 생성자가 먼저 실행된다
		// = super(); 가 생략된 것. 자동적으로 call
		super("admin");
		System.out.println("Test01this_super()");
		System.out.println(id);
		System.out.println(pw);
		name = "kim";
		age = 11;
		age2 = 22;
		age3 = 33;
		System.out.println("-------------------");
	}
	
	public Test01this_super(String name) {
		// Test01this_super()에 있는 게 모두 불러와진다.
		// 같은 인자를 받는 생성자가 존재해야 한다.
		// this(), super()는 항상 맨 첫줄에
		this();	// 이거 없으면 0,0,0
		
		System.out.println("Test01this_super(String name)");
		this.name = name;
		
	}
	
	public Test01this_super(String name, int age) {
		// Test01this_super(String name)의 값을 불러오고 싶으면 그 인자를 써준다.
		this("한");
		System.out.println("Test01this_super(String name, int age)");
		this.name = name;
		this.age = age;
	}
	

	public static void main(String[] args) {

		Test01this_super ts = new Test01this_super();
		
		ts = new Test01this_super("lee");
		System.out.println(ts.name);
		System.out.println(ts.age);
		System.out.println(ts.age2);
		System.out.println(ts.age3);
		
		
		
		
		
		
	}	// end of main

}	// end of class
