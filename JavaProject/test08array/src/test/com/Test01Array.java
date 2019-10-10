package test.com;

public class Test01Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 동일한 타입의 변수를 여러 개 만들 것인가?!
		// 배열명
		int [] sus = {10, 20, 30};				
		// 배열 하나 하나는 item = element, 아이템을 모은 건 리터럴.
		// 리터럴은 최종적으로 대입되는 값이니까.
		String[] ss = {"aaa", "bbb", "ccc"};	
		
		// 값을 넣지 않고 방만 일단 만드는 법
		int[] sus2 = new int[3];	// 0, 0, 0으로 기본값 초기화
		// 모든 배열의 기본값은 null이며, 거기에 들어있는 요소의 기본값은 
		// sus 자체의 기본값 = 타입의 기본값 = 배열의 기본값 = null
		// 참조타입의 기본값은 null. ex) String
		// sus 안에 들어있는 값(item, element)의 기본값 >> 대괄호를 날린 타입 상태의 기본값
		// >> 배열의 3개니까 0,0,0
		// String[] ss라면 null, null, null
		// int[][] suss는 null
		// int[][] suss = new int[3][3]에 들어있는 기본값은 null, null, null = 배열이 3개 들어있으니까
		
		
		
		for(int i=0; i<sus2.length; i++) {
			System.out.println(sus2[i]);
		}	// end of for
		
		// 참조 타입은 null의 기본값은 null이다.
		String[] ss2 = new String[3];
		System.out.println(ss2[0]);
		
		String[] ss3 = new String[3];
		ss3[0] = "kim";
		System.out.println(ss3[0]);
		// 자체를 출력하면 메모리 주소를 출력
		System.out.println(ss3);
		// 배열의 길이 출력. 데이터가 몇 개 들어가있나.
		// 점을 찍는다는 것은 결국 주소가 있다는 뜻.
		// null = 나는 주소가 없다. 주소가 없으니 .length를 할 수 없다.
		System.out.println(ss3.length);
		
		// 방의 개수를 정하지 않고 리터럴을 활용해 값을 할당 가능
		int[] sus3 = new int[] {};
		System.out.println(sus3);		// 주소가 나옴 >> . 찍을 수 있음
		System.out.println(sus3.length);	// 값이 없으니 길이가 0
		
		
		
	}	// end of main

}	// end of class
