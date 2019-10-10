package test.com;

public class Test03Score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("=======================");
		System.out.println("f성적처리프로그램");
		System.out.println("=======================");
		System.out.println("국어 점수를 입력하세요");
		int kor = 99;
		System.out.println(kor);
		System.out.println("-----------------------");
		System.out.println("수학 점수를 입력하세요");
		int math = 99;
		System.out.println(math);
		System.out.println("-----------------------");
		System.out.println("영어 점수를 입력하세요");
		int eng = 99;
		System.out.println(eng);
		System.out.println("-----------------------");
		int total = kor + eng + math;
		System.out.println("총점 : " + total);
		double avg = (double)total/3;
		System.out.println("평균 : " + avg);
		char grade = avg > 90 ? 'A' : avg > 80 ? 'B' : avg > 70 ? 'C' : 'D';
		System.out.println("등급 : " + grade);
		System.out.println("=======================");

	}

}
