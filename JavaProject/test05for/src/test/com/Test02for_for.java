package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test02for_for {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		// if�� �ƹ��� ���Ƶ� break���� �� if�� ���� ����������.
		// = if���� ���� ������ ���� ����� ������ ����.

//		for (int j = 0; j < 3; j++) {
//			for (int i = 0; i < 10; i++) {
//				System.out.print(i + " ");
//			} // end of for
//			System.out.println();
//		} // end of outer for

//		System.out.println();
//
//		// 02468
//		// 02468
//		// 02468
//		for (int j = 0; j < 3; j++) {
//			for (int i = 0; i < 5; i++) {
//				System.out.print(i * 2);
//			} // inner
//			System.out.println();
//		} // outer
//
//		System.out.println();
//
//		// �ٸ� ���
//		for (int j = 0; j < 3; j++) {
//			for (int i = 0; i < 10; i++) {
//				if (i % 2 == 0) {
//					System.out.print(i);
//				} // end of if
//			} // end of for i
//			System.out.println();
//		} // end of for j
//
//		System.out.println();
//
//		for (int j = 0; j < 3; j++) {
//			for (int i = 0; i < 10; i += 2) {
//				if (i % 2 == 0) {
//					System.out.print(i);
//				} // end of if
//			} // end of for i
//			System.out.println();
//		} // end of for j
//
//		System.out.println();
//
//		for (int j = 2; j < 10; j++) {
//			for (int i = 1; i < 10; i++) {
//				System.out.print(j + "*" + i + " = " + i * j + " ");
//			}
//			System.out.println();
//		}
//
//		System.out.println();
//
//		InputStream is = System.in;
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
//
//		int a;
//		int b;
//
//		while(true){
//			a = Integer.parseInt(br.readLine());
//			b = Integer.parseInt(br.readLine());
//			if(a < b && a>0 && b>0) {
//				for (int j = a; j <= b; j++) {
//					for (int i = 1; i < 10; i++) {
//						System.out.print(j + "*" + i + " = " + i * j + " ");
//					} // inner
//					System.out.println();
//				} // outer
//			} // end of if
//			else{
//				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
//			} // end of else
//		}	// end of while
		
		
		// ���ĺ��� a~z���� ���η� ����ϵ� 3�� ����ϼ���
		
//		for(int k=0 ; k<3 ; k++) {
//			for(char l=97 ; l<123 ; l++) {
//				System.out.print(l + " ");
//			}	// inner
//			System.out.println();
//		}	// outer
		
		// if���� ���� ������ ���� ����� ���� ������ ����
		for(int k=0 ; k<3 ; k++) {
			for(char l=97 ; l<123 ; l++) {
				if(l=='k') continue;
				System.out.print(l + " ");
			}	// inner
			System.out.println();
		}	// outer
		
		System.out.println();
		
		// if���� ���� ������ ���� ����� ���� ����������
		for(int a=0 ; a<3 ; a++) {
			for(char b=97 ; b<123 ; b++) {
				if(b=='k') break;
				System.out.print(b + " ");
			}	// inner
		}	//outer
			System.out.println();
			

	} // end of main

} // end of class
