package test.com;

public /*final*/ class Test01Me extends Test01Father{
	// final 하면 child가 me 상속할 때 에러난다.
	
	String name;
	int age;
	
	public Test01Me(){
		// super(); 가 생략이 되어져 있기 때문에 Test01Father father = new Test01Me();이 가능.
		// this(); 는 자기가 자기를 call할 일이 없으므로 에러.
		System.out.println("Test01Me...");
		// father꺼인데도 바로 쓸 수 있다.
		// System.out.println(getLastName());
	}
	
	public String getName() {
		return name;
	}

}
