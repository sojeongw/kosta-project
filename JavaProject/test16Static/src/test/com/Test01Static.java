package test.com;

public class Test01Static {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("static...");
		// 프로그램이 시작해서 종료될 때까지 메모리의 클래스 영역에 주소를 할당받는다.
		// 속도가 빠르지만 많이 사용하면 메모리 오버플로우가 발생할 수 있다.
		// 특히 이미지 같은 것들은 오버플로우가 많이 발생한다.
		
		/* 
		 * new 하지 않고도 객체를 생성할 수 있는 게 있다.
		 * 인스턴스 영역에 있는 애들은 new 한 다음 .으로 접근하는데
		 * static은 static을 붙여줌으로써 그 영역에 접근할 수 있다.
		 * 프로그램이 시작하는 순간 정의가 쫙 정의가 된다.
		 * 
		 * Test01AAA a = new Test01AAA();는 a.name으로 접근
		 * 
		 */
		
		// 얘는 new에서 시작되어서 garbage collection이 작동하기 전까지 살아있다.
		// 혹은 null을 입력할 때까지 = 주소가 없어질 때까지 사용할 수 있다.
		Test01AAA a = new Test01AAA();
		System.out.println(a.name);
		a.name = "lee";
		System.out.println(a.name);
		
		// static 접근 방법
		System.out.println(Test01AAA.name2);
		// 무조건 클래스이름.멤버 : 같은 주소로 계속 사용된다.
		// 다른 어디서든 간에 클래스 이름만 알면 사용할 수 있다.
		// 프로그램이 시작해서 끝날 때까지 계속 사용할 수 있다.
		// 반면, 인스턴스는 new를 하기 때문에 같은 클래스를 사용해도 다른 객체, 주소를 가질 수 있다.
		// 싱글톤 : new 한 번만 하고 계속 하나의 주소, '완주소'만 갖는 것.
		// 즉, 끝날 때까지 객체를 더 이상 생성하지 않는 것. 이럴 때 static를 만들면 편하다는 것.
		// 싱글톤의 반대는 프로토타입
		
		
		System.out.println(Test01AAA.NAME3);
		
		Test01AAA.name2 = "kim";
		System.out.println(Test01AAA.name2);
		// Test01AAA.name3 = "han"; >>> 에러. 못 고친다는 걸 알리기 위해 대문자로 써주기.
		System.out.println(Test01AAA.NAME3);
		
		System.out.println();
		
		a.aaa();
		a.aaa3();
		Test01AAA.aaa2();	// static이라도 내 클래스가 아니면 점 찍어줘야 한다.

		
		
		
		
		

	}		// end of main

}		// end of class
