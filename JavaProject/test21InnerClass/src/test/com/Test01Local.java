package test.com;

public class Test01Local {
	// 이 클래스가 만들어져야지만 
	
	String name = "kim";
	
	public void testOuter() {
		// 여기서 객체를 생성할 수 있다.
		// Test01Inner inner = new Test01Inner();	에러
		
		String userName = "han";
		
		class Test01Inner{
			// outer보다 범위가 좁아야 해서 접근 지정자 public 불가
			public Test01Inner() {
				
			}	// end of Test01Inner()
			
			public void testInner(){
				// outer 클래스에 있는 전역변수를 inner에서 마음대로 쓸 수 있다
				System.out.println(name);
				
				// 메소드 안에 있는 변수도 접근 가능
				// 1.7 버전까지는 userName이 final로 선언되어 있어야 쓸 수 있다.
				System.out.println(userName);
				
				// userName = "kkk"; 수정을 시도하지 않으면 final 선언 생략 가능하다.
				
			}	// end of testInner()
			
			Test01Inner inner = new Test01Inner();	// 내부에서만 쓰니까 에러 안 남
			
			// inner class에서 local inner class를 사용할 때 local변수의 final을 생략해도 쓸 수 있는게 1.7과 1.8의 차이
		
		}	// end of class Test01Inner
		
	}	// end of testOuter()

}	// end of Local
