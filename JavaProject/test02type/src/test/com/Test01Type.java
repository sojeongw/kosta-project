package test.com;

public class Test01Type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 1. 기본 타입 : 정수, 실수, 문자형, 참/거짓
		 * 	1) 정수
		 * 		기본값 : 0
		 * 		byte(1), short(2), char(2), int(4), long(8)
		 * 		기본은 int
		 * 		char는 0과 양의 정수만 받는다.
		 * 		byte : -128~127
		 * 				System.out.println(Byte.MIN_VALUE); 하면 값을 구해준다.
		 * 	2) 실수
		 * 		기본값 : 0.0
		 * 		float(4), double(8)
		 * 		기본은 double
		 * 		float은 f를 붙여서 표현한다. 그냥 3.14하면 double이다.
		 * 		제일 큰 것은 long과 double이 아니라 double이다. 더 정교한 숫자니까.
		 * 	3) 문자형
		 * 	4) 참/거짓
		 *		Boolean : true와 false만 표현한다.
		 *		자바는 1, 0으로 대체할 수 없다. 유일하게 0을 표현할 수 없는 유형.
		 *		false가 기본값
		 *
		 * 	>>> 8대 기본 타입.
		 * 
		 * 	다운 캐스팅은 명시해야하지만 업 캐스팅은 자동으로 된다.
		 */
		
		System.out.println(Byte.MIN_VALUE); 
		System.out.println(Byte.MIN_VALUE);
		System.out.println();
		System.out.println(Short.MIN_VALUE); 
		System.out.println(Short.MAX_VALUE);
		System.out.println();
		System.out.println(Character.MIN_VALUE);
		System.out.println(Character.MAX_VALUE);
		System.out.println();
		System.out.println((int)Character.MIN_VALUE);
		System.out.println((int)Character.MAX_VALUE);
		System.out.println();
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println();
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println();
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		System.out.println();
		System.out.println(Boolean.TRUE);
		System.out.println(Boolean.FALSE);
		System.out.println();
		
		long z = 10L;
		System.out.println(z);
		// int x = 2200000000L; 하면 에러
		int x = (int)2200000000L;		// L을 int로 바꿔서 다운 캐스팅
		System.out.println(x);
		// byte b = 128; 에러
		byte b = (byte)128;		// int에 속하는 숫자를 byte로 바꿔 다운 캐스팅
		System.out.println(b);		// -128
		b = (byte)129;		
		System.out.println(b);		//-127
		int c = (int)'a';
		System.out.println(c);
		float f = 3.14f;			// float의 표현
		float ff = (float)3.14;		// float의 타입 캐스팅
		System.out.println(f);
		// boolean bl = 0; 에러
		boolean bl = true;
		
				
		/* 2. 참조 타입 : 대문자로 시작하는 것
		 * 	1) String
		 * 	2) Array
		 * 	3) 객체
		 */
		
		/* 3. 변수와 상수
		 *	1) 변수 : 소문자로 시작하는 걸 권장한다. 연결자는 대문자로.
		 *	2) 상수 : 대문자로 쓴다. 연결자는 언더바로 이어준다.
		 *			  final을 선언부 앞에 붙이면 상수로 선언된다.
		 *			  ex) final int X = 10;
		 */
		
	
		
	}

}
