package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test04Member {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//�ý���ȭ���Է¿� �ڵ��κ�////////////////////////
				InputStream is =  System.in;
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				///////////////////////////////////////////////////
				// ȸ���������α׷�
				System.out.println("=================");
				System.out.println("ȸ������ ���α׷�");
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
				
				//2�� ȸ����� ���

	}

}
