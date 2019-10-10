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
		
		///////내용 입력
		for(int i=0; i<board.length; i++) {
		System.out.println("--------게시판--------");
		System.out.println("이름");
		name = br.readLine();
		System.out.println("제목");
		title = br.readLine();
		System.out.println("날짜");
		date = br.readLine();
		String[] row = {name, title, date};
		board[i] = row;
		}
		
		///////내용 출력
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j]+"\t");
				}
			System.out.println();
		}
		
		
		
		

	}

}
