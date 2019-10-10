package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test01Exception {

	public static void main(String[] args) {
		
		/* 예외처리 : 발생할 오류를 사전에 우회하도록 처리하는 방법
		 * 1. 컴파일 할 때 오류 처리 
		 * 2. 실행시 오류처리
		 * throws(예외 전가)와 try-catch(예외 처리)가 있다.
		 * 
		 * 실행하다가 중간에 에러가 걸리면 그 뒤는 실행되지 않고 종료된다.
		 * = 오류에 의한 비정상적 종료
		 * 이런 상황이 발생하지 않도록 오류를 catch해서 처리해준다.
		 */
		
		/* 1. 입출력
		 * 
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("1...");
			// String name = br.readLine();
			int kor = Integer.parseInt(br.readLine());
			// Exception e에 걸림 >> 0으로 나눌 수 없어서
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
			System.out.println("4...정수형 문자를 입력하세요");
		}
		// 모든 예외를 다 알고 있을 수 없을 때 최상위에 있는 Exception 클래스를 써주면 나머지 예외는 이쪽으로
		  catch (Exception e) {
			  System.out.println("5...공사중");
			  e.printStackTrace();
		  }
		
		System.out.println("end...");
		
		

	}	// end of main

}	// end of class
