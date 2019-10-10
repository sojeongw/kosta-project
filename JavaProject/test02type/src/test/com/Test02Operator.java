package test.com;

public class Test02Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*	1. 연산자의 종류 : 산술, 비교, 논리, 비트, 대입, 증감, 쉬프트, 3항 etc
		 *		1) 산술 : +, -, *, /, %
		 *		2) 대입 : =, +=, -+, *=, %=, &=, |&, ^=
		 *				  ex) int x = 10 + 5; 	a += 10;
		 *				  오른쪽부터 계산하고 왼쪽으로 간다.
		 *				  타입만 맞으면 다 되는데 안 맞을 때 에러가 나는 것.
		 *		3) 비트 : AND(&), OR(|), XOR(^) : 짝이 안 맞아야 true
		 *		4) 논리 : &&, ||, &, |
		 *				  대상이 true 또는 false
		 *		5) 비교 : ==, !=, >, <, <=, >=
		 *				  문자는 비교할 때 ==을 사용하지 않는다.
		 *				  ex) menu == "1"; 에러날 가능성이 있어서 사용하지 않음.
		 *					  menu.equal("1"); 로 대체할 수 있다.
		 *		6) 증감 : ++, --
		 *		7) 쉬프트 : >>, <<, >>> 해당 방향으로 이동
		 *					ex) (8 >> 2); 우측으로 2칸씩 이동
		 *					1000을 2칸씩 이동해서 0010 = 2
		 *					>>>은 값이 음수더라도 양수로 나타낼 때
		 *		8) 3항 연산자 조건(논리연산 결과, 비교 연산 결과)에 따른 실행 분기 처리 가능
		 *			조건식 ? 참일 때 실행 또는 결과값 : 거짓일 때 실행 또는 결과값
		 *
		 *	2. 연산자의 우선순위
		 *		단항 : ++, --, +, -, ~, !
		 *		산술 : *, /, %
		 *			   +, -
		 *			   <<, >>
		 *		비교 : <, >, <=, >=, instanceof
		 *			   ==, !=
		 *		논리 : &
		 *			   ^
		 *			   |
		 *			   &&
		 *			   ||
		 *		삼항 : ? :
		 *		대입 : =, +=, -+, *=, %=, &=, |&, ^=, <<=, >>= 
		 */
		
		System.out.println(9&5);
		System.out.println(9|5);
		System.out.println(9^5);
		System.out.println();
		
		int a = 9;
		a &= 5;
		System.out.println(a);		
		System.out.println();
		
		System.out.println(true & true);
		System.out.println(false & true);
		System.out.println(false & false);		// 꼭 뒤도 확인해서 계산 
		System.out.println();
		
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && false);		// 굳이 뒤까지 볼 필요도 없이 답을 낼 수 있음
		System.out.println();
		
		System.out.println(true | true);		// 꼭 뒤도 확인해서 계산
		System.out.println(false | true);
		System.out.println(false | false);		 
		System.out.println();
		
		System.out.println(true || true);		// 굳이 뒤까지 볼 필요도 없이 답을 낼 수 있음
		System.out.println(false || true);
		System.out.println(false || false);		
		System.out.println();
		
		// System.out.println(8 & 8); true나 false가 아니므로 error
		
		System.out.println(5 == 5);				// 결과 값은 반드시 true나 false로 나온다.
												// 그래서 비교와 논리가 자주 같이 쓰인다.
		System.out.println(5 == 5 && true);
		System.out.println();
		// System.out.println(1 && true); error
		
		System.out.println(8 >> 2); 
		System.out.println(2 << 2);
		System.out.println(-8 >>> 2);	
		System.out.println();
		
		System.out.println(true ? 1 : 0);
		System.out.println(false ? 1 : 0);
		System.out.println(true && true ? 1 : 0);		// 논리 연산자 이용
		System.out.println(false || true ? 1 : 0);		// 논리 연산자 이용
		System.out.println();
		
		System.out.println(8>5 ? 1 : 0);				// 비교 연산자 이용
		System.out.println(8>5 ? "참" : "거짓");		// char 이용
		System.out.println();
		
		int result = true && true ? 1 : 0;
		System.out.println(result);						// 변수 이용
		String s = true && true ? "참" : "거짓";
		System.out.println(s);						// 변수 이용
		System.out.println();
		
		// true && true ? 1 : 0; 은 단독으로 쓸 수 없다. 반드시 어딘가에 대입돼야 한다.
		
		int q = 15;
		int w = 15;
		int e = q==w ? 100 : 50;
		System.out.println(e);
		
		int avg = 71;
		System.out.println(avg >= 80 ? 'B' : (avg >= 70 ? 'C' : 'D'));
		
		avg = 51;
		char c = avg >= 80 ? 'B' : (avg >= 70 ? 'C' : 'D');		//타입이 동일할 때
		System.out.println(c);
				
		double total = 99 + 88.8 + 74;
		double davg = total / 3;
		char cc = davg >= 80 ? 'B' : (davg >= 70 ? 'C' : 'D');
		System.out.println("avg : " + davg);
		System.out.println("grade : " + cc);
		System.out.println();
		
		
	}

}
