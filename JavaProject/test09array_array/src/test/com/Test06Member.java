package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test06Member {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// �ý���ȭ���Է¿� �ڵ��κ�////////////////////////
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		///////////////////////////////////////////////////
		
		// ȸ���������α׷�
		System.out.println("=================");
		System.out.println("ȸ������ ���α׷�");
		System.out.println("=================");

		// 2�� ȸ����� ���
		String[][] list = new String[3][4];
		for (int i = 0; i < list.length; i++) {
			
			System.out.print("ID : ");
			String id = br.readLine();
			
			System.out.println("------------------");
			System.out.print("PW : ");
			String pw = br.readLine();;
			
			System.out.println("------------------");
			System.out.print("NAME : ");
			String name = br.readLine();;
			
			System.out.println("------------------");
			System.out.print("TEL : ");
			String tel = br.readLine();;
			
			System.out.println("=================");
			//System.out.println("" + id + " : " + pw + " : " + name + " : " + tel + "");
			//System.out.println("=================");
			String[] row = {id, pw, name, tel};
			list[i] = row;
		}
		for(int i=0; i<list.length; i++) {
			//System.out.println(list);
			//System.out.println(list.length);
			for(int j=0; j<list[i].length; j++) {
				System.out.print(list[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("======ȸ����������==========");

	}

}
