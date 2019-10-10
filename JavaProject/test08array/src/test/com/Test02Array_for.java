package test.com;

public class Test02Array_for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 반복문을 이용해 배열을 변경 또는 검색하기
		
		double[] ds = new double[5];
		// 0.0, 0.0, 0.0, 0.0, 0.0 으로 구성
		
		// for 문을 이용해서 출력하세요.
		
		for(int i=0; i<ds.length; i++) {
			System.out.println(ds[i]);
		}
		
		System.out.println();
		
		for(int i=0; i<ds.length; i++) {
			ds[i] = i+2;					
			System.out.println(ds[i]);
		}
		
		System.out.println();
		
		// 참, 거짓, 참, 거짓값을 갖는 배열을 반복문으로 생성하고 출력
		boolean[] b = new boolean[4];
		for(int i=0; i<b.length; i++) {
			if(i%2==0) b[i] = true;
			//else b[i] = false;		// 기본값이 false니까 안써도 될듯
			System.out.println(b[i]);
		}	// 일단 for문을 돌려놓고 기본값이 뭐가 나오나 찍어보고 만들기

	}	// end of main

}	// end of class
