package test.com;

public class Test02Array_for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �ݺ����� �̿��� �迭�� ���� �Ǵ� �˻��ϱ�
		
		double[] ds = new double[5];
		// 0.0, 0.0, 0.0, 0.0, 0.0 ���� ����
		
		// for ���� �̿��ؼ� ����ϼ���.
		
		for(int i=0; i<ds.length; i++) {
			System.out.println(ds[i]);
		}
		
		System.out.println();
		
		for(int i=0; i<ds.length; i++) {
			ds[i] = i+2;					
			System.out.println(ds[i]);
		}
		
		System.out.println();
		
		// ��, ����, ��, �������� ���� �迭�� �ݺ������� �����ϰ� ���
		boolean[] b = new boolean[4];
		for(int i=0; i<b.length; i++) {
			if(i%2==0) b[i] = true;
			//else b[i] = false;		// �⺻���� false�ϱ� �Ƚᵵ �ɵ�
			System.out.println(b[i]);
		}	// �ϴ� for���� �������� �⺻���� ���� ������ ���� �����

	}	// end of main

}	// end of class
