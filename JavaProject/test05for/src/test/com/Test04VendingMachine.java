package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test04VendingMachine {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		InputStream is = System.in;		// 시스템에서 입력받겠다
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String list = "";		
		int money = 0;
		
		
		System.out.println("--음료수 자판기--");
		System.out.println();
		
		System.out.println("금액을 투입하거라");
		money = Integer.parseInt(br.readLine());
		System.out.println(money + "원을 받았다");
		
		System.out.println();
		int change = money;
		for(int i=0 ; i<3 ; i++) {
			
		System.out.println("--메뉴를 골라보거라--");
		System.out.println();
		
		System.out.println("1. 커피 700원");
		System.out.println("2. 포카리스웨트 500원");
		System.out.println("3. 오렌지 주스 100원");
		System.out.println();
		int menu = Integer.parseInt(br.readLine());
		System.out.println();
		
		
			if(menu == 1 && change >= 700) {
				change -= 700;
				list += menu + " ";
				System.out.println(change + "원 남았습니다.\n");
			}
			else if(menu == 2 && change >= 500) {
				change -= 500;
				list += menu + " ";
				System.out.println(change + "원 남았습니다.\n");
			}
			else if(menu == 3 && change >= 100) {
				change -= 100;
				list += menu + " ";
				System.out.println(change + "원 남았습니다.\n");
			}
			else System.out.println("★돈 없으면 저리 꺼져!★\n");
		}
		
		
		System.out.println(list + "번 줄게, 기다려봐라");
//		int change = menu == 1 ? 300 : menu == 2 ? 500 : 900;
		System.out.println("옛다 잔돈 " + change + "원");
		System.out.println();
		System.out.println("--잘 먹거라--");

	}

}
