package test.com;

public class Test03Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("main");
		
		/* Test tts = new Test[3];
		 * System.out.println(tts[0]); 		
		 * �ϳ��� ���� �˰� ������ �ε����� �����Ѵ�. "�迭 �ȿ� �� �־�?"
		 * �����ؼ� ���ϱ� �� ��� ��ü�� ��ü��.
		 * ��ü �ȿ� ���� �ִ�? �˰������ �� ��´�.
		 * ���� �� �迭�̶�� �� �ȿ� ���� �ִ��� ������ �ε����� �����Ѵ�.
		 * 
		 * String [][] sss = new String[3][3];	������ ���� �ִ��� �ñ��ϸ�
		 * System.out.println(sss[0][0]);		�ε����� �����Ѵ�.
		 */
		
		// �л� ��ü�� �Ӽ��� �ο��ϰ� ��ü�� �����Ͻÿ�
		Test03Student tst = new Test03Student();
		Test03Student tst2 = new Test03Student("�ռ���", 1198057, 28);
		
		// ���� ��ü�� �л� �Ӽ��� �ο��ϰ� ��ü�� �����Ͻÿ�
		Test03Score tsc3 = new Test03Score();
		Test03Score tsc4 = new Test03Score(tst);
		tsc4 = new Test03Score(tst2);
		//tsc4 = new Test03Score(new Test03Student("�ռ���", 1198057, 28));
		
		
//		// �л� ��ü �迭�� ����� ���
//		System.out.println("��ü�迭 : " + tst.stArr);
//		System.out.println("��ü�迭���� : " + tst.stArr.length);
//		
//		// �迭�� �Է�
//		tst.stArr[0] = new Test03Student();	// null ���� �� ������ new >> �ּҰ� ����
//		tst.stArr[1] = new Test03Student();	// null ���� �� ������ new
//		tst.stArr[2] = new Test03Student();	// null ���� �� ������ new
//		
//		for(int i=0; i<tst.stArr.length; i++) {
//			System.out.println(tst.stArr[i]);
//		}
//		
//		for(int i=0; i<tst.stArr.length; i++) {
//			// �ּҰ� ����� ������ �� ��´�
//			System.out.println(tst.stArr[i].num + " : " + tst.stArr[i].name);
//			// �� �Ȱ��� �����ڷ� 22~24���� ������� ������ ���� ���� ����.
//			// �ٸ��� �ϰ� ������ 22~24���� ���ڰ��� �ٸ��� �����ڸ� �����ϸ� �ȴ�.
//		}

	}	// end of main

}
