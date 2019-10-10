package test.com;

public class Test01array_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 데이터를 담고 싶다 >> 변수 >> 타입 지정
		// 여러 데이터를{} 한 곳에 담고 싶다 >> 배열[] >> 동일 타입만 허용
		// 여러 배열{{},{}}을 한 곳에 담고 싶다 >> 다차원 배열[][] >> 동일한 배열 타입만 허용
		
		// array는 처음에 값을 직접 넣어 초기화 할 때는 new String[]을 생략할 수 있으나
		// 값을 나중에 수정하려면 꼭 넣어야 한다.
		
		int[] sus0 = new int[5];
		int[] sus1 = new int[4];
		int[] sus2 = new int[3];
		
		int[][] suss = new int[3][5];	// 넣고 싶은 배열 개수 + 그 배열의 length = 3행 5열
								// 5는 지워도 된다. 앞은 절대 안 됨.
		suss[0] = sus0;		// suss[0]의 기본값은 null
		suss[1] = sus1;
		suss[2] = sus2;
		// suss[0] = 99; 에러. 정수 배열이 들어가야 한다.
		
		System.out.println(suss); 	// 배열을 두 개 담아서 2개 >> [[I@15db9742 
		System.out.println(suss.length);
		System.out.println("");
		
		for(int j=0; j<suss.length; j++) {	// suss의 i번째 방
			System.out.println(suss[j]); 	// 그 방에는 배열이 있어서 출력하면 주소가 나온다.
			System.out.println("------");
			System.out.println(suss[j].length);		// 배열이고 길이가 잘 나오면 inner 시작
			System.out.println("------");
			for(int i=0; i<suss[j].length; i++) {		// suss[j]의 0, 1, 2...
				System.out.println(suss[j][i]);
			}
		}
		
		
//		 ctrl shift c : 주석 처리
		

	}	// end of main

}	// end of class

// int[] sus0 = new int[5];
// int[] sus1 = new int[4];
// int[] sus2 = new int[3];
//
// int[][] suss = new int[3][5];
// suss[0] = sus0;
// suss[1] = sus1;
// suss[2] = sus2;
//
// for (int x = 0; x < suss.length; x++) {
// for (int i = 0; i < suss[x].length; i++) {
// suss[x][i] = 100*i;
// }
// }
//
// System.out.println(suss);
// System.out.println(suss.length);
// for (int x = 0; x < suss.length; x++) {
// System.out.println(suss[x]);
// System.out.println(suss[x].length);
// for (int i = 0; i < suss[x].length; i++) {
// System.out.print(suss[x][i]+" ");
// }
// System.out.println();
// }
