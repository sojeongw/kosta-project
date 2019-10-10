package assignment.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MemberMain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// �ý��� �Է� ����
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// ������ ��ȣ
		int select;


		// �ʱⰪ ����
		MemberVO vo = new MemberVO();

		// �ʱⰪ Ȯ��
		// System.out.println(bVO.getNum());
		// System.out.println(bVO.getTitle());
		// System.out.println(bVO.getContent());
		// System.out.println(bVO.getName());
		// System.out.println(bVO.getDate());

		MemberDAO dao = new MemberDAOimpl();

		while (true) {

			//////////// ���� ���� ////////////
			System.out.println("���Ͻô� ��ȣ�� �����ϼ���.");
			System.out.println(">>> 1.ȸ�� ����   2.ȸ�� ���� ����   3.ȸ�� ���� ����   4.ȸ�� ���� ���   5.ȸ�� �˻�");
			System.out.println();
			select = Integer.parseInt(br.readLine());

			////////////// ���� //////////////
			switch (select) {
			// insert ������ �Է��ϼ���, ������ �Է��ϼ���, �ۼ��ڸ� �Է��ϼ���, �ۼ����ڴ� �ý��� �ð�����
			case 1: {
				int i = 0;
				vo.setNum(++i);
				
				System.out.println("���̵� �Է��ϼ���.");
				vo.setId(br.readLine());

				System.out.println("�н����带 �Է��ϼ���.");
				vo.setPw(br.readLine());

				System.out.println("�̸��� �Է��ϼ���.");
				vo.setName(br.readLine());

				System.out.println("��ȭ ��ȣ�� �Է��ϼ���");
				vo.setTel(br.readLine());
				
				

				// ��� ���
				dao.insert(vo);

				// �������� ����
				break;

			} // end of case 1

			// update
			case 2: {
				System.out.println("������ ��ȣ�� �Է��ϼ���");
				vo.setNum(Integer.parseInt(br.readLine()));

				System.out.println("������ ���̵� �Է��ϼ���.");
				vo.setId(br.readLine());

				System.out.println("������ �н����带 �Է��ϼ���.");
				vo.setPw(br.readLine());

				System.out.println("������ �̸��� �Է��ϼ���.");
				vo.setName(br.readLine());

				System.out.println("������ ��ȭ ��ȣ�� �Է��ϼ���");
				vo.setTel(br.readLine());
				
				

				// ��� ���
				dao.update(vo);
				break;

			} // end of case 2

			// delete
			case 3: {
				System.out.println("������ ȸ���� ��ȣ�� �Է��ϼ���");
				vo.setNum(Integer.parseInt(br.readLine()));

				// ��� ���
				dao.delete(vo);
				break;

			} // end of case 3

			// selectAll
			case 4: {
				dao.selectAll();
				MemberVO[] mArr = dao.selectAll();

				// ��� ���
				for (int i = 0; i < mArr.length; i++) {
					System.out.println();
					System.out.println("---------------------------------------------------");
					System.out.print(mArr[i].getNum() + "  ");
					System.out.print(mArr[i].getId() + "\t");
					System.out.print(mArr[i].getPw() + "\t");
					System.out.print(mArr[i].getName() + "\t");
					System.out.print(mArr[i].getTel() + "\t");
				}
				System.out.println("\n");

				// ���� ����
				break;

			} // end of case 4

			// selectOne
			case 5: {
				System.out.println("�˻��� ȸ���� ��ȣ�� �Է��ϼ���");
				vo.setNum(Integer.parseInt(br.readLine()));

				// ��� ���
				dao.selectOne(vo);

			} // end of case 5

			} // end of switch

		} // end of while
	}

}
