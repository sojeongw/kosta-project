package test.com;

public class Test02Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("main");
		
		Test02aaa ta = new Test02aaa();
		System.out.println(ta);
		System.out.println(ta.num);
		System.out.println(ta.name);
		System.out.println(ta.tel);
		
		System.out.println();
		
		// 99, lee, 080�� �ִ� �����ڸ� ����� ��ü�� ������ ����ϼ���.
		ta = new Test02aaa(99, "lee", "080");
		System.out.println(ta);
		System.out.println(ta.num);
		System.out.println(ta.name);
		System.out.println(ta.tel);
		
		System.out.println();
		
		// Test02bbb�� �⺻ Ÿ�� �Ӽ��� �迭 Ÿ�� �Ӽ��� ����� ��ü ���� �� �ʱ�ȭ �ϼ���
		Test02bbb tb = new Test02bbb(28, new String[] {"�ռ���","�ں���","������"});
		System.out.println(tb.age);
		for(int i=0; i<tb.name.length; i++) {
		System.out.println(tb.name[i]);
		}
		
		System.out.println();
		
		// Test02bbb�� Test02aaa �Ӽ��� �߰��ϰ� �ʱ�ȭ �� ���
		tb = new Test02bbb(ta);
		System.out.println(tb);
		System.out.println(tb.ta);
		System.out.println(tb.ta.num);
		System.out.println(tb.ta.name);
		System.out.println(tb.ta.tel);

	}	// end of main

}	// end of class
