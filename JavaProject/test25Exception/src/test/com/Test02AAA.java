package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test02AAA {
	// 이렇게 예외 전가 하면 main에서 또 예외처리 하라고 뜬다
	// >> 최종적으로 도달하는 끝에서 처리하려고 계속 전가할 수 있다.
	public int insert() throws IOException {
		System.out.println("insert...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String name = br.readLine();
		return 0;
	}

	public int update() {
		System.out.println("update...");
		BufferedReader br = null;

		// 성공 여부를 알기 위해 만드는 정수 변수
		int flag = 0;
		// 0이면 오류, 1이면 정상으로 처리되도록

		try {
			// 오류를 내기 위해 추가한 구문
			System.out.println(3/0);
			
			br = new BufferedReader(new InputStreamReader(System.in));
			String name = br.readLine();

			flag = 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 오류 발생 여부와 상관 없이 무조건 실행
		finally {
			// 대신 br이 null이면 닫지 않게 한다 = NullPointerException 처리
			// 이것도 null 체크하는 예외 처리
			if(br != null) {
			try {
				// buffer를 닫아줌
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("퐈이눠얼리이!");
		}
	 }

		// call한 쪽에서는 flag가 0인지 1인지만 보고 처리한다.
		return flag;
	}

}
