package test.com;

// import java.lang.*; 이 생략되어 있는 것. 여기엔 StringBuilder, StringBuffer, Boolean...etc

public class Test01Extends { // extends Object{가 생략되어 있음

	public Test01Extends() {
		// 메인에서 객체 생성을 하고 나서야 불러와짐
		// Object obj = new Object(); 가 생각 되고 바로 getClass() 사용

		getClass();
		System.out.println(/* obj. */getClass());
	}

	public static void main(String[] args) {
		// private과 protected는 보통 멤버필드와 클래스에 붙는다.
		// 제한자 : modifier. public이라고 적은게 제일 제한이 없다. 아예 없다고 제한이 없는게 아님.
		// abstract
		// final
		// 부모님은 superclass, 지인은 interface
		// 자바의 단군, 최종 조상이 java.lang.Object

		System.out.println("extends...");
		System.out.println();
		// 4대 자원 : 멤버 필드, 생성자, 메소드, 클래스
		// static에서 non-static인 걸 불러올 때 객체 생성 해줘야 한다.
		// 상속을 안 하면 그 객체를 생성해서 불러와야 한다.

		// 메인은 static인데 멤버필드의 생성자는 아니므로 객체 생성 후 불러옴
		Test01Extends ex = new Test01Extends();
		System.out.println();

		// 같은 지갑이라도 내꺼는 this. 아빠꺼는 super.
		// 상속을 하면 super class에 있는 자원이 다 내꺼가 된다.
		// 속성을 적지 않는 것 자체가 개이득!
		// 그냥 참조하고 싶으면 객체 생성해서 . 찍어 사용한다.
		// 상속 제한자 : final을 붙이면 내가 최종이기 때문에 상속할 수 없다.
		// final 되어 있으면 그냥 new 만들어서 쓰면 됨. 상속은 new를 안해도 된다는 게 장점일 뿐.
		// 남이 만들어 놓은 소스가 final이 되어있어도 method 자체가 내 꺼였으면 좋겠으면 복사하면 됨.

		// me가 상속받은 father 생성자까지 실행
		Test01Me me = new Test01Me();
		System.out.println();
		// 내가 상속받은 클래스의 자원도 사용 가능. 물론 father 객체 생성해서 써도 됨.
		// 단, super class가 final일 경우는 불가하다.
		System.out.println(me.lastName);
		System.out.println();
		
		// 상속받은 클래스의 생성자까지 실행
		Test01Child child = new Test01Child();
		System.out.println(child.lastName);
		
		System.out.println();
		
		
		// 상속이 전제된 다형성을 이용한 객체 생성
		// 따라서 상속에는 자연스럽게 다형성이 딸려온다.
		// 수퍼 클래스 객체를 만들어 낼 때 서브의 생성자로 만들 수 있다.
		Test01Father father = new Test01Me();
		// father도 call 되고 me도 call 됨 >> 두 개가 상속 관계라는 의미
		// = 상속일 경우 부모가 자식 클래스로 객체를 생성할 수 있다.
		// super가 자식껄 쓸 수 없다. 자기 것만 사용해야 한다.
		
		// 객체는 생성할 수 있으나 쓸 수 있는 건 상속한 father와 me 것만 사용 가능하다.
		Test01Me me2 = new Test01Child();
		
		
		// 손자도 객체 생성 가능. 하지만 여전히 자기 것만 사용 가능.
		Test01Father father2 = new Test01Child();
		System.out.println(father2.lastName);
		
		// >> 타입은 자기 자신이므로 아무리 자식 것으로 만들어도 자기 것만 쓸 수 있다.
		// 서브는 super의 타입이라고 할 수 있다. 객체 생성 상관 없이 상속만 하면.
		// ex. child는 father, me 타입 / me는 father 타입 / child, me, father는 object 타입
		
		
		

	} // end of main

} // end of class
