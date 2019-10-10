package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test04Member {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//회원가입 프로그램
		InputStream is = System.in;		// 시스템에서 입력받겠다
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("=======================");
		System.out.println("   회원가입 프로그램");
		System.out.println("=======================");
		System.out.print("ID : ");					
		//ln을 빼고 하면 bufferreader가 바로 옆에 온다.
		String id = br.readLine();
		System.out.println("-----------------------");
		System.out.print("PW : ");
		String pw = br.readLine();
		System.out.println("-----------------------");
		System.out.print("NAME : ");
		String name = br.readLine();
		System.out.println("-----------------------");
		System.out.print("TEL : ");
		String tel = br.readLine();
		System.out.println("-----------------------");
		System.out.println(id + " " + pw + " " + name + " " + tel);
	}

}
