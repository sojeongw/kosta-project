package test.com;

public class Test02Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*	1. �������� ���� : ���, ��, ��, ��Ʈ, ����, ����, ����Ʈ, 3�� etc
		 *		1) ��� : +, -, *, /, %
		 *		2) ���� : =, +=, -+, *=, %=, &=, |&, ^=
		 *				  ex) int x = 10 + 5; 	a += 10;
		 *				  �����ʺ��� ����ϰ� �������� ����.
		 *				  Ÿ�Ը� ������ �� �Ǵµ� �� ���� �� ������ ���� ��.
		 *		3) ��Ʈ : AND(&), OR(|), XOR(^) : ¦�� �� �¾ƾ� true
		 *		4) �� : &&, ||, &, |
		 *				  ����� true �Ǵ� false
		 *		5) �� : ==, !=, >, <, <=, >=
		 *				  ���ڴ� ���� �� ==�� ������� �ʴ´�.
		 *				  ex) menu == "1"; ������ ���ɼ��� �־ ������� ����.
		 *					  menu.equal("1"); �� ��ü�� �� �ִ�.
		 *		6) ���� : ++, --
		 *		7) ����Ʈ : >>, <<, >>> �ش� �������� �̵�
		 *					ex) (8 >> 2); �������� 2ĭ�� �̵�
		 *					1000�� 2ĭ�� �̵��ؼ� 0010 = 2
		 *					>>>�� ���� �������� ����� ��Ÿ�� ��
		 *		8) 3�� ������ ����(������ ���, �� ���� ���)�� ���� ���� �б� ó�� ����
		 *			���ǽ� ? ���� �� ���� �Ǵ� ����� : ������ �� ���� �Ǵ� �����
		 *
		 *	2. �������� �켱����
		 *		���� : ++, --, +, -, ~, !
		 *		��� : *, /, %
		 *			   +, -
		 *			   <<, >>
		 *		�� : <, >, <=, >=, instanceof
		 *			   ==, !=
		 *		�� : &
		 *			   ^
		 *			   |
		 *			   &&
		 *			   ||
		 *		���� : ? :
		 *		���� : =, +=, -+, *=, %=, &=, |&, ^=, <<=, >>= 
		 */
		
		System.out.println(9&5);
		System.out.println(9|5);
		System.out.println(9^5);
		System.out.println();
		
		int a = 9;
		a &= 5;
		System.out.println(a);		
		System.out.println();
		
		System.out.println(true & true);
		System.out.println(false & true);
		System.out.println(false & false);		// �� �ڵ� Ȯ���ؼ� ��� 
		System.out.println();
		
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && false);		// ���� �ڱ��� �� �ʿ䵵 ���� ���� �� �� ����
		System.out.println();
		
		System.out.println(true | true);		// �� �ڵ� Ȯ���ؼ� ���
		System.out.println(false | true);
		System.out.println(false | false);		 
		System.out.println();
		
		System.out.println(true || true);		// ���� �ڱ��� �� �ʿ䵵 ���� ���� �� �� ����
		System.out.println(false || true);
		System.out.println(false || false);		
		System.out.println();
		
		// System.out.println(8 & 8); true�� false�� �ƴϹǷ� error
		
		System.out.println(5 == 5);				// ��� ���� �ݵ�� true�� false�� ���´�.
												// �׷��� �񱳿� ���� ���� ���� ���δ�.
		System.out.println(5 == 5 && true);
		System.out.println();
		// System.out.println(1 && true); error
		
		System.out.println(8 >> 2); 
		System.out.println(2 << 2);
		System.out.println(-8 >>> 2);	
		System.out.println();
		
		System.out.println(true ? 1 : 0);
		System.out.println(false ? 1 : 0);
		System.out.println(true && true ? 1 : 0);		// �� ������ �̿�
		System.out.println(false || true ? 1 : 0);		// �� ������ �̿�
		System.out.println();
		
		System.out.println(8>5 ? 1 : 0);				// �� ������ �̿�
		System.out.println(8>5 ? "��" : "����");		// char �̿�
		System.out.println();
		
		int result = true && true ? 1 : 0;
		System.out.println(result);						// ���� �̿�
		String s = true && true ? "��" : "����";
		System.out.println(s);						// ���� �̿�
		System.out.println();
		
		// true && true ? 1 : 0; �� �ܵ����� �� �� ����. �ݵ�� ��򰡿� ���Եž� �Ѵ�.
		
		int q = 15;
		int w = 15;
		int e = q==w ? 100 : 50;
		System.out.println(e);
		
		int avg = 71;
		System.out.println(avg >= 80 ? 'B' : (avg >= 70 ? 'C' : 'D'));
		
		avg = 51;
		char c = avg >= 80 ? 'B' : (avg >= 70 ? 'C' : 'D');		//Ÿ���� ������ ��
		System.out.println(c);
				
		double total = 99 + 88.8 + 74;
		double davg = total / 3;
		char cc = davg >= 80 ? 'B' : (davg >= 70 ? 'C' : 'D');
		System.out.println("avg : " + davg);
		System.out.println("grade : " + cc);
		System.out.println();
		
		
	}

}
