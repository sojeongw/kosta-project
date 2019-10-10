package test.com;

public class Test01Member {

	String name = "kim";
	
	public void testOuter() {
		
		// System.out.println(userName);
		// �ٸ� ���� �־ �� ���� ���� >> ������ ������ ��ü ����
		
		Test01Inner inner = new Test01Inner();
		System.out.println("Outer Class : " + inner.userName);
	}

	// 1. member inner class
	
	// private : ���� �ҼӵǾ� �ִ� Ŭ����(Test01Member) �ȿ����� ���� ��
	class Test01Inner {		
		/*
		 * String name = "kim"; �� ���൵ outer�� �ִ� �� �� �� �ִ�.
		 * ����̳� new�� �ϴ� �� ���� �� �̷��� �����
		 * outer class���� ���� �͵� ���� �� �� �ִ�.
		 */

		// ������ ������ �����ؼ� outer�� �ִ� �� ������ �� �ִ�.
		String userName;

		public Test01Inner() {
			System.out.println("Inner Class : " + name);
			userName = name;

			/*
			 * ���� name, name���� �̸��� ���ٸ�
			 * �� Ŭ���� �ȿ� �ִ� �� this�ϱ�
			 * this.name = name;
			 */
		}
		
		public void testInner() {
			System.out.println("testInner() : " + name);
		}

		
		public void testInner2() {
			System.out.println("testInner2() : " + name);
		}
	}

}
