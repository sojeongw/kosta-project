package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test02for_for {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		// if가 아무리 많아도 break쓰면 그 if를 전부 빠져나간다.
		// = if문의 블럭을 제외한 가장 가까운 블럭으로 간다.

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
//		// 다른 방법
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
//				System.out.println("잘못 입력하셨습니다.");
//			} // end of else
//		}	// end of while
		
		
		// 알파벳을 a~z까지 가로로 출력하되 3행 출력하세요
		
//		for(int k=0 ; k<3 ; k++) {
//			for(char l=97 ; l<123 ; l++) {
//				System.out.print(l + " ");
//			}	// inner
//			System.out.println();
//		}	// outer
		
		// if문의 블럭을 제외한 가장 가까운 블럭의 끝으로 가라
		for(int k=0 ; k<3 ; k++) {
			for(char l=97 ; l<123 ; l++) {
				if(l=='k') continue;
				System.out.print(l + " ");
			}	// inner
			System.out.println();
		}	// outer
		
		System.out.println();
		
		// if문의 블럭을 제외한 가장 가까운 블럭을 빠져나가기
		for(int a=0 ; a<3 ; a++) {
			for(char b=97 ; b<123 ; b++) {
				if(b=='k') break;
				System.out.print(b + " ");
			}	// inner
		}	//outer
			System.out.println();
			

	} // end of main

} // end of class
