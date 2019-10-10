package test.com;

import test.com.Test01Member.Test01Inner;

public class Test01Main {

	/* 4대 구성 요소 */
	// 속성 : 멤버 필드, 전역 변수

	// 동작 : 메소드, 함수

	// 생성자 : constructor

	// 클래스
	// 여기에도 생성할 수 있다
	Test01Anonymous3 am3 = new Test01Anonymous3() {

		@Override
		public void ccc() {
			// TODO Auto-generated method stub
			System.out.println("ccc()...");
		}

	};

	public static void main(String[] args) {

		// System.out.println("inner class");

		/*
		 * 내부 클래스 : 클래스 내부에 클래스를 정의하면 내부 클래스 = 중첩 클래스. nested / inner class
		 * 
		 * 사용 목적 : 외부 클래스의 전역 변수들을 객체 생성 없이 접근하고자 할 때
		 * 
		 * inner class도 상속 사용 가능
		 */

		/*
		 * 1. member inner class 아무 생각없이 그냥 클래스 하나 더 만든 것. public class Test01Member{
		 * public class Test01Inner2{ } }
		 * 
		 * default나 public일 때 inner class를 어떻게 불러올 것이냐?
		 */

		Test01Member mOuter = new Test01Member();
		mOuter.testOuter();

		// 첫번째 방법
		Test01Member.Test01Inner mInner1 = new Test01Member().new Test01Inner();
		Test01Member.Test01Inner mInner2 = mOuter.new Test01Inner();

		mInner1.testInner();
		System.out.println(mInner1.userName);

		// 두번째 방법 : main에 import test.com.Test01Member.Test01inner; 하면
		// Test01Inner mIner2 = new Test01Inner(); 쓰는 것 가능

		// 2. static inner
		System.out.println(Test01Static.Test01Inner.userName);
		System.out.println(Test01Static.Test01Inner.userName);

		// static class에 접근할 때는 클래스 이름. 이지, 생성자.inner()가 아님!
		Test01Static.Test01Inner sInner1 = new Test01Static.Test01Inner();
		sInner1.testInner();

		// 3. local inner : 메소드 안에 클래스 생성
		// final 사용 주의

		// 4. 익명(무명) 내부 클래스 anonymous inner class

		String userName = "kim";
		Test01Anonymous am1 = new Test01Anonymous() {/* 이게 익명 inner class가 된다 */
			// 이 내부 클래스가 Test01Anonymouse를 상속받게 된 것
			// >> 상속을 받았으나 am1의 멤버를 사용할 수 없다.
			// sub로 객체를 생성했으니 다형성을 사용한 것 = super것만 써야된다.
			String name;

			// userName = "lee"; 로컬 변수에 접근은 할 수 있으나 final이라 수정 불가
			// 만약 로컬에 접근하는 게 아니라 여기서 정의된 거면 상관 없다
			public void xxx() {
				System.out.println("xxx() " + userName);
			} // end of xxx()

			// 일반 클래스는 오버라이드 해도 되고 안 해도 돼서 수동으로 추가
			@Override
			public void aaa() {
				// TODO Auto-generated method stub
				super.aaa();
			}

			// 이 안에서만 콜 해서 쓰려고 만든 것 뿐이다.
			
			/*
			 * 메소드를 호출할 때 익명 이너 클래스를 전달하게 되는데
			 * 그때 익명 이너클러스 안에 오버라이딩 된 메소드의 콜을
			 * 메소드를 콜한 쪽에서 하는 게 아니고
			 * 콜링된 쪽에서 콜 해주는 구조가 콜백 구조이다.
			 * 실제 로직을 중괄호 안에 쓰고 실제로 받는 메소드는 자기 로직에 따라 실행하며 실제로 콜된다
			 */
		};
		am1.aaa();

		Test01Anonymous2 am2 = new Test01Anonymous2() {
			public void move() {

			}
			
			// 얘는 abstract니까 override 필수
			@Override
			public void bbb() {
				// TODO Auto-generated method stub

			}
		}; //

		Test01Anonymous3 am3 = new Test01Anonymous3() {

			@Override
			public void ccc() {
				// TODO Auto-generated method stub
				System.out.println("ccc()...");
			}

		};
		am3.ccc();

		// 멤버 필드에 선언한건 main 객체를 만들어야 가능
		Test01Main main = new Test01Main();
		main.am3.ccc();
		
		// null이 주소값을 갖도록, null이 아니게 해주는 게 new

	} // end of main

} // end of class
