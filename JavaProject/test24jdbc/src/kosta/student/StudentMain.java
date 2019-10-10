package kosta.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class StudentMain {

	public static void main(String[] args) {

		StudentDAO dao = new StudentDAOimpl();
		StudentVO vo = new StudentVO();

		// �ý��� �Է� ����
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// ������ ��ȣ
		int select;

		while (true) {

			//////////// ���� ���� ////////////
			System.out.println("���Ͻô� ��ȣ�� �����ϼ���.");
			System.out.println(">>> 1.���� �Է�   2.���� ����   3.���� ����   4.���� ���   5.���� �˻�");
			System.out.println();
			try {
				select = Integer.parseInt(br.readLine());

				////////////// ���� //////////////
				switch (select) {
				// insert ������ �Է��ϼ���, ������ �Է��ϼ���, �ۼ��ڸ� �Է��ϼ���, �ۼ����ڴ� �ý��� �ð�����
				case 1: {
					
					// vo.setNum(++i);
					
					System.out.println("�̸��� �Է��ϼ���.");
					vo.setName(br.readLine());

					System.out.println("���� ������ �Է��ϼ���.");
					vo.setKor(Integer.parseInt(br.readLine()));

					System.out.println("���� ������ �Է��ϼ���.");
					vo.setEng(Integer.parseInt(br.readLine()));

					System.out.println("���� ������ �Է��ϼ���");
					vo.setMath(Integer.parseInt(br.readLine()));

					vo.setTotal(vo.getKor() + vo.getEng() + vo.getMath());
					vo.setAvg((double) vo.getTotal() / 3);

					String grade = "";
					if (vo.getAvg() >= 90) {
						grade = "A";
					} else if (vo.getAvg() >= 80) {
						grade = "B";
					} else if (vo.getAvg() >= 70) {
						grade = "C";
					} else {
						grade = "D";
					}
					vo.setGrade(grade);

					// ��� ���
					dao.insert(vo);

					// �������� ����
					break;

				} // end of case 1

				// update
				case 2: {
					System.out.println("������ ��ȣ�� �Է��ϼ���");
					vo.setNum(Integer.parseInt(br.readLine()));

					System.out.println("������ ���� ������ �Է��ϼ���");
					vo.setKor(Integer.parseInt(br.readLine()));

					System.out.println("������ ���� ������ �Է��ϼ���");
					vo.setEng(Integer.parseInt(br.readLine()));

					System.out.println("������ ���� ������ �Է��ϼ���");
					vo.setMath(Integer.parseInt(br.readLine()));

					vo.setTotal(vo.getKor() + vo.getEng() + vo.getMath());
					vo.setAvg((double) vo.getTotal() / 3);

					String grade = "";
					if (vo.getAvg() >= 90) {
						grade = "A";
					} else if (vo.getAvg() >= 80) {
						grade = "B";
					} else if (vo.getAvg() >= 70) {
						grade = "C";
					} else {
						grade = "D";
					}
					vo.setGrade(grade);

					// ��� ���
					dao.update(vo);
					break;

				} // end of case 2

				// delete
				case 3: {
					System.out.println("������ �л��� ��ȣ�� �Է��ϼ���");
					vo.setNum(Integer.parseInt(br.readLine()));

					// ��� ���
					dao.delete(vo);
					break;

				} // end of case 3

				// selectAll
				case 4: {
					dao.selectAll();
					

					// ���� ����
					break;

				} // end of case 4

				// selectOne
				case 5: {
					
					System.out.println("�˻��� �л��� ��ȣ�� �Է��ϼ���");
					vo.setNum(Integer.parseInt(br.readLine()));
					
					// ��� ���
					dao.selectOne(vo);
					

				} // end of case 5

				} // end of switch
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("�߸��� �Է��Դϴ�.");
				e.printStackTrace();
			}

		} // end of while

	} // end of main

} // end of class
