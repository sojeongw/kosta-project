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
//		System.out.println("while");	// 무한반복이라 이 구문이 에러
//		
//		int i = 0;		//while은 일단 밖에서 초기화를 해야한다.
//		while(i<10) {
//			// 이런건 for를 사용하면 되므로 비효율적이다.
//		}
		
		// 어떤 값을 입력하지 않으면 계속 도는 프로그램에 유용하다.
		
		InputStream is = System.in;		// 시스템에서 입력받겠다
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
//		
//		String x = "";
//		while(!x.equals("x")) {
//			System.out.println("xxx");
//			System.out.println("종료하려면 x 입력");
//			x = br.readLine();
//			// 얘가 생기는 순간 입력 받으려고 한 번만 실행됨. 아니면 무한 루프
//		}
//		System.out.println("end while");
		
		boolean b = true;
		while(b) {
			System.out.println("xxxxxxxxx");
			System.out.println("종료하려면 x입력");
			String x = br.readLine();
			if(x.equals("x")) break;
		}
		System.out.println("end while");
		
	}	// end of main

}	// end of class
