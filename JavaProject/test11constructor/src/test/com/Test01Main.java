package test.com;

public class Test01Main {
	
	int num;
	String name;
	int kor;
	int eng;
	int math;
	
	public Test01Main() {
		// �����ε�
		// �Ű������� ����/ ����/ Ÿ���� �ٸ��� ���� �̸��� �����ڸ� ����� �� �ִ�.
	}
	
	public Test01Main(int a, String x) {		// �����ڴ� ������ ������� call�� �ϴ� �� �߿�.
		// ������ ������ �ٲ�� �� �ȴ�.
		System.out.println("Test01Main");
		num = a;
		name = x;
	}		// Test01Main
	
	public Test01Main(int a, int b, int c){
		kor = a;
		eng = b;
		math = c;
		
	}
	
	public Test01Main(int a, int b){
		eng = a;
		math = b;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("constructor");
		
		Test01Main tm = new Test01Main();		// new �ϴ� ���� �⺻���� null
		System.out.println(tm.num);				// �⺻���� 0�̴ϱ� 0�� ��µ�
		System.out.println(tm.name);			// �⺻���� null�̴ϱ� null�� ��µ�
		
		tm = new Test01Main(99, "kim");		// new �ϴ� ���� �⺻���� null
		System.out.println(tm.num);				// �⺻���� 0�̴ϱ� 0�� ��µ�
		System.out.println(tm.name);			// �⺻���� null�̴ϱ� null�� ��µ�
		
		tm = new Test01Main(99, 88, 77);
		System.out.println(tm.kor);
		System.out.println(tm.eng);
		System.out.println(tm.math);
		
		tm = new Test01Main(111, 222);
		System.out.println(tm.eng);
		System.out.println(tm.math);

	}	// end of main

}
