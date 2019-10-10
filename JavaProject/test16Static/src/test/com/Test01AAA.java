package test.com;

public class Test01AAA {
	
	public String name;
	public static String name2;
	public static final String NAME3 = null;
	// 고치지 마라는 뜻. final은 무조건 null이든 빈 칸이든 값을 할당해줘야.
	
	
	
	public void aaa() {
		System.out.println("aaa()");
	}
	public void aaa3() {
		System.out.println("aaa3()");
		
		// 아래는 같은 클래스에 있으니 굳이 객체생성 안 해도 콜 가능
		System.out.println("name");
		aaa();
	}
	public static void aaa2() {
		System.out.println("static aaa2()");
		// aaa(); 하면 에러. static에서 static아닌 거 불러오려면 new 해줘야 한다.
		Test01AAA a = new Test01AAA();
		a.aaa();
		xxx();
		// 그냥 콜 할 수 있다. 자기 클래스 안에 있는 static이니까.
		// 클래스 이름. 이 생략되어있다고 생각하면 된다.
	}
	
	public static void xxx() {
		System.out.println("xxx()...");
	}
	
	
	
}	// end of class
