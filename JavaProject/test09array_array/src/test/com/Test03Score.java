package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test03Score {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		///////////////////////////////////////////////////

		System.out.println("=================");
		System.out.println("����ó�����α׷�");
		System.out.println("=================");
		// 1:ȫ�浿1:99:88:77:264:88:B
		// 2:ȫ�浿2:99:88:77:264:88:B
		// 3:ȫ�浿3:99:88:77:264:88:B
		//String list = "";
		String x = "";
		int i = 0;
		String[][] sList = new String[7][3];
		//System.out.println(sList.length);
		
		for(i=0; i<3; i++){
			System.out.println("�̸��� �Է��ϼ���");
			String name = br.readLine();
			sList[0][i] = name;
			
			System.out.println("-----------------");
			System.out.println("���������� �Է��ϼ���.");
			String kor = br.readLine();
			sList[1][i] = kor;
			
			System.out.println("-----------------");
			System.out.println("���������� �Է��ϼ���.");
			String eng = br.readLine();
			sList[2][i] = eng;
			
			System.out.println("-----------------");
			System.out.println("���������� �Է��ϼ���.");
			String math = br.readLine();
			sList[3][i] = math;
				
			
			System.out.println("-----------------");
			int total = Integer.parseInt(kor)
						+ Integer.parseInt(eng)
						+ Integer.parseInt(math);
			System.out.println("����:" + total);
			sList[4][i] = "" + total;
			
			System.out.println("-----------------");
			double avg = (double) total / 3;
			System.out.println("����:" + avg);
			sList[5][i] = "" + avg;
			
			System.out.println("-----------------");
			char grade = avg >= 90 ? 'A' : avg >= 80 ? 'B' : avg >= 70 ? 'C' : 'D';// ���׿���ó���ϼ���
			System.out.println("���:" + grade);
			sList[6][i] = "" + grade;
				
			System.out.println("=================");
			
			//////�� ���� ���//////
			
			
//			System.out.println();
//			System.out.println("�����Ϸ��� x�Է�, ����Ϸ��� �ƹ� Ű�� ��������");
//			x = br.readLine();
		} // end for
		System.out.println("=================");

		for(int k=0; k<sList.length; k++) {
			for(int j=0; j<sList[k].length; j++) {
				System.out.print(sList[k][j]+"\t");
			}
			System.out.println();
		}

	}

}
