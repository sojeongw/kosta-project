package test.com;

public class Test01AAA {
	
	public String name;
	public static String name2;
	public static final String NAME3 = null;
	// ��ġ�� ����� ��. final�� ������ null�̵� �� ĭ�̵� ���� �Ҵ������.
	
	
	
	public void aaa() {
		System.out.println("aaa()");
	}
	public void aaa3() {
		System.out.println("aaa3()");
		
		// �Ʒ��� ���� Ŭ������ ������ ���� ��ü���� �� �ص� �� ����
		System.out.println("name");
		aaa();
	}
	public static void aaa2() {
		System.out.println("static aaa2()");
		// aaa(); �ϸ� ����. static���� static�ƴ� �� �ҷ������� new ����� �Ѵ�.
		Test01AAA a = new Test01AAA();
		a.aaa();
		xxx();
		// �׳� �� �� �� �ִ�. �ڱ� Ŭ���� �ȿ� �ִ� static�̴ϱ�.
		// Ŭ���� �̸�. �� �����Ǿ��ִٰ� �����ϸ� �ȴ�.
	}
	
	public static void xxx() {
		System.out.println("xxx()...");
	}
	
	
	
}	// end of class
