package test.com;

public class Test01Local {
	// �� Ŭ������ ������������� 
	
	String name = "kim";
	
	public void testOuter() {
		// ���⼭ ��ü�� ������ �� �ִ�.
		// Test01Inner inner = new Test01Inner();	����
		
		String userName = "han";
		
		class Test01Inner{
			// outer���� ������ ���ƾ� �ؼ� ���� ������ public �Ұ�
			public Test01Inner() {
				
			}	// end of Test01Inner()
			
			public void testInner(){
				// outer Ŭ������ �ִ� ���������� inner���� ������� �� �� �ִ�
				System.out.println(name);
				
				// �޼ҵ� �ȿ� �ִ� ������ ���� ����
				// 1.7 ���������� userName�� final�� ����Ǿ� �־�� �� �� �ִ�.
				System.out.println(userName);
				
				// userName = "kkk"; ������ �õ����� ������ final ���� ���� �����ϴ�.
				
			}	// end of testInner()
			
			Test01Inner inner = new Test01Inner();	// ���ο����� ���ϱ� ���� �� ��
			
			// inner class���� local inner class�� ����� �� local������ final�� �����ص� �� �� �ִ°� 1.7�� 1.8�� ����
		
		}	// end of class Test01Inner
		
	}	// end of testOuter()

}	// end of Local
