package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test01While {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		while(true) {
//			
//		}
//		
//		System.out.println("while");	// ���ѹݺ��̶� �� ������ ����
//		
//		int i = 0;		//while�� �ϴ� �ۿ��� �ʱ�ȭ�� �ؾ��Ѵ�.
//		while(i<10) {
//			// �̷��� for�� ����ϸ� �ǹǷ� ��ȿ�����̴�.
//		}
		
		// � ���� �Է����� ������ ��� ���� ���α׷��� �����ϴ�.
		
		InputStream is = System.in;		// �ý��ۿ��� �Է¹ްڴ�
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
//		
//		String x = "";
//		while(!x.equals("x")) {
//			System.out.println("xxx");
//			System.out.println("�����Ϸ��� x �Է�");
//			x = br.readLine();
//			// �갡 ����� ���� �Է� �������� �� ���� �����. �ƴϸ� ���� ����
//		}
//		System.out.println("end while");
		
		boolean b = true;
		while(b) {
			System.out.println("xxxxxxxxx");
			System.out.println("�����Ϸ��� x�Է�");
			String x = br.readLine();
			if(x.equals("x")) break;
		}
		System.out.println("end while");
		
	}	// end of main

}	// end of class
