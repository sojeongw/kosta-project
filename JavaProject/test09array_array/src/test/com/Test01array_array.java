package test.com;

public class Test01array_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �����͸� ��� �ʹ� >> ���� >> Ÿ�� ����
		// ���� �����͸�{} �� ���� ��� �ʹ� >> �迭[] >> ���� Ÿ�Ը� ���
		// ���� �迭{{},{}}�� �� ���� ��� �ʹ� >> ������ �迭[][] >> ������ �迭 Ÿ�Ը� ���
		
		// array�� ó���� ���� ���� �־� �ʱ�ȭ �� ���� new String[]�� ������ �� ������
		// ���� ���߿� �����Ϸ��� �� �־�� �Ѵ�.
		
		int[] sus0 = new int[5];
		int[] sus1 = new int[4];
		int[] sus2 = new int[3];
		
		int[][] suss = new int[3][5];	// �ְ� ���� �迭 ���� + �� �迭�� length = 3�� 5��
								// 5�� ������ �ȴ�. ���� ���� �� ��.
		suss[0] = sus0;		// suss[0]�� �⺻���� null
		suss[1] = sus1;
		suss[2] = sus2;
		// suss[0] = 99; ����. ���� �迭�� ���� �Ѵ�.
		
		System.out.println(suss); 	// �迭�� �� �� ��Ƽ� 2�� >> [[I@15db9742 
		System.out.println(suss.length);
		System.out.println("");
		
		for(int j=0; j<suss.length; j++) {	// suss�� i��° ��
			System.out.println(suss[j]); 	// �� �濡�� �迭�� �־ ����ϸ� �ּҰ� ���´�.
			System.out.println("------");
			System.out.println(suss[j].length);		// �迭�̰� ���̰� �� ������ inner ����
			System.out.println("------");
			for(int i=0; i<suss[j].length; i++) {		// suss[j]�� 0, 1, 2...
				System.out.println(suss[j][i]);
			}
		}
		
		
//		 ctrl shift c : �ּ� ó��
		

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
