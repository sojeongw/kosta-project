package test.com;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 8�� �⺻�� Ÿ��
		 * 1) ������
		 * 		byte(1), short(2), character(2), integer(4), long(8)
		 * 		character�� 0�� ���� ������ �޴´�.
		 * 		�⺻�� integer�̰� integer�� �⺻���� 0�̴�.
		 * 		long�� ���� ���� L�� �ٿ� ǥ���Ѵ�.
		 * 		byte�� -128~127������ ������ ���´�.
		 * 2) �Ǽ���
		 * 		float(4), double(8)
		 * 		�⺻�� double�̰� �⺻���� 0.0�̴�. ��� Ÿ�Կ��� ���� ū Ÿ���̴�.
		 * 		float�� ���� �ڿ� f�� �ٿ� ǥ���Ѵ�. �׳� ���� ���� double�̴�.
		 * 3) ������
		 * 		character(2)
		 * 4) �� �Ǵ� ����
		 * 		boolean(1) : true�� false�� ��Ÿ����. �����ϰ� 0�� ǥ���� �� ����.
		 */
		
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Character.MIN_VALUE);
		System.out.println(Character.MAX_VALUE);
		System.out.println((double)Character.MIN_VALUE);
		System.out.println((double)Character.MAX_VALUE);
		System.out.println(Boolean.TRUE);
		System.out.println(Boolean.FALSE);
		
		float f = 10.5f;
		//float ff = 3.14; 		Ÿ�� ����ġ�� ����.
		f = (float)3.14;
		
		long l = 25L;
		long ll = 25;
		long lll = 25l;			//�ҹ��ڷε� �ǳ�. ���� ������ �빮�� ���µ�.
		
		//int x = 25L;			Ÿ�� ����ġ�� ����.
		int x = 25;
		x = (int)30L;			// Ÿ�� �ٿ� ĳ����
		
		// byte b = 128;		�����÷ο�� ����.
		byte b = (byte)128;		// �ڷ� �Ѿ�� -128���� ����
		System.out.println(b);
		b = (byte)129;
		System.out.println(b);	// -127
		
		//boolean bl = 0;		���ڷ� ǥ���� �� ����.
		boolean bl = true;
		boolean bbll = false;
		System.out.println(bl);
		System.out.println(bbll);
		
		
		/* ������ ����
		 * String, Array �� �빮�ڷ� �����ϴ� �� + ��ü
		 */
		
		String s = "��Ʈ��";
		
		/* ������ ���
		 * 		1) ���� : �׻� ���� ���Ѵ�. �ҹ��ڷ� �����ϰ� �����ڴ� �빮��
		 * 		2) ��� : �׻� ���� ����. �빮�ڷ� �̷����� �����ڴ� ����ٷ� �մ´�.
		 * 				  final�� �����Ѵ�.
		 */
		
		int i = 10;
		final int ii = 100;
		
		
		/* �������� ����
		 * 	1) ��������� : +, -, *, /, %
		 * 	2) ���Կ����� : =, +=, -=, *=, /=, %=, &=, |=, ^=
		 * 	3) �������� : &, |, &&, || true�� false�� ������� �Ѵ�.
		 *  4) �񱳿����� : ==, >, <, !=, <=, >=
		 *  5) ��Ʈ������ : &, |, ^,
		 *  				XOR�� ���� ��Ʈ�� �ٸ� ��(1�� �ϳ��� ���� ��) 1�̴�.
		 *  6) ���������� : ++, --
		 *  7) ����Ʈ������ : >>, <<, >>>, <<<
		 *  				  ���� ���ڸ�ŭ 0�� �߰��� �о��.
		 *  				  >>>, <<<�� ������ ����� ��Ÿ�� �� ����Ѵ�.
		 *  8) 3�׿����� : ���ǽ� ? true�϶� �����̳� �� : false�϶� �����̳� ��
		 *  			   ���������� ���� �� ���� �ݵ�� ��򰡿� ������ �Ǿ�� �Ѵ�.
		 */
		
		System.out.println();
		System.out.println(true && false);
		System.out.println(8>>2); // 1000�̴ϱ� 0010 = 2
		System.out.println(-8>>>2);
		System.out.println(5 == 5);
		System.out.println(5 > 6 && false);
		String str = 5 > 6 ? "true" : "false";
		System.out.println(str);
		// 5 > 6 ? "true" : "false"; ����
		
		
		
		
	}

}
