package test.com;

import java.util.*;

public class Test01Random {

	static String[] names = new String[] { "����ȣ", "������", "������", "�̰��", "������", "������", "�����", "�ռ���", "����ȣ", "�ڻ���", "��ǿ�",
			"�����", "�����", "������", "�缺ȣ", };
	
	

	public static void main(String[] args) throws InterruptedException {

		System.out.println("��÷!");

		Random r = new Random();
		
		// ������ �̸��� ������ �ʵ��� �ϱ�
		Set<String> set = new HashSet<>();
		
		for(int i=0; i<Test01Random.names.length; i++) {
			Thread.sleep(300);
			// 0���� �迭 ���̺��� �ϳ� ���� �������� ���� �� �����ϰ� �̰ڴ�
			int index = r.nextInt(Test01Random.names.length);
			System.out.println(Test01Random.names[index]);
			set.add(Test01Random.names[index]);

		}
		System.out.println();
		for (String name : set) {
			System.out.println(name);
		}

		
		
		
		
		
		

//		// for(int i=0; i<names.length; i++) { static���� non-static�� ������� ����
//		// >> static���� non-static ������ new�� �ؾ��Ѵ�.
//		for (int i = 0; i < names.length; i++) {
//			// Ŭ������ static ���� �ٿ��� ���ָ� Ŭ�����̸�.names.length �ؾߵǴµ�
//			// ���⼱ ���� Ŭ������ �����ϱ� ���� ����
//			System.out.println(r.nextInt(2)); // n-1 ������ ���� �� ���� ��÷
//		} // end of for
//
//		// �迭�� ��� �̸� �̱�
//		for (int i = 0; i < names.length; i++) {
//			int index = r.nextInt(Test01Random.names.length);
//			// System.out.println("random index : " + index);
//			// System.out.println(Test01Random.names[index]); // n-1 ������ ���� �� ���� ��÷
//
//			// �� �������� ���� ��� �̱�
//			if (i == Test01Random.names.length - 1) {
//				System.out.println(Test01Random.names[index] + " ");
//			} // end of if
//		} // end of for
//
//		// 1�ʿ� �� ���� �̱�
//		for (int i = 0; i < names.length; i++) {
//			Thread.sleep(1000);
//			int index = r.nextInt(Test01Random.names.length);
//			System.out.println(Test01Random.names[index]);
//		} // end of for
		
	

	} // end of main

} // end of class
