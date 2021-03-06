package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test02Score {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		// 시스템화면입력용 코딩부분////////////////////////
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		///////////////////////////////////////////////////

		System.out.println("=================");
		System.out.println("성적처리프로그램");
		System.out.println("=================");
		// 1:홍길동1:99:88:77:264:88:B
		// 2:홍길동2:99:88:77:264:88:B
		// 3:홍길동3:99:88:77:264:88:B
		String list = "";
		String x = "";
		int i = 0;
		do{
			System.out.println("이름을 입력하세요");
			String name = br.readLine();
			System.out.println(name);
			System.out.println("-----------------");
			System.out.println("국어점수를 입력하세요.");
			int kor = Integer.parseInt(br.readLine());
			System.out.println(kor);
			System.out.println("-----------------");
			System.out.println("영어점수를 입력하세요.");
			int eng = Integer.parseInt(br.readLine());
			;
			System.out.println(eng);
			System.out.println("-----------------");
			System.out.println("수학점수를 입력하세요.");
			int math = Integer.parseInt(br.readLine());
			;
			System.out.println(math);
			System.out.println("-----------------");
			int total = kor + eng + math;
			System.out.println("총점:" + total);
			System.out.println("-----------------");
			double avg = (double) total / 3;
			System.out.println("평점:" + avg);
			System.out.println("-----------------");
			char grade = avg >= 90 ? 'A' : avg >= 80 ? 'B' : avg >= 70 ? 'C' : 'D';// 삼항연산처리하세요
			System.out.println("등급:" + grade);
			System.out.println("=================");
			
			//////총 성적 출력//////
			System.out.println(
					"" + i + ":" + name + ":" + kor + ":" + eng + ":" + math + ":" + total + ":" + avg + ":" + grade);
			list += "" + i + ":" + name + ":" + kor + ":" + eng + ":" + math + ":" + total + ":" + avg + ":" + grade
					+ "\n";
			i++;
			
			System.out.println();
			System.out.println("종료하려면 x입력, 계속하려면 아무 키나 누르세요");
			x = br.readLine();
		}while (!x.equals("x")); // end for
		System.out.println("=================");

		System.out.println(list);

	}	// end of main

}	// end of class
