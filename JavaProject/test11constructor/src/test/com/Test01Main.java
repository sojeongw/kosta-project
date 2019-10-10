package test.com;

public class Test01Main {
	
	int num;
	String name;
	int kor;
	int eng;
	int math;
	
	public Test01Main() {
		// 오버로딩
		// 매개변수의 개수/ 순서/ 타입이 다르면 같은 이름의 생성자를 사용할 수 있다.
	}
	
	public Test01Main(int a, String x) {		// 생성자는 순서는 상관없고 call을 하는 게 중요.
		// 인자의 순서가 바뀌면 안 된다.
		System.out.println("Test01Main");
		num = a;
		name = x;
	}		// Test01Main
	
	public Test01Main(int a, int b, int c){
		kor = a;
		eng = b;
		math = c;
		
	}
	
	public Test01Main(int a, int b){
		eng = a;
		math = b;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("constructor");
		
		Test01Main tm = new Test01Main();		// new 하는 애의 기본값은 null
		System.out.println(tm.num);				// 기본값이 0이니까 0이 출력됨
		System.out.println(tm.name);			// 기본값이 null이니까 null이 출력됨
		
		tm = new Test01Main(99, "kim");		// new 하는 애의 기본값은 null
		System.out.println(tm.num);				// 기본값이 0이니까 0이 출력됨
		System.out.println(tm.name);			// 기본값이 null이니까 null이 출력됨
		
		tm = new Test01Main(99, 88, 77);
		System.out.println(tm.kor);
		System.out.println(tm.eng);
		System.out.println(tm.math);
		
		tm = new Test01Main(111, 222);
		System.out.println(tm.eng);
		System.out.println(tm.math);

	}	// end of main

}
