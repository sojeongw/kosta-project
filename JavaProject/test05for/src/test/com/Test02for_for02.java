package test.com;

public class Test02for_for02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �̷��� �ϸ� 4������ ������ outer �ݺ��� ��� �ȴ�.
//		for(int x=0; x<10; x++) {
//			for(int i=0; i<10; i++) {
//				System.out.println(i);
//				if(i==4)	break;
//			}	// inner
//			System.out.println();
//		}	// outer

		// �̷��� �ϸ� �� loop�� �̸��� ���� �� �ִ�.
	f1:	for(int x=0; x<10; x++) {
			for(int i=0; i<10; i++) {
				
				System.out.println(i);
				if(i==4)	break f1;		// inner�� ����
			}	// inner
			System.out.println();
		}	// outer
	
	System.out.println();
	
	// ��� 3������ ����ϰ� outer �ݺ�
	f1:	for(int x=0; x<10; x++) {
		for(int i=0; i<10; i++) {
			if(i==4)	continue f1;	// inner�� �ٽ� ��
			System.out.println(i);
			
		}	// inner
		System.out.println();		// �굵 ���õȴ�. ��õ� ���� ������ ���� ����.
	}	// outer
		
		
	}	//end of main

}	// end of class
