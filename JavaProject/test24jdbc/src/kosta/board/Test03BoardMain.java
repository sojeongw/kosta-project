package kosta.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Test03BoardMain {

	public static void main(String[] args) {

		///////// driver connection
		Test03BoardDAOimpl bDAO = new Test03BoardDAOimpl();
		Test03BoardVO bvo = new Test03BoardVO();

		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String exit = "";

		do {
			System.out.println("�ں��� ��ī�信 ���� ���� ȯ���մϴ�.");
			System.out.println("1.�۾���	2.�ۼ���	3.�ۻ���	4.�۸��	5.�۰˻�");
			String select = "";

			try {
				select = br.readLine();

				switch (select) {
				case "1": {

					// insert
					try {
						System.out.println("������ �Է��ϼ���.");
						bvo.setTitle(br.readLine());

						System.out.println("������ �Է��ϼ���.");
						bvo.setContent(br.readLine());

						System.out.println("�̸��� �Է��ϼ���.");
						bvo.setWriter(br.readLine());

						bDAO.insert(bvo);

						System.out.println("-----insert ����");
					} catch (IOException e) {
						System.out.println("-----insert ����");
						e.printStackTrace();
					}
					break;
				} // case 1

				case "2": {

					// update
					try {
						Test03BoardVO bvo2 = new Test03BoardVO();
						System.out.println("������ �۹�ȣ�� �Է��ϼ���.");
						bvo2.setNum(Integer.parseInt(br.readLine()));

						System.out.println("������ ������ �Է��ϼ���.");
						bvo2.setTitle(br.readLine());

						System.out.println("������ �Է��ϼ���.");
						bvo2.setContent(br.readLine());

						System.out.println("�̸��� �Է��ϼ���.");
						bvo2.setWriter(br.readLine());

						bDAO.update(bvo2);
						System.out.println("-----update ����");

					} catch (IOException e) {
						System.out.println("-----update ����");
						e.printStackTrace();
					}
					break;
				} // case 2

				case "3": {

					// delete
					System.out.println("������ �۹�ȣ�� �Է��ϼ���.");
					try {
						bvo.setNum(Integer.parseInt(br.readLine()));
						bDAO.delete(bvo);

					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				} // case 3

				case "4": {

					// selectAll
					List<Test03BoardVO> list = bDAO.selectAll();
					System.out.println("--- �Խ��� ��� ---");
					for (Test03BoardVO vo : list) {
						System.out.print(vo.getNum() + "\t");
						System.out.print(vo.getTitle() + "\t");
						System.out.print(vo.getContent() + "\t");
						System.out.print(vo.getWriter() + "\t");
						System.out.println(vo.getRegDate());
					} // end of for
					break;
				} // case 4

				case "5": {

					// selectOne
					System.out.println("�˻��� �۹�ȣ�� �Է��ϼ���.");
					try {
						bvo.setNum(Integer.parseInt(br.readLine()));
						bDAO.selectOne(bvo);

					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				} // case 5

				} // end of switch

				
				try {
					System.out.println("�����Ͻ÷��� x�� ��������\n");
					exit = br.readLine();
				} catch (IOException e) {
					break;
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} while (exit != "x");

	} // end main()

} // end class
