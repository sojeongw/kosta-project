package test.com;

public interface Test01Uncle {
	
	/* 1. interface�� �ִ� ��� ���� ������ static final
	>>�������� ���� ���������� ���� �Ұ� = ���� ���
	
	String name;	�⺻�� �״�� ���� ���� �ʱ�ȭ�� �ص־� �ؼ� ����
	
	static final�� �����Ǿ� ���� >> ��ü ���� ���� �ʴ´�.*/
	
	String NAME = "song";
	/*static String NAME = "song";
	static final String NAME = "song";
	>> �� ���� ��*/
	
	
	/* 2. �߻� �޼ҵ带 ���� �� �ִ�.
	 * abstract�� ���� �����ϴ�.
	 * �� ���� �����ݷ����� ������ ��
	 */
	public /*abstract*/ void play();

	
	/*
	 * 3. �߻� �޼ҵ尡 �ƴϸ� default �Ǵ� static ���� �ʼ�
	 */
	public default void talk() {
		
	}
	
	public static void talk2() {
		
	}
	
	
	// �������̽��� �߻� �޼ҵ带 ����� ������ �������̵��� �����Ѵ�.
	
	/*
	 * 4. �������̽��� �����ڰ� ����.
	 */
	
	
	
}	// end of interface
