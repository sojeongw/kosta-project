package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test03Member {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream is =  System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		///////////////////////////////////////////////////
		// ȸ���������α׷�
		System.out.println("=================");
		System.out.println("ȸ������ ���α׷�");
		System.out.println("=================");
		String list = "";
		boolean b = true;
		
		while(b) {
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
		
		list += id + " " + pw + " " + name + " " + tel + "\n";
		
		System.out.println("����Ͻðڽ��ϱ�?");
		String answer = br.readLine();
		if(answer.equals("y")) continue;
		else break;
		
		
		}
		System.out.println(list);
		
		//2�� ȸ����� ���

	}

}
