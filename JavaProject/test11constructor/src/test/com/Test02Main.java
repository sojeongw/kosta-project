package test.com;

public class Test02Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("main");
		
		Test02aaa ta = new Test02aaa();
		System.out.println(ta);
		System.out.println(ta.num);
		System.out.println(ta.name);
		System.out.println(ta.tel);
		
		System.out.println();
		
		// 99, lee, 080을 주는 생성자를 만들고 객체를 생성해 출력하세요.
		ta = new Test02aaa(99, "lee", "080");
		System.out.println(ta);
		System.out.println(ta.num);
		System.out.println(ta.name);
		System.out.println(ta.tel);
		
		System.out.println();
		
		// Test02bbb에 기본 타입 속성과 배열 타입 속성을 만들고 객체 생성 및 초기화 하세요
		Test02bbb tb = new Test02bbb(28, new String[] {"왕소정","박보검","서강준"});
		System.out.println(tb.age);
		for(int i=0; i<tb.name.length; i++) {
		System.out.println(tb.name[i]);
		}
		
		System.out.println();
		
		// Test02bbb에 Test02aaa 속성을 추가하고 초기화 및 출력
		tb = new Test02bbb(ta);
		System.out.println(tb);
		System.out.println(tb.ta);
		System.out.println(tb.ta.num);
		System.out.println(tb.ta.name);
		System.out.println(tb.ta.tel);

	}	// end of main

}	// end of class
