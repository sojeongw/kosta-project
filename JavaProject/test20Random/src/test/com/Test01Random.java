package test.com;

import java.util.*;

public class Test01Random {

	static String[] names = new String[] { "김정호", "정승현", "정성민", "이경률", "김지원", "문정인", "김송현", "왕소정", "전현호", "박상재", "김건욱",
			"김민재", "김기태", "이진욱", "양성호", };
	
	

	public static void main(String[] args) throws InterruptedException {

		System.out.println("당첨!");

		Random r = new Random();
		
		// 동일한 이름이 나오지 않도록 하기
		Set<String> set = new HashSet<>();
		
		for(int i=0; i<Test01Random.names.length; i++) {
			Thread.sleep(300);
			// 0부터 배열 길이보다 하나 작은 수까지의 숫자 중 랜덤하게 뽑겠다
			int index = r.nextInt(Test01Random.names.length);
			System.out.println(Test01Random.names[index]);
			set.add(Test01Random.names[index]);

		}
		System.out.println();
		for (String name : set) {
			System.out.println(name);
		}

		
		
		
		
		
		

//		// for(int i=0; i<names.length; i++) { static에서 non-static을 만들려니 에러
//		// >> static에서 non-static 쓰려면 new를 해야한다.
//		for (int i = 0; i < names.length; i++) {
//			// 클래스에 static 같이 붙여서 써주면 클래스이름.names.length 해야되는데
//			// 여기선 같은 클래스에 있으니까 생략 가능
//			System.out.println(r.nextInt(2)); // n-1 범위의 숫자 중 랜덤 추첨
//		} // end of for
//
//		// 배열에 담긴 이름 뽑기
//		for (int i = 0; i < names.length; i++) {
//			int index = r.nextInt(Test01Random.names.length);
//			// System.out.println("random index : " + index);
//			// System.out.println(Test01Random.names[index]); // n-1 범위의 숫자 중 랜덤 추첨
//
//			// 맨 마지막에 나온 사람 뽑기
//			if (i == Test01Random.names.length - 1) {
//				System.out.println(Test01Random.names[index] + " ");
//			} // end of if
//		} // end of for
//
//		// 1초에 한 번씩 뽑기
//		for (int i = 0; i < names.length; i++) {
//			Thread.sleep(1000);
//			int index = r.nextInt(Test01Random.names.length);
//			System.out.println(Test01Random.names[index]);
//		} // end of for
		
	

	} // end of main

} // end of class
