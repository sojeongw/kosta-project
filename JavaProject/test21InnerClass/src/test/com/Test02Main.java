package test.com;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test02Main {

	private static final class Test01Anonymous2Extension extends Test01Anonymous2 {
		@Override
		public void bbb() {
			System.out.println("inner addlistener bb()");
		}
	}

	public static void main(String[] args) {

		System.out.println("inner class...2");

		/*
		 * Object obj = new Object();
		 * Test02 t2 = new Test02(new Object());
		 * BufferedReader br = new BufferedReader(new InputStreamReader(null));
		 */

		// anonymous의 aaa() 로직이 마음에 안 들어서 수정하고 싶다면 상속받는 애를 만들면 된다.
		// >>> class Test02AnonymousEx
		Test02 t2 = new Test02(new Test02AnonymousEx());
		Test02 t3 = new Test02(new Test01Anonymous() {
			@Override
			public void aaa() {
				System.out.println("inner aaa()");
			}
			
		});
		
		Test02 t4 = new Test02();	// 인자가 있는데 없게 하면 에러
		
		// 얘도 객체니까 메소드에 넣을 수 있다
		t4.addListener(new Test01Anonymous()/*abstract라 interface 같이 일반 클래스가 아니어도 가능 >> 그냥 놔두면 오버라이드 안 해서 에러나니까*/
			{
			@Override
			public void aaa() {
				System.out.println("inner addlistener aaa()");
			}
			
		});
		// t4에서 이너 클래스를 콜할 일은 없고 addlistener 메소드가 이용할 것이다
		// 내가 정의한 메소드를 직접 콜하는 게 아니고 이너클래스를 만든 객체를 메소드에 던져서
		// 콜은 다른 애한테 넘기는 게 콜백 구조. 이때 익명 이너 클래스가 많이 쓰인다.
		
		t4.addListener(new Test01Anonymous2(){
				@Override
				public void bbb() {
					System.out.println("inner addlistener bbb()");
				}
				
			});

	} // end of main

} // end of class
