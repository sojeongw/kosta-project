package test.com;

public class Test01switch_case {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* �б�ó�� 2
		 * ���� ������ �ƴ� �Ҵ� ������ �񱳷� �б��Ѵ�.
		 * ����, ĳ����. �Ǽ��� �� ��.
		 * 7���� �̻���� string�� �����ϴ�.
		 */
		
		
		// integer
		int key = 9;					
		switch (key) {
		case 10:							// �׳� �Ҵ� �����͸� ���ϰ� ��
			System.out.println("aaaaa");
			break;

		case 9:							// �׳� �Ҵ� �����͸� ���ϰ� ��
			System.out.println("bbbbb");
			break;
			
		default:
			System.out.println("default");
			break;
		}	// switch
		
		
		// String
		String key02 = "admin";					
		switch (key02) {
		case "10":							
			System.out.println("aaaaa");
			break;

		case "9":							
			System.out.println("bbbbb");
			break;
			
		default:
			System.out.println("default");
			break;
		}	// switch
		
		
		// character
		char key03 = 'a';					
		switch (key03) {
		case 'a':							
			System.out.println("aaaaa");
			break;

		case 'b':							
			System.out.println("bbbbb");
			break;
			
		case 'c':							
			System.out.println("ccccc");
			break;
			
		default:
			System.out.println("default");
			break;
		}	// switch
		
		System.out.println();
		
		// ���� ó��
		double avg = 99.9;			// ����/10�� ���ָ� ����
		System.out.println("��� : " + avg);
		char grade;
		
		switch ((int)avg) {
		case 99 :
			grade = 'A';
			System.out.println("��� : " + grade);
			break;
			
		case 85 :
			grade = 'B';
			System.out.println("��� : " + grade);
			break;
			
		case 70 :
			grade = 'C';
			System.out.println("��� : " + grade);
			break;
			
		default :
			grade = 'D';
			System.out.println("��� : " + grade);
			
			
		}
		
		/* �ڹ� ���� ���缭 �����ϴ� ��
		 * 		�ش� ���� ������ Ŭ�� - build path - configure build path
		 * 		- java compiler - complier compliance level���� ���� ����
		 * 
		 */
		

	}	// end of main

}
