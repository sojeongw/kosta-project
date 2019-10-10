package test.com;

public class Test01this_super extends Test01super{
	
	String name;
	int age;
	int age2;
	int age3;
	
	public Test01this_super() {
		// Test01super ����� �ް� ���� Test01super�� �����ڰ� ���� ����ȴ�
		// = super(); �� ������ ��. �ڵ������� call
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
		// Test01this_super()�� �ִ� �� ��� �ҷ�������.
		// ���� ���ڸ� �޴� �����ڰ� �����ؾ� �Ѵ�.
		// this(), super()�� �׻� �� ù�ٿ�
		this();	// �̰� ������ 0,0,0
		
		System.out.println("Test01this_super(String name)");
		this.name = name;
		
	}
	
	public Test01this_super(String name, int age) {
		// Test01this_super(String name)�� ���� �ҷ����� ������ �� ���ڸ� ���ش�.
		this("��");
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
