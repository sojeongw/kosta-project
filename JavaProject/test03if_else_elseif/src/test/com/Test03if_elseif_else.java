package test.com;

import java.util.Scanner;

public class Test03if_elseif_else {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		int score = 0;
		char grade = ' ';
		char opt = '0';
		
		System.out.println("점수를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		score = Integer.parseInt(tmp);
		
		System.out.printf("당신의 점수는 %d입니다", score);

		if(score > 90) {
			grade = 'A';
			if(score > 98) {
				opt = '+';
			}
		}
		
		System.out.printf("당신의 학점은 %c%c입니다.", grade, opt);
	}

}
