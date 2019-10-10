package test.com;

public class Test02for_for02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 이렇게 하면 4까지만 나오고 outer 반복은 계속 된다.
//		for(int x=0; x<10; x++) {
//			for(int i=0; i<10; i++) {
//				System.out.println(i);
//				if(i==4)	break;
//			}	// inner
//			System.out.println();
//		}	// outer

		// 이렇게 하면 그 loop에 이름을 붙일 수 있다.
	f1:	for(int x=0; x<10; x++) {
			for(int i=0; i<10; i++) {
				
				System.out.println(i);
				if(i==4)	break f1;		// inner를 나감
			}	// inner
			System.out.println();
		}	// outer
	
	System.out.println();
	
	// 얘는 3까지만 출력하고 outer 반복
	f1:	for(int x=0; x<10; x++) {
		for(int i=0; i<10; i++) {
			if(i==4)	continue f1;	// inner로 다시 들어감
			System.out.println(i);
			
		}	// inner
		System.out.println();		// 얘도 무시된다. 명시된 블럭의 끝으로 가기 때문.
	}	// outer
		
		
	}	//end of main

}	// end of class
