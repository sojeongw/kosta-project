package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test07Board {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String[][] board = new String[3][4];
		String name;
		String title;
		String date;
		
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		///////���� �Է�
		for(int i=0; i<board.length; i++) {
		System.out.println("--------�Խ���--------");
		System.out.println("�̸�");
		name = br.readLine();
		System.out.println("����");
		title = br.readLine();
		System.out.println("��¥");
		date = br.readLine();
		String[] row = {name, title, date};
		board[i] = row;
		}
		
		///////���� ���
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j]+"\t");
				}
			System.out.println();
		}
		
		
		
		

	}

}
