package test.com;

public class Test03Array_for {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// kim1, kim2, kim3이라는 이름을 배열에 할당하고 출력하시오

		String[] str = new String[3];
		
		for (int i = 0; i < str.length; i++) {
			str[i] = "kim" + (i + 1);
			}

		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
			}
		
		// 분할해서 할당하고 출력하는 거 연습하기
		
		
		
		
		
	}	// end of main

}	// end of class
