package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test03Score {
	public static void main(String[] arg) throws NumberFormatException, IOException {
		
	InputStream is = System.in;		// �ý��ۿ��� �Է¹ްڴ�
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr);
	// ctrl + shift + O �ϸ� import ��
	// ��ĵ�ϴ� �� �ڵ� �� �������� �߰��ϴ� �� ���ϴ�.
	
	String list = "";
	
	System.out.println("=======================");
	System.out.println("����ó�����α׷�");
	System.out.println("=======================");
	System.out.println("�̸��� �Է��ϼ���");
	String name = br.readLine();
	for(int i=0 ; i<3 ; i++) {
		System.out.println();
	System.out.println("���� ������ �Է��ϼ���");
	//String kor = br.readLine();			readLine�� string�̱� ������ ���� kor�� String����
	//int kor = Integer.parseInt("44");		��� ��Ʈ���� �͵� int�� �ٲ���
	
	int kor = Integer.parseInt(br.readLine());
	System.out.println(kor);
	System.out.println("-----------------------");
	System.out.println("���� ������ �Է��ϼ���");
	int math = Integer.parseInt(br.readLine());
	System.out.println(math);
	System.out.println("-----------------------");
	System.out.println("���� ������ �Է��ϼ���");
	int eng = Integer.parseInt(br.readLine());
	System.out.println(eng);
	System.out.println("-----------------------");
	int total = kor + eng + math;
	System.out.println("���� : " + total);
	double avg = (double)total/3;
	System.out.println("��� : " + avg);
	char grade = avg > 90 ? 'A' : avg > 80 ? 'B' : avg > 70 ? 'C' : 'D';
	System.out.println("��� : " + grade);
	System.out.println("=======================");
	list += name + (i+1) + " : " + kor + ", " + eng + ", " 
				+ math + ", " + "total" + ", " + avg + ", " + grade + "\n";
		
	
	}	//for
	
	System.out.println(list);
	
	
	}

}