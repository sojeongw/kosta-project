package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test04Member {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//ȸ������ ���α׷�
		InputStream is = System.in;		// �ý��ۿ��� �Է¹ްڴ�
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("=======================");
		System.out.println("   ȸ������ ���α׷�");
		System.out.println("=======================");
		System.out.print("ID : ");					
		//ln�� ���� �ϸ� bufferreader�� �ٷ� ���� �´�.
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
