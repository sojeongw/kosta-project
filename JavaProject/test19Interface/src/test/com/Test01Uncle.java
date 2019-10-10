package test.com;

public interface Test01Uncle {
	
	/* 1. interface에 있는 모든 전역 변수는 static final
	>>공통으로 접근 가능하지만 수정 불가 = 공통 상수
	
	String name;	기본값 그대로 두지 말고 초기화를 해둬야 해서 에러
	
	static final이 생성되어 있음 >> 객체 생성 하지 않는다.*/
	
	String NAME = "song";
	/*static String NAME = "song";
	static final String NAME = "song";
	>> 다 같은 말*/
	
	
	/* 2. 추상 메소드를 가질 수 있다.
	 * abstract는 생략 가능하다.
	 * 블럭 없이 세미콜론으로 끝나는 것
	 */
	public /*abstract*/ void play();

	
	/*
	 * 3. 추상 메소드가 아니면 default 또는 static 선언 필수
	 */
	public default void talk() {
		
	}
	
	public static void talk2() {
		
	}
	
	
	// 인터페이스로 추상 메소드를 만들어 놓으면 오버라이딩을 강제한다.
	
	/*
	 * 4. 인터페이스는 생성자가 없다.
	 */
	
	
	
}	// end of interface
