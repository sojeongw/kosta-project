package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Practice02VendingMachine {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("---���Ͻô� �޴��� �������ּ���---");
		System.out.println("1. �ᱹ��	2. ��������	  3. �޹б���");
		String menuNum = br.readLine();
		
		String menuName = menuNum.equals("1") ? "�ᱹ��" 
						  : menuNum.equals("2") ? "��������" 
						  : "�޹б���";
		System.out.println();
		System.out.println(menuName + "�� �����ϼ̽��ϴ�.");
		
		String price = menuNum.equals("�ᱹ��") ? "5000��"
						: menuNum.equals("��������") ? "6000��"
						: "7000��";
		System.out.println(price + "�Դϴ�. ��� ���͵帱�Կ�");
		
		int money = Integer.parseInt(br.readLine());
		System.out.println();
		
		System.out.println(money + "�� �޾ҽ��ϴ�.");
		int change = menuNum.equals("�ᱹ��") ? money - 5000
					: menuNum.equals("��������") ? money - 6000 
					: money - 7000;
		System.out.println(change + "�� �Ž����帱�Կ�.");
		
		System.out.println();
		System.out.println("�����մϴ�, �ȳ��� ������.");
		
		
		
		
		
		
	}

}
