package test.com;

public class Test01Static {
	
	String name;
	
	public static class Test01Inner{
		/* 
		 * inner에서 static을 사용하면 final을 쓸 수 있다.
		 * static인데 final을 지우면 final이거나 static을 지우거나
		 * 감싸고 있는 class가 static이 되어야 한다.
		 * 만약 inner class가 static이 되면 static inner class가 된다.
		 */
		static String userName = "lee";
		
		public Test01Inner() {
			System.out.println("Test01Inner()");
		}
		
		public void testInner() {
			System.out.println("static testInner()");
		}
		
	}		// end of Test01Inner

}	// end of Test01Static
