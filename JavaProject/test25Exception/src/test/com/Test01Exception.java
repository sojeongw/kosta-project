package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test01Exception {

	public static void main(String[] args) {
		
		/* ����ó�� : �߻��� ������ ������ ��ȸ�ϵ��� ó���ϴ� ���
		 * 1. ������ �� �� ���� ó�� 
		 * 2. ����� ����ó��
		 * throws(���� ����)�� try-catch(���� ó��)�� �ִ�.
		 * 
		 * �����ϴٰ� �߰��� ������ �ɸ��� �� �ڴ� ������� �ʰ� ����ȴ�.
		 * = ������ ���� �������� ����
		 * �̷� ��Ȳ�� �߻����� �ʵ��� ������ catch�ؼ� ó�����ش�.
		 */
		
		/* 1. �����
		 * 
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("1...");
			// String name = br.readLine();
			int kor = Integer.parseInt(br.readLine());
			// Exception e�� �ɸ� >> 0���� ���� �� ���
			// System.out.println(10/0);
			System.out.println("1...2");
			System.out.println(10/1);
			
			System.out.println("1...3");
			int[] sus = new int[3];
			System.out.println(sus[3]);
			System.out.println("1...4");
			
			System.out.println("2...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("3...");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("4...������ ���ڸ� �Է��ϼ���");
		}
		// ��� ���ܸ� �� �˰� ���� �� ���� �� �ֻ����� �ִ� Exception Ŭ������ ���ָ� ������ ���ܴ� ��������
		  catch (Exception e) {
			  System.out.println("5...������");
			  e.printStackTrace();
		  }
		
		System.out.println("end...");
		
		

	}	// end of main

}	// end of class
