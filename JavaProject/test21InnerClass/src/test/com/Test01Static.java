package test.com;

public class Test01Static {
	
	String name;
	
	public static class Test01Inner{
		/* 
		 * inner���� static�� ����ϸ� final�� �� �� �ִ�.
		 * static�ε� final�� ����� final�̰ų� static�� ����ų�
		 * ���ΰ� �ִ� class�� static�� �Ǿ�� �Ѵ�.
		 * ���� inner class�� static�� �Ǹ� static inner class�� �ȴ�.
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
