package test.com;

/* 
 * 1. member field : �Ӽ� ���� (���� ���� ��)
 * 2. constructor
 * 3. member method : ����(���) ���
 * 4. inner class
 * 5. �ʱ�ȭ ��
 */

public class Test01Class_object {
	// public : �� ������Ʈ ������, �� �ٸ� ���������� �� Ŭ������ �� �� �ֵ��� �����ϴ� ��
	
	
	int su = 0;		// member field variable = ���� ����, �ν��Ͻ� ����
	int su2 = 10;
	String name = null;
	String tel = "010";
	// ������ �پ��� ǥ��
	
	
	
	// �����ڴ� �ݵ�� �־�� �ϴµ�, �ƹ��͵� �� ����ִ� �����ڴ� ������ �����ϴ�.
	public Test01Class_object() {			
		// Ŭ�����̸�() �̷��� ����� �ָ� �ȴ�.
	}
	
	public static void main(String[] args) {
		
		System.out.println("class");
		
		/* 
		 * �����͸� �������� Ÿ���� ���ϰ� ������ �ִ´�.
		 * ������ Ÿ���� ���� �����͸� �� ������ �������� �迭�� ����Ѵ�.
		 * �������� ���� ���� Ÿ���� �� ������ ��������??? ��ü!
		 * �������� �ڵ��ϴ� ����� Ŭ����!
		 * Ŭ����(��ü)�� �Ӽ� ���� �� ����
		 */
		
		int su = 0;			// local variable = ���� ����
		
		// ctrl + �ش� ��ü�� ���� >> �������� �̵�. �����ڴ� �� Ŭ������ ����.
		Test01Class_object t01 = new Test01Class_object();
		/* t01�� ������Ʈ, ��ü��. 
		* �캯�� Test01Class_object()�� ��ü�� �����ϴ� �ֶ� ������. Ŭ���� �̸��� ����.
		* new ������ �ϸ� ��ü�� ���������.
		* 
		* Test01Class_object t01 = new Test01Class_object();
		* t01 = new Test01Class_object();
		* �̷��� �����ڸ� ���� �ȴ�.
		* new�� �� ������ ������ ���ο� �ּҷ� ����.
		* �׷��� ��� ���� �ּҰ� ���� �ٸ���.
		*/
		
		//��������� �ּҺ��� ����
		System.out.println(t01);		// �ּҰ� �������� ���� ���� ���� �� �ִ�.
		System.out.println(t01.su);
		System.out.println(t01.su2);
		System.out.println(t01.name);
		System.out.println(t01.tel);
		
		
		
		
		
	}	// end of main

}	// end of class
