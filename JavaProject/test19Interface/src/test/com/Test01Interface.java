package test.com;

public class Test01Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("interface...");
		
		// Ŭ���� ���� ����� ���� ����� �������� �ʴ´�.
		// ���� ����� �����ϴ� ����� �ʿ��ؼ� ����� �� �� �������̽�
		// Ŭ������ �������̽��� ��� ���� �� implements �����ϰ� ����Ѵ�.
		
		System.out.println(Test01Uncle.NAME);
		
		// �Ϲ����� ��ü ���� ���
		Test01Me me = new Test01Me();
		me.getMoney();
		me.talk();
		
		// Uncle ��ü ����
		Test01Uncle uncle = new Test01Uncle() {
			
			@Override
			public void play() {	// play�� �������̵�
				
			}
		};
		
		// �̷��� �ϸ� uncle���� ���鼭 ��ü ���� ����
		Test01Uncle uncle2 = new Test01Me();
		
		
		// friend�� ��������
		Test01Friend friend = new Test01Friend() {
			
			// �� ���� Test01Friend�� ��ӹ��� ��ó�� ó��
			// {} ���� ����� ���ÿ� ���� ��ü�� ��ӹ��� �� �ȴ�.
			@Override
			public int getMoney() {		
				return 0;
			}
		};
		// �ڽ��� �����ڷ� ���� = �������̽��� �����ڸ� ���� �� �Ѵ�.
		// ���� �ִ� ���� ¦�� ������.
		Test01Friend friend2 = new Test01Me();
		
		
		
		
		
		
		

	}	// end of main

}
