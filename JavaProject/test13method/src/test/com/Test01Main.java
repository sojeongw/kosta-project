package test.com;

public class Test01Main {
	
	/* 1.field 속성, 정의 : 대명사, 명사 사용
	* 2.constructor
	* 3. method 동작, 기능 : 명칭 동사 사용, 영문 소문자로 시작.
	* run(){}
	* void made(){}
	* 8개 기본 타입 + 참조타입이 전부 다 반환값으로 올 수 있다.
	* 반환값이 있으면 null이든 뭐든 반드시 줘야 한다.
	* void는 return 생략 가능.
	*/
	
	int test;
	
	// 3-1	매개변수 없고 리턴 없는
	void aaa() {
		System.out.println("aaa가 동작하고 있습니다.");
		return;
	}
	
	// 3-2	매개변수 없고 리턴 있는
	int aaa2() {
		int x = 10;
		return x;	// int의 기본값 0 리턴. 나를 call 하면 int 값인 0을 줄게.
	}
	
	// 3-3	매개변수 있고 리턴 없는
	void aaa3(int x) {
		System.out.println("aaa3(int x) " + x);
		return;
	}
	
	// 3-4	/매개변수 있고 리턴 있는
	int[] aaa4(String name) {
		System.out.println("aaa4(String name) " + name);
		int[] sus = new int[3];
		sus[0] = 99;
		sus[1] = 88;
		sus[2] = 77;
		return sus;	// 배열의 기본값 리턴
	}
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("main method");
		
		/* method call
		 * made();
		 * made(10,"kim");
		 */
		
		Test01Main tm = new Test01Main();
		System.out.println(tm.test);
		
		tm.aaa();
		int a2 = tm.aaa2();		// byte a2 = 이라고 하면 작아서 에러
		System.out.println(a2);
		tm.aaa3(99);
		int[] a4 = tm.aaa4("왕소정");
		System.out.println(a4.length);
		for(int i=0; i<a4.length; i++) {
			System.out.println(a4[i]);
		}

	}

}
