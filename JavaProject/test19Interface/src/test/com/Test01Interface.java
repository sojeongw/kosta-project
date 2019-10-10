package test.com;

public class Test01Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("interface...");
		
		// 클래스 간의 상속은 다중 상속을 지원하지 않는다.
		// 다중 상속을 지원하는 대상이 필요해서 만들게 된 게 인터페이스
		// 클래스가 인터페이스를 상속 받을 때 implements 선언하고 명시한다.
		
		System.out.println(Test01Uncle.NAME);
		
		// 일반적인 객체 생성 방법
		Test01Me me = new Test01Me();
		me.getMoney();
		me.talk();
		
		// Uncle 객체 생성
		Test01Uncle uncle = new Test01Uncle() {
			
			@Override
			public void play() {	// play를 오버라이딩
				
			}
		};
		
		// 이렇게 하면 uncle꺼만 쓰면서 객체 생성 가능
		Test01Uncle uncle2 = new Test01Me();
		
		
		// friend도 마찬가지
		Test01Friend friend = new Test01Friend() {
			
			// 이 블럭은 Test01Friend를 상속받은 것처럼 처리
			// {} 블럭이 생김과 동시에 앞의 객체를 상속받은 게 된다.
			@Override
			public int getMoney() {		
				return 0;
			}
		};
		// 자식의 생성자로 생성 = 인터페이스는 생성자를 갖지 못 한다.
		// 위에 있는 블럭은 짝퉁 생성자.
		Test01Friend friend2 = new Test01Me();
		
		
		
		
		
		
		

	}	// end of main

}
