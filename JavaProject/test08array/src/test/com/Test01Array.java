package test.com;

public class Test01Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ������ Ÿ���� ������ ���� �� ���� ���ΰ�?!
		// �迭��
		int [] sus = {10, 20, 30};				
		// �迭 �ϳ� �ϳ��� item = element, �������� ���� �� ���ͷ�.
		// ���ͷ��� ���������� ���ԵǴ� ���̴ϱ�.
		String[] ss = {"aaa", "bbb", "ccc"};	
		
		// ���� ���� �ʰ� �游 �ϴ� ����� ��
		int[] sus2 = new int[3];	// 0, 0, 0���� �⺻�� �ʱ�ȭ
		// ��� �迭�� �⺻���� null�̸�, �ű⿡ ����ִ� ����� �⺻���� 
		// sus ��ü�� �⺻�� = Ÿ���� �⺻�� = �迭�� �⺻�� = null
		// ����Ÿ���� �⺻���� null. ex) String
		// sus �ȿ� ����ִ� ��(item, element)�� �⺻�� >> ���ȣ�� ���� Ÿ�� ������ �⺻��
		// >> �迭�� 3���ϱ� 0,0,0
		// String[] ss��� null, null, null
		// int[][] suss�� null
		// int[][] suss = new int[3][3]�� ����ִ� �⺻���� null, null, null = �迭�� 3�� ��������ϱ�
		
		
		
		for(int i=0; i<sus2.length; i++) {
			System.out.println(sus2[i]);
		}	// end of for
		
		// ���� Ÿ���� null�� �⺻���� null�̴�.
		String[] ss2 = new String[3];
		System.out.println(ss2[0]);
		
		String[] ss3 = new String[3];
		ss3[0] = "kim";
		System.out.println(ss3[0]);
		// ��ü�� ����ϸ� �޸� �ּҸ� ���
		System.out.println(ss3);
		// �迭�� ���� ���. �����Ͱ� �� �� ���ֳ�.
		// ���� ��´ٴ� ���� �ᱹ �ּҰ� �ִٴ� ��.
		// null = ���� �ּҰ� ����. �ּҰ� ������ .length�� �� �� ����.
		System.out.println(ss3.length);
		
		// ���� ������ ������ �ʰ� ���ͷ��� Ȱ���� ���� �Ҵ� ����
		int[] sus3 = new int[] {};
		System.out.println(sus3);		// �ּҰ� ���� >> . ���� �� ����
		System.out.println(sus3.length);	// ���� ������ ���̰� 0
		
		
		
	}	// end of main

}	// end of class
