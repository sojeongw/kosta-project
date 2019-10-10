package test.com;

	

public class Test04Student {
	
	// 메인에서 생성자 만들기 전에 쓰고 싶으면 여기다 쓰고 아니면 생성자에 쓴다.
	// total이나 avg 구하는 로직을 여기에 쓰면 같은 값만 계속 메인에 돌아간다.
	int num = 1;
	String name = "홍길동";
	int kor;
	int eng;
	int math;
	int total;
	double avg;
	char grade;
	
	Test04Student(){		// 생성자의 주 목적 : 전역변수의 초기화
		// 객체마다 값을 다르게 하고 싶으면 메인에서 객체 생성하고 다시 값을 바꾸면 됨.
		num = 2;
		name = "박길동";
		kor = 50;
		eng = 40;
		math = 20;
		total = kor + eng + math;
		avg = (double)total/3;
		grade = 'C';
		
	}

}
