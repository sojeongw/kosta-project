package assignment.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StudentMain {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
			// �ý��� �Է� ����
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			// ������ ��ȣ
			int select;


			// �ʱⰪ ����
			StudentVO vo = new StudentVO();
//			
			StudentDAO dao = new StudentDAOimpl();

			while (true) {

				//////////// ���� ���� ////////////
				System.out.println("���Ͻô� ��ȣ�� �����ϼ���.");
				System.out.println(">>> 1.���� �Է�   2.���� ����   3.���� ����   4.���� ���   5.���� �˻�");
				System.out.println();
				select = Integer.parseInt(br.readLine());

				////////////// ���� //////////////
				switch (select) {
				// insert ������ �Է��ϼ���, ������ �Է��ϼ���, �ۼ��ڸ� �Է��ϼ���, �ۼ����ڴ� �ý��� �ð�����
				case 1: {
					int i = 0;
					vo.setNum(++i);
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
					StudentVO[] sArr = dao.selectAll();

					// ��� ���
					for (int i = 0; i < sArr.length; i++) {
						System.out.println();
						System.out.println("---------------------------------------------------");
						System.out.print(sArr[i].getNum() + "  ");
						System.out.print(sArr[i].getName() + "\t");
						System.out.print(sArr[i].getKor() + "\t");
						System.out.print(sArr[i].getEng() + "\t");
						System.out.print(sArr[i].getMath() + "\t");
						System.out.print(sArr[i].getTotal() + "\t");
						System.out.print(sArr[i].getAvg() + "\t");
						System.out.print(sArr[i].getGrade() + "\t");
						
					}
					System.out.println("\n");

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

			} // end of while

	}	// end of main
			
}	// end of class

