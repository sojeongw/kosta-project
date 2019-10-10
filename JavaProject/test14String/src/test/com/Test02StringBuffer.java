package test.com;

import java.util.StringTokenizer;

public class Test02StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("StringBuffer and StringBuilder");
		long startTime = System.currentTimeMillis();
		
		StringBuffer sb = new StringBuffer();
		StringBuilder sb2 = new StringBuilder();	// 얘는 예전거라 좀 느림
		
		// 문자가 계속 쌓임
		sb.append("aaa");
		sb.append("aaa");
		sb.append("aaa");
		sb.append("aaa");
		sb.append("aaa");
		sb.append("aaa");
		
		// 처리 속도가 매우 빠르다
		
		System.out.println(sb.toString().length());
		System.out.println(System.currentTimeMillis()-startTime);
		
		StringTokenizer st = new StringTokenizer("this is a test");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
		
		

	}	// end of main

}	// end of class
	