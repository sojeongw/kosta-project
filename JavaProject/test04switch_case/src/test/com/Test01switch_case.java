package test.com;

public class Test01switch_case {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 분기처리 2
		 * 조건 연산이 아닌 할당 데이터 비교로 분기한다.
		 * 정수, 캐릭터. 실수는 안 됨.
		 * 7버전 이상부터 string도 가능하다.
		 */
		
		
		// integer
		int key = 9;					
		switch (key) {
		case 10:							// 그냥 할당 데이터를 비교하게 됨
			System.out.println("aaaaa");
			break;

		case 9:							// 그냥 할당 데이터를 비교하게 됨
			System.out.println("bbbbb");
			break;
			
		default:
			System.out.println("default");
			break;
		}	// switch
		
		
		// String
		String key02 = "admin";					
		switch (key02) {
		case "10":							
			System.out.println("aaaaa");
			break;

		case "9":							
			System.out.println("bbbbb");
			break;
			
		default:
			System.out.println("default");
			break;
		}	// switch
		
		
		// character
		char key03 = 'a';					
		switch (key03) {
		case 'a':							
			System.out.println("aaaaa");
			break;

		case 'b':							
			System.out.println("bbbbb");
			break;
			
		case 'c':							
			System.out.println("ccccc");
			break;
			
		default:
			System.out.println("default");
			break;
		}	// switch
		
		System.out.println();
		
		// 성적 처리
		double avg = 99.9;			// 점수/10을 해주면 편리함
		System.out.println("평균 : " + avg);
		char grade;
		
		switch ((int)avg) {
		case 99 :
			grade = 'A';
			System.out.println("등급 : " + grade);
			break;
			
		case 85 :
			grade = 'B';
			System.out.println("등급 : " + grade);
			break;
			
		case 70 :
			grade = 'C';
			System.out.println("등급 : " + grade);
			break;
			
		default :
			grade = 'D';
			System.out.println("등급 : " + grade);
			
			
		}
		
		/* 자바 버전 낮춰서 저장하는 법
		 * 		해당 파일 오른쪽 클릭 - build path - configure build path
		 * 		- java compiler - complier compliance level에서 값을 낮춤
		 * 
		 */
		

	}	// end of main

}
