package test.com;

public class Test01Type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 1. �⺻ Ÿ�� : ����, �Ǽ�, ������, ��/����
		 * 	1) ����
		 * 		�⺻�� : 0
		 * 		byte(1), short(2), char(2), int(4), long(8)
		 * 		�⺻�� int
		 * 		char�� 0�� ���� ������ �޴´�.
		 * 		byte : -128~127
		 * 				System.out.println(Byte.MIN_VALUE); �ϸ� ���� �����ش�.
		 * 	2) �Ǽ�
		 * 		�⺻�� : 0.0
		 * 		float(4), double(8)
		 * 		�⺻�� double
		 * 		float�� f�� �ٿ��� ǥ���Ѵ�. �׳� 3.14�ϸ� double�̴�.
		 * 		���� ū ���� long�� double�� �ƴ϶� double�̴�. �� ������ ���ڴϱ�.
		 * 	3) ������
		 * 	4) ��/����
		 *		Boolean : true�� false�� ǥ���Ѵ�.
		 *		�ڹٴ� 1, 0���� ��ü�� �� ����. �����ϰ� 0�� ǥ���� �� ���� ����.
		 *		false�� �⺻��
		 *
		 * 	>>> 8�� �⺻ Ÿ��.
		 * 
		 * 	�ٿ� ĳ������ ����ؾ������� �� ĳ������ �ڵ����� �ȴ�.
		 */
		
		System.out.println(Byte.MIN_VALUE); 
		System.out.println(Byte.MIN_VALUE);
		System.out.println();
		System.out.println(Short.MIN_VALUE); 
		System.out.println(Short.MAX_VALUE);
		System.out.println();
		System.out.println(Character.MIN_VALUE);
		System.out.println(Character.MAX_VALUE);
		System.out.println();
		System.out.println((int)Character.MIN_VALUE);
		System.out.println((int)Character.MAX_VALUE);
		System.out.println();
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println();
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println();
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		System.out.println();
		System.out.println(Boolean.TRUE);
		System.out.println(Boolean.FALSE);
		System.out.println();
		
		long z = 10L;
		System.out.println(z);
		// int x = 2200000000L; �ϸ� ����
		int x = (int)2200000000L;		// L�� int�� �ٲ㼭 �ٿ� ĳ����
		System.out.println(x);
		// byte b = 128; ����
		byte b = (byte)128;		// int�� ���ϴ� ���ڸ� byte�� �ٲ� �ٿ� ĳ����
		System.out.println(b);		// -128
		b = (byte)129;		
		System.out.println(b);		//-127
		int c = (int)'a';
		System.out.println(c);
		float f = 3.14f;			// float�� ǥ��
		float ff = (float)3.14;		// float�� Ÿ�� ĳ����
		System.out.println(f);
		// boolean bl = 0; ����
		boolean bl = true;
		
				
		/* 2. ���� Ÿ�� : �빮�ڷ� �����ϴ� ��
		 * 	1) String
		 * 	2) Array
		 * 	3) ��ü
		 */
		
		/* 3. ������ ���
		 *	1) ���� : �ҹ��ڷ� �����ϴ� �� �����Ѵ�. �����ڴ� �빮�ڷ�.
		 *	2) ��� : �빮�ڷ� ����. �����ڴ� ����ٷ� �̾��ش�.
		 *			  final�� ����� �տ� ���̸� ����� ����ȴ�.
		 *			  ex) final int X = 10;
		 */
		
	
		
	}

}
