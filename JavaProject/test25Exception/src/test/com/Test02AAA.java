package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test02AAA {
	// �̷��� ���� ���� �ϸ� main���� �� ����ó�� �϶�� ���
	// >> ���������� �����ϴ� ������ ó���Ϸ��� ��� ������ �� �ִ�.
	public int insert() throws IOException {
		System.out.println("insert...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String name = br.readLine();
		return 0;
	}

	public int update() {
		System.out.println("update...");
		BufferedReader br = null;

		// ���� ���θ� �˱� ���� ����� ���� ����
		int flag = 0;
		// 0�̸� ����, 1�̸� �������� ó���ǵ���

		try {
			// ������ ���� ���� �߰��� ����
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
		// ���� �߻� ���ο� ��� ���� ������ ����
		finally {
			// ��� br�� null�̸� ���� �ʰ� �Ѵ� = NullPointerException ó��
			// �̰͵� null üũ�ϴ� ���� ó��
			if(br != null) {
			try {
				// buffer�� �ݾ���
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ǡ�̴�����!");
		}
	 }

		// call�� �ʿ����� flag�� 0���� 1������ ���� ó���Ѵ�.
		return flag;
	}

}
