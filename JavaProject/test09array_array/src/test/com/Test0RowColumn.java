package test.com;

public class Test0RowColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = new int[4][4];
		int a = 1;

		/////////�Է�////////
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = a++;
			} // end of inner for
		} // end of outer for

		/////////���////////
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
				if (arr[i][j] % 4 == 0) {
					System.out.println();
				} // end of if
			} // end of inner for
		} // end of outer for
		
		System.out.println();
		
		/////�Է�
		char[][] charArr = {{'A','B','C','D'},
						{'E','F'},
						{'G','H','I'}};
		////���
		for(int i=0; i<charArr.length; i++) {
			for(int j=0; j<charArr[i].length; j++) {
//				
				System.out.print(charArr[i][j]+" ");
			}System.out.println();
		}
		
		System.out.println();
		
		////�Է�
		String[][] strArr = {{"��ȣ", "\t�̸�", "\t����", "\t����", "\tŰ"},
							{"1", "\tȫ�浿", "\t44", "\t��", "\t188"},
							{"2", "\t�ڱ浿", "\t34", "\t��", "\t186"},
							{"3", "\t��浿", "\t22", "\t��", "\t168"},
							};
				
		
		
		for(int i=0; i<strArr.length; i++) {
			for(int j=0; j<strArr[i].length; j++) {
				System.out.print(strArr[i][j]);
			}System.out.println();
		}
		
		
		
	
	

} // end of main

} // end of class
