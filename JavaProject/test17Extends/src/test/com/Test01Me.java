package test.com;

public /*final*/ class Test01Me extends Test01Father{
	// final �ϸ� child�� me ����� �� ��������.
	
	String name;
	int age;
	
	public Test01Me(){
		// super(); �� ������ �Ǿ��� �ֱ� ������ Test01Father father = new Test01Me();�� ����.
		// this(); �� �ڱⰡ �ڱ⸦ call�� ���� �����Ƿ� ����.
		System.out.println("Test01Me...");
		// father���ε��� �ٷ� �� �� �ִ�.
		// System.out.println(getLastName());
	}
	
	public String getName() {
		return name;
	}

}
