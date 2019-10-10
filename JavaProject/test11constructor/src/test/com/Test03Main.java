package test.com;

public class Test03Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("main");
		
		/* Test tts = new Test[3];
		 * System.out.println(tts[0]); 		
		 * 하나의 값을 알고 싶으면 인덱스로 접근한다. "배열 안엔 뭐 있어?"
		 * 접근해서 보니까 그 대상 자체는 객체임.
		 * 객체 안에 뭐가 있니? 알고싶으면 점 찍는다.
		 * 만약 또 배열이라면 그 안에 뭐가 있는지 보려면 인덱스로 접근한다.
		 * 
		 * String [][] sss = new String[3][3];	얘한테 뭐가 있는지 궁금하면
		 * System.out.println(sss[0][0]);		인덱스로 접근한다.
		 */
		
		// 학생 객체에 속성을 부여하고 객체를 생성하시오
		Test03Student tst = new Test03Student();
		Test03Student tst2 = new Test03Student("왕소정", 1198057, 28);
		
		// 성적 객체에 학생 속성을 부여하고 객체를 생성하시오
		Test03Score tsc3 = new Test03Score();
		Test03Score tsc4 = new Test03Score(tst);
		tsc4 = new Test03Score(tst2);
		//tsc4 = new Test03Score(new Test03Student("왕소정", 1198057, 28));
		
		
//		// 학생 객체 배열을 만들고 출력
//		System.out.println("객체배열 : " + tst.stArr);
//		System.out.println("객체배열길이 : " + tst.stArr.length);
//		
//		// 배열에 입력
//		tst.stArr[0] = new Test03Student();	// null 없앨 땐 무조건 new >> 주소가 나옴
//		tst.stArr[1] = new Test03Student();	// null 없앨 땐 무조건 new
//		tst.stArr[2] = new Test03Student();	// null 없앨 땐 무조건 new
//		
//		for(int i=0; i<tst.stArr.length; i++) {
//			System.out.println(tst.stArr[i]);
//		}
//		
//		for(int i=0; i<tst.stArr.length; i++) {
//			// 주소가 생기면 무조건 점 찍는다
//			System.out.println(tst.stArr[i].num + " : " + tst.stArr[i].name);
//			// 다 똑같은 생성자로 22~24에서 만들었기 때문에 값이 같게 나옴.
//			// 다르게 하고 싶으면 22~24에서 인자값을 다르게 생성자를 생성하면 된다.
//		}

	}	// end of main

}
