package test.com;

public class Test01Main {
	
	/* 1.field �Ӽ�, ���� : ����, ��� ���
	* 2.constructor
	* 3. method ����, ��� : ��Ī ���� ���, ���� �ҹ��ڷ� ����.
	* run(){}
	* void made(){}
	* 8�� �⺻ Ÿ�� + ����Ÿ���� ���� �� ��ȯ������ �� �� �ִ�.
	* ��ȯ���� ������ null�̵� ���� �ݵ�� ��� �Ѵ�.
	* void�� return ���� ����.
	*/
	
	int test;
	
	// 3-1	�Ű����� ���� ���� ����
	void aaa() {
		System.out.println("aaa�� �����ϰ� �ֽ��ϴ�.");
		return;
	}
	
	// 3-2	�Ű����� ���� ���� �ִ�
	int aaa2() {
		int x = 10;
		return x;	// int�� �⺻�� 0 ����. ���� call �ϸ� int ���� 0�� �ٰ�.
	}
	
	// 3-3	�Ű����� �ְ� ���� ����
	void aaa3(int x) {
		System.out.println("aaa3(int x) " + x);
		return;
	}
	
	// 3-4	/�Ű����� �ְ� ���� �ִ�
	int[] aaa4(String name) {
		System.out.println("aaa4(String name) " + name);
		int[] sus = new int[3];
		sus[0] = 99;
		sus[1] = 88;
		sus[2] = 77;
		return sus;	// �迭�� �⺻�� ����
	}
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("main method");
		
		/* method call
		 * made();
		 * made(10,"kim");
		 */
		
		Test01Main tm = new Test01Main();
		System.out.println(tm.test);
		
		tm.aaa();
		int a2 = tm.aaa2();		// byte a2 = �̶�� �ϸ� �۾Ƽ� ����
		System.out.println(a2);
		tm.aaa3(99);
		int[] a4 = tm.aaa4("�ռ���");
		System.out.println(a4.length);
		for(int i=0; i<a4.length; i++) {
			System.out.println(a4[i]);
		}

	}

}
