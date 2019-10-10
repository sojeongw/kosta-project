package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test03Score {
	public static void main(String[] arg) throws NumberFormatException, IOException {
		
	InputStream is = System.in;		// 시스템에서 입력받겠다
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr);
	// ctrl + shift + O 하면 import 됨
	// 스캔하는 건 코딩 맨 마지막에 추가하는 게 편하다.
	
	String list = "";
	
	System.out.println("=======================");
	System.out.println("성적처리프로그램");
	System.out.println("=======================");
	System.out.println("이름을 입력하세요");
	String name = br.readLine();
	for(int i=0 ; i<3 ; i++) {
		System.out.println();
	System.out.println("국어 점수를 입력하세요");
	//String kor = br.readLine();			readLine이 string이기 때문에 변수 kor도 String으로
	//int kor = Integer.parseInt("44");		얘는 스트링이 와도 int로 바꿔줌
	
	int kor = Integer.parseInt(br.readLine());
	System.out.println(kor);
	System.out.println("-----------------------");
	System.out.println("수학 점수를 입력하세요");
	int math = Integer.parseInt(br.readLine());
	System.out.println(math);
	System.out.println("-----------------------");
	System.out.println("영어 점수를 입력하세요");
	int eng = Integer.parseInt(br.readLine());
	System.out.println(eng);
	System.out.println("-----------------------");
	int total = kor + eng + math;
	System.out.println("총점 : " + total);
	double avg = (double)total/3;
	System.out.println("평균 : " + avg);
	char grade = avg > 90 ? 'A' : avg > 80 ? 'B' : avg > 70 ? 'C' : 'D';
	System.out.println("등급 : " + grade);
	System.out.println("=======================");
	list += name + (i+1) + " : " + kor + ", " + eng + ", " 
				+ math + ", " + "total" + ", " + avg + ", " + grade + "\n";
		
	
	}	//for
	
	System.out.println(list);
	
	
	}

}