package test.com;

import java.io.IOException;

public class Test02Exception2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Exception\n");
		
		Test02AAA ta = new Test02AAA();
		try {
			ta.insert();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// flag ���� �ް�
		int result = ta.update();
		
		// flag ���� ���� ���
		if(result == 1)System.out.println("successed");
		else System.out.println("failed");
		
		System.out.println("\nEnd");

	}

}





































