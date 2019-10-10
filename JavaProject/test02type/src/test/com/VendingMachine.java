package test.com;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class VendingMachine {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		//	--음료수 자판기--
		//	금액을 투입하세요.
		//	메뉴를 선택하세요.
		//	1. 커피 700원		2. 포카리스웨트 500원		3. 오렌지 주스 100원
		//	1번을 선택하셨습니다.
		//	잔액 : 300원
		//	--맛있게 드세용--
		
		InputStream is = System.in;		// 시스템에서 입력받겠다
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
			
		System.out.println("--음료수 자판기--");
		System.out.println();
		System.out.println("금액을 투입하거라");
		int money = Integer.parseInt(br.readLine());
		System.out.println(money + "원을 받았다");
		System.out.println();
		
		System.out.println("메뉴를 골라보거라");
		System.out.println();
		
		System.out.println("1. 커피 700원");
		System.out.println("2. 포카리스웨트 500원");
		System.out.println("3. 오렌지 주스 100원");
		System.out.println();
		int menu = Integer.parseInt(br.readLine());
		System.out.println();
		
		System.out.println(menu + "번 줄게. 기다려봐라");
		int change = menu == 1 ? 300 : menu == 2 ? 500 : 900;
		System.out.println("옛다 잔돈 " + change + "원");
		System.out.println();
		System.out.println("--잘 먹거라--");
		
		//System.exit(0); 강제종료
		
		
	}

}
