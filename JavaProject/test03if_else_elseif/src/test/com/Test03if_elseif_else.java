package test.com;

import java.util.Scanner;

public class Test03if_elseif_else {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		int score = 0;
		char grade = ' ';
		char opt = '0';
		
		System.out.println("������ �Է����ּ���");
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		score = Integer.parseInt(tmp);
		
		System.out.printf("����� ������ %d�Դϴ�", score);

		if(score > 90) {
			grade = 'A';
			if(score > 98) {
				opt = '+';
			}
		}
		
		System.out.printf("����� ������ %c%c�Դϴ�.", grade, opt);
	}

}
