package test.com;

public class Test01Static {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("static...");
		// ���α׷��� �����ؼ� ����� ������ �޸��� Ŭ���� ������ �ּҸ� �Ҵ�޴´�.
		// �ӵ��� �������� ���� ����ϸ� �޸� �����÷ο찡 �߻��� �� �ִ�.
		// Ư�� �̹��� ���� �͵��� �����÷ο찡 ���� �߻��Ѵ�.
		
		/* 
		 * new ���� �ʰ� ��ü�� ������ �� �ִ� �� �ִ�.
		 * �ν��Ͻ� ������ �ִ� �ֵ��� new �� ���� .���� �����ϴµ�
		 * static�� static�� �ٿ������ν� �� ������ ������ �� �ִ�.
		 * ���α׷��� �����ϴ� ���� ���ǰ� �� ���ǰ� �ȴ�.
		 * 
		 * Test01AAA a = new Test01AAA();�� a.name���� ����
		 * 
		 */
		
		// ��� new���� ���۵Ǿ garbage collection�� �۵��ϱ� ������ ����ִ�.
		// Ȥ�� null�� �Է��� ������ = �ּҰ� ������ ������ ����� �� �ִ�.
		Test01AAA a = new Test01AAA();
		System.out.println(a.name);
		a.name = "lee";
		System.out.println(a.name);
		
		// static ���� ���
		System.out.println(Test01AAA.name2);
		// ������ Ŭ�����̸�.��� : ���� �ּҷ� ��� ���ȴ�.
		// �ٸ� ��𼭵� ���� Ŭ���� �̸��� �˸� ����� �� �ִ�.
		// ���α׷��� �����ؼ� ���� ������ ��� ����� �� �ִ�.
		// �ݸ�, �ν��Ͻ��� new�� �ϱ� ������ ���� Ŭ������ ����ص� �ٸ� ��ü, �ּҸ� ���� �� �ִ�.
		// �̱��� : new �� ���� �ϰ� ��� �ϳ��� �ּ�, '���ּ�'�� ���� ��.
		// ��, ���� ������ ��ü�� �� �̻� �������� �ʴ� ��. �̷� �� static�� ����� ���ϴٴ� ��.
		// �̱����� �ݴ�� ������Ÿ��
		
		
		System.out.println(Test01AAA.NAME3);
		
		Test01AAA.name2 = "kim";
		System.out.println(Test01AAA.name2);
		// Test01AAA.name3 = "han"; >>> ����. �� ��ģ�ٴ� �� �˸��� ���� �빮�ڷ� ���ֱ�.
		System.out.println(Test01AAA.NAME3);
		
		System.out.println();
		
		a.aaa();
		a.aaa3();
		Test01AAA.aaa2();	// static�̶� �� Ŭ������ �ƴϸ� �� ������ �Ѵ�.

		
		
		
		
		

	}		// end of main

}		// end of class
