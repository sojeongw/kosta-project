package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test04VendingMachine {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		InputStream is = System.in;		// �ý��ۿ��� �Է¹ްڴ�
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String list = "";		
		int money = 0;
		
		
		System.out.println("--����� ���Ǳ�--");
		System.out.println();
		
		System.out.println("�ݾ��� �����ϰŶ�");
		money = Integer.parseInt(br.readLine());
		System.out.println(money + "���� �޾Ҵ�");
		
		System.out.println();
		int change = money;
		for(int i=0 ; i<3 ; i++) {
			
		System.out.println("--�޴��� ��󺸰Ŷ�--");
		System.out.println();
		
		System.out.println("1. Ŀ�� 700��");
		System.out.println("2. ��ī������Ʈ 500��");
		System.out.println("3. ������ �ֽ� 100��");
		System.out.println();
		int menu = Integer.parseInt(br.readLine());
		System.out.println();
		
		
			if(menu == 1 && change >= 700) {
				change -= 700;
				list += menu + " ";
				System.out.println(change + "�� ���ҽ��ϴ�.\n");
			}
			else if(menu == 2 && change >= 500) {
				change -= 500;
				list += menu + " ";
				System.out.println(change + "�� ���ҽ��ϴ�.\n");
			}
			else if(menu == 3 && change >= 100) {
				change -= 100;
				list += menu + " ";
				System.out.println(change + "�� ���ҽ��ϴ�.\n");
			}
			else System.out.println("�ڵ� ������ ���� ����!��\n");
		}
		
		
		System.out.println(list + "�� �ٰ�, ��ٷ�����");
//		int change = menu == 1 ? 300 : menu == 2 ? 500 : 900;
		System.out.println("���� �ܵ� " + change + "��");
		System.out.println();
		System.out.println("--�� �԰Ŷ�--");

	}

}
