package test.com;

public class Test02array_array {
	public static void main(String[] args) {

		// kim 1, 2, 3 배열이 여러 개 들어있는 배열을 만들고 출력하시오.

		String[] str0 = new String[3];
		for (int i = 0; i < str0.length; i++) {
			str0[i] = "kim" + (i + 1);
			//System.out.println(str0[i]);
		}
		
		//System.out.println();
		
		String[] str1 = new String[3];
		for (int i = 0; i < str1.length; i++) {
			str1[i] = "kim" + (i + 1);
			//System.out.println(str1[i]);
		}
		
		//System.out.println();
		
		String[] str2 = new String[3];
		for (int i = 0; i < str2.length; i++) {
			str2[i] = "kim" + (i + 1);
			//System.out.println(str2[i]);
		}
		
		//System.out.println();
		
		String[][] strr = new String[3][3];
		for(int i=0; i<strr.length; i++) {
			//System.out.println(strr[i]);
			for(int j=0; j<strr[i].length; j++) {
				//System.out.println(strr[i][j]);
				if(i==0) strr[i][j] = str0[i];
				else if(i==1) strr[i][j] = str1[i];
				else if(i==2) strr[i][j] = str2[i];
				
			}	// inner
		}	// outer
		
		for(int i=0; i<strr.length; i++){
			for(int j=0; j<strr[i].length; j++) {
				System.out.print(strr[i][j] + " ");
			}
			System.out.println();
		}
		

	} // end of main

} // end of class
