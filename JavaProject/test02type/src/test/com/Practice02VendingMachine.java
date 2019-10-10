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
		
		System.out.println("---원하시는 메뉴를 선택해주세요---");
		System.out.println("1. 콩국수	2. 열무국수	  3. 메밀국수");
		String menuNum = br.readLine();
		
		String menuName = menuNum.equals("1") ? "콩국수" 
						  : menuNum.equals("2") ? "열무국수" 
						  : "메밀국수";
		System.out.println();
		System.out.println(menuName + "를 선택하셨습니다.");
		
		String price = menuNum.equals("콩국수") ? "5000원"
						: menuNum.equals("열무국수") ? "6000원"
						: "7000원";
		System.out.println(price + "입니다. 계산 도와드릴게요");
		
		int money = Integer.parseInt(br.readLine());
		System.out.println();
		
		System.out.println(money + "원 받았습니다.");
		int change = menuNum.equals("콩국수") ? money - 5000
					: menuNum.equals("열무국수") ? money - 6000 
					: money - 7000;
		System.out.println(change + "원 거슬러드릴게요.");
		
		System.out.println();
		System.out.println("감사합니다, 안녕히 가세요.");
		
		
		
		
		
		
	}

}
