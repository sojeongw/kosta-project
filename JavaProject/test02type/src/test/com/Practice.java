package test.com;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 8대 기본형 타입
		 * 1) 정수형
		 * 		byte(1), short(2), character(2), integer(4), long(8)
		 * 		character는 0과 양의 정수만 받는다.
		 * 		기본은 integer이고 integer의 기본값은 0이다.
		 * 		long은 숫자 끝에 L을 붙여 표현한다.
		 * 		byte는 -128~127까지의 범위를 갖는다.
		 * 2) 실수형
		 * 		float(4), double(8)
		 * 		기본은 double이고 기본값은 0.0이다. 모든 타입에서 제일 큰 타입이다.
		 * 		float은 숫자 뒤에 f를 붙여 표현한다. 그냥 숫자 쓰면 double이다.
		 * 3) 문자형
		 * 		character(2)
		 * 4) 참 또는 거짓
		 * 		boolean(1) : true나 false만 나타낸다. 유일하게 0을 표현할 수 없다.
		 */
		
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Character.MIN_VALUE);
		System.out.println(Character.MAX_VALUE);
		System.out.println((double)Character.MIN_VALUE);
		System.out.println((double)Character.MAX_VALUE);
		System.out.println(Boolean.TRUE);
		System.out.println(Boolean.FALSE);
		
		float f = 10.5f;
		//float ff = 3.14; 		타입 불일치로 에러.
		f = (float)3.14;
		
		long l = 25L;
		long ll = 25;
		long lll = 25l;			//소문자로도 되네. 구분 때문에 대문자 쓰는듯.
		
		//int x = 25L;			타입 불일치로 에러.
		int x = 25;
		x = (int)30L;			// 타입 다운 캐스팅
		
		// byte b = 128;		오버플로우로 에러.
		byte b = (byte)128;		// 뒤로 넘어가서 -128부터 시작
		System.out.println(b);
		b = (byte)129;
		System.out.println(b);	// -127
		
		//boolean bl = 0;		숫자로 표현할 수 없다.
		boolean bl = true;
		boolean bbll = false;
		System.out.println(bl);
		System.out.println(bbll);
		
		
		/* 참조형 변수
		 * String, Array 등 대문자로 시작하는 것 + 객체
		 */
		
		String s = "스트링";
		
		/* 변수와 상수
		 * 		1) 변수 : 항상 값이 변한다. 소문자로 시작하고 연결자는 대문자
		 * 		2) 상수 : 항상 값이 같다. 대문자로 이뤄지고 연결자는 언더바로 잇는다.
		 * 				  final로 선언한다.
		 */
		
		int i = 10;
		final int ii = 100;
		
		
		/* 연산자의 종류
		 * 	1) 산술연산자 : +, -, *, /, %
		 * 	2) 대입연산자 : =, +=, -=, *=, /=, %=, &=, |=, ^=
		 * 	3) 논리연산자 : &, |, &&, || true나 false를 대상으로 한다.
		 *  4) 비교연산자 : ==, >, <, !=, <=, >=
		 *  5) 비트연산자 : &, |, ^,
		 *  				XOR는 서로 비트가 다를 때(1이 하나만 있을 때) 1이다.
		 *  6) 증감연산자 : ++, --
		 *  7) 쉬프트연산자 : >>, <<, >>>, <<<
		 *  				  뒤의 숫자만큼 0을 추가해 밀어낸다.
		 *  				  >>>, <<<은 무조건 양수로 나타낼 때 사용한다.
		 *  8) 3항연산자 : 조건식 ? true일때 실행이나 값 : false일때 실행이나 값
		 *  			   독립적으로 있을 수 없고 반드시 어딘가에 대입이 되어야 한다.
		 */
		
		System.out.println();
		System.out.println(true && false);
		System.out.println(8>>2); // 1000이니까 0010 = 2
		System.out.println(-8>>>2);
		System.out.println(5 == 5);
		System.out.println(5 > 6 && false);
		String str = 5 > 6 ? "true" : "false";
		System.out.println(str);
		// 5 > 6 ? "true" : "false"; 에러
		
		
		
		
	}

}
