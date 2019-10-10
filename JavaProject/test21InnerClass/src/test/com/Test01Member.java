package test.com;

public class Test01Member {

	String name = "kim";
	
	public void testOuter() {
		
		// System.out.println(userName);
		// 다른 곳에 있어서 쓸 수가 없다 >> 없으면 무조건 객체 생성
		
		Test01Inner inner = new Test01Inner();
		System.out.println("Outer Class : " + inner.userName);
	}

	// 1. member inner class
	
	// private : 내가 소속되어 있는 클래스(Test01Member) 안에서는 갖다 써
	class Test01Inner {		
		/*
		 * String name = "kim"; 안 써줘도 outer에 있는 걸 쓸 수 있다.
		 * 상속이나 new를 하는 게 싫을 때 이렇게 만들면
		 * outer class에서 쓰는 것도 내가 쓸 수 있다.
		 */

		// 나만의 변수를 정의해서 outer에 있는 걸 대입할 수 있다.
		String userName;

		public Test01Inner() {
			System.out.println("Inner Class : " + name);
			userName = name;

			/*
			 * 만약 name, name으로 이름이 같다면
			 * 내 클래스 안에 있는 건 this니까
			 * this.name = name;
			 */
		}
		
		public void testInner() {
			System.out.println("testInner() : " + name);
		}

		
		public void testInner2() {
			System.out.println("testInner2() : " + name);
		}
	}

}
