package test.com;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test02Main {

	private static final class Test01Anonymous2Extension extends Test01Anonymous2 {
		@Override
		public void bbb() {
			System.out.println("inner addlistener bb()");
		}
	}

	public static void main(String[] args) {

		System.out.println("inner class...2");

		/*
		 * Object obj = new Object();
		 * Test02 t2 = new Test02(new Object());
		 * BufferedReader br = new BufferedReader(new InputStreamReader(null));
		 */

		// anonymous�� aaa() ������ ������ �� �� �����ϰ� �ʹٸ� ��ӹ޴� �ָ� ����� �ȴ�.
		// >>> class Test02AnonymousEx
		Test02 t2 = new Test02(new Test02AnonymousEx());
		Test02 t3 = new Test02(new Test01Anonymous() {
			@Override
			public void aaa() {
				System.out.println("inner aaa()");
			}
			
		});
		
		Test02 t4 = new Test02();	// ���ڰ� �ִµ� ���� �ϸ� ����
		
		// �굵 ��ü�ϱ� �޼ҵ忡 ���� �� �ִ�
		t4.addListener(new Test01Anonymous()/*abstract�� interface ���� �Ϲ� Ŭ������ �ƴϾ ���� >> �׳� ���θ� �������̵� �� �ؼ� �������ϱ�*/
			{
			@Override
			public void aaa() {
				System.out.println("inner addlistener aaa()");
			}
			
		});
		// t4���� �̳� Ŭ������ ���� ���� ���� addlistener �޼ҵ尡 �̿��� ���̴�
		// ���� ������ �޼ҵ带 ���� ���ϴ� �� �ƴϰ� �̳�Ŭ������ ���� ��ü�� �޼ҵ忡 ������
		// ���� �ٸ� ������ �ѱ�� �� �ݹ� ����. �̶� �͸� �̳� Ŭ������ ���� ���δ�.
		
		t4.addListener(new Test01Anonymous2(){
				@Override
				public void bbb() {
					System.out.println("inner addlistener bbb()");
				}
				
			});

	} // end of main

} // end of class
