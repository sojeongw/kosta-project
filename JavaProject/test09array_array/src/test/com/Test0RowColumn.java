package test.com;

public class Test0RowColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = new int[4][4];
		int a = 1;

		/////////입력////////
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = a++;
			} // end of inner for
		} // end of outer for

		/////////출력////////
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
				if (arr[i][j] % 4 == 0) {
					System.out.println();
				} // end of if
			} // end of inner for
		} // end of outer for
		
		System.out.println();
		
		/////입력
		char[][] charArr = {{'A','B','C','D'},
						{'E','F'},
						{'G','H','I'}};
		////출력
		for(int i=0; i<charArr.length; i++) {
			for(int j=0; j<charArr[i].length; j++) {
//				
				System.out.print(charArr[i][j]+" ");
			}System.out.println();
		}
		
		System.out.println();
		
		////입력
		String[][] strArr = {{"번호", "\t이름", "\t나이", "\t성별", "\t키"},
							{"1", "\t홍길동", "\t44", "\t남", "\t188"},
							{"2", "\t박길동", "\t34", "\t남", "\t186"},
							{"3", "\t김길동", "\t22", "\t여", "\t168"},
							};
				
		
		
		for(int i=0; i<strArr.length; i++) {
			for(int j=0; j<strArr[i].length; j++) {
				System.out.print(strArr[i][j]);
			}System.out.println();
		}
		
		
		
	
	

} // end of main

} // end of class
