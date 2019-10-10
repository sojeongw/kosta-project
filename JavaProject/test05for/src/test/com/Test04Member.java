package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test04Member {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//시스템화면입력용 코딩부분////////////////////////
				InputStream is =  System.in;
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				///////////////////////////////////////////////////
				// 회원가입프로그램
				System.out.println("=================");
				System.out.println("회원가입 프로그램");
				System.out.println("=================");
				String list = "";
				for(int i=0 ; i<2 ; i++) {
				System.out.print("ID : ");
				String id = br.readLine();
				
				System.out.println("=================");
				System.out.print("PW : ");
				String pw = br.readLine();
			
				System.out.println("=================");
				System.out.print("NAME : ");
				String name = br.readLine();
			
				System.out.println("=================");
				System.out.print("TEL : ");
				String tel = br.readLine();
				
				System.out.println("=================");
				
				list += id + pw + name + tel + "\n";
				
				}
				System.out.println(list);
				
				//2명 회원명단 출력

	}

}
