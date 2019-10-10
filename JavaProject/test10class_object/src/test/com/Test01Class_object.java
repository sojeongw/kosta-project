package test.com;

/* 
 * 1. member field : 속성 정의 (전역 변수 등)
 * 2. constructor
 * 3. member method : 동작(기능) 담당
 * 4. inner class
 * 5. 초기화 블럭
 */

public class Test01Class_object {
	// public : 내 프로젝트 내에서, 즉 다른 폴더에서도 이 클래스를 쓸 수 있도록 정의하는 것
	
	
	int su = 0;		// member field variable = 전역 변수, 인스턴스 변수
	int su2 = 10;
	String name = null;
	String tel = "010";
	// 변수의 다양한 표현
	
	
	
	// 생성자는 반드시 있어야 하는데, 아무것도 안 들어있는 생성자는 생략이 가능하다.
	public Test01Class_object() {			
		// 클래스이름() 이렇게 만들어 주면 된다.
	}
	
	public static void main(String[] args) {
		
		System.out.println("class");
		
		/* 
		 * 데이터를 담으려면 타입을 정하고 변수를 넣는다.
		 * 동일한 타입의 여러 데이터를 한 변수에 넣으려면 배열을 사용한다.
		 * 동일하지 않은 여러 타입을 한 변수에 넣으려면??? 객체!
		 * 넣으려고 코딩하는 대상은 클래스!
		 * 클래스(객체)의 속성 정의 및 접근
		 */
		
		int su = 0;			// local variable = 지역 변수
		
		// ctrl + 해당 객체나 변수 >> 그쪽으로 이동. 생성자는 그 클래스로 간다.
		Test01Class_object t01 = new Test01Class_object();
		/* t01은 오브젝트, 객체명. 
		* 우변의 Test01Class_object()는 객체를 생성하는 애라서 생성자. 클래스 이름과 동일.
		* new 연산을 하면 객체가 만들어진다.
		* 
		* Test01Class_object t01 = new Test01Class_object();
		* t01 = new Test01Class_object();
		* 이렇게 생성자를 만들어도 된다.
		* new를 쓸 때마다 무조건 새로운 주소로 간다.
		* 그래서 얘네 둘은 주소가 서로 다르다.
		*/
		
		//만들었으니 주소부터 본다
		System.out.println(t01);		// 주소가 생겼으니 이제 점을 찍을 수 있다.
		System.out.println(t01.su);
		System.out.println(t01.su2);
		System.out.println(t01.name);
		System.out.println(t01.tel);
		
		
		
		
		
	}	// end of main

}	// end of class
