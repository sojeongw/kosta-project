package test.com;

import java.util.StringTokenizer;

public class Test02StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("StringBuffer and StringBuilder");
		long startTime = System.currentTimeMillis();
		
		StringBuffer sb = new StringBuffer();
		StringBuilder sb2 = new StringBuilder();	// ��� �����Ŷ� �� ����
		
		// ���ڰ� ��� ����
		sb.append("aaa");
		sb.append("aaa");
		sb.append("aaa");
		sb.append("aaa");
		sb.append("aaa");
		sb.append("aaa");
		
		// ó�� �ӵ��� �ſ� ������
		
		System.out.println(sb.toString().length());
		System.out.println(System.currentTimeMillis()-startTime);
		
		StringTokenizer st = new StringTokenizer("this is a test");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
		
		

	}	// end of main

}	// end of class
	