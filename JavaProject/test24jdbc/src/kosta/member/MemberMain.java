package kosta.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MemberMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		MemberDAOimpl dao = new MemberDAOimpl();
		MemberVO vo = new MemberVO();
		
		String exit = "";
		
		do {
			String select = "";
			
			System.out.println("���Ͻô� �޴��� �����ϼ���");
			System.out.println("1.ȸ������	2.ȸ����������	3.ȸ����������	4.ȸ���˻�	5.ȸ�����");
			
			try {
				select = br.readLine();
				
				if(select.equals("1")) {
					// 1.insert
					System.out.println("id�� �Է��ϼ���");
					vo.setId(br.readLine());
					
					System.out.println("pw�� �Է��ϼ���");
					vo.setPw(br.readLine());
					
					System.out.println("�̸��� �Է��ϼ���");
					vo.setName(br.readLine());
					
					System.out.println("��ȣ�� �Է��ϼ���");
					vo.setTel(br.readLine());
					dao.insert(vo);
					
				} else if(select.equals("2")) {
					// 2.update
					System.out.println("������ ��ȣ�� �Է��ϼ���");
					vo.setNum(Integer.parseInt(br.readLine()));
					
					System.out.println("������ id�� �Է��ϼ���");
					vo.setId(br.readLine());
					
					System.out.println("������ pw�� �Է��ϼ���");
					vo.setPw(br.readLine());
					
					System.out.println("������ �̸��� �Է��ϼ���");
					vo.setName(br.readLine());
					
					System.out.println("������ ��ȣ�� �Է��ϼ���");
					vo.setTel(br.readLine());
					
					dao.update(vo);
					
				} else if(select.equals("3")) {
					// 3.delete
					System.out.println("������ ��ȣ�� �Է��ϼ���");
					vo.setNum(Integer.parseInt(br.readLine()));
					
					dao.delete(vo);
					
				} else if(select.equals("4")) {
					// 4.selectOne
					System.out.println("�˻��� �� ��ȣ�� �Է��ϼ���");
					vo.setNum(Integer.parseInt(br.readLine()));
					
					dao.selectOne(vo);
					
				} else if(select.equals("5")) {
					// 5.selectAll
					dao.selectAll();
				}	// end of if
			} catch (IOException e1) {
				System.out.println("�޴��� ����� �������ּ���");
				e1.printStackTrace();
			}
			
			try {
				System.out.println("�����Ϸ��� x�� �Է��ϼ���.");
				exit = br.readLine();
			} catch (IOException e) {
				System.out.println("�߸��� �Է��Դϴ�.");
				e.printStackTrace();
			}
		}while(exit != "x");
		

		

		



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		// �ý��� �Է� ����
//		InputStream is = System.in;
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
//
//		// ������ ��ȣ
//		int select;
//
//
//		// �ʱⰪ ����
//		MemberVO vo = new MemberVO();
//
//	
//
//		MemberDAO dao = new MemberDAOimpl();
//
//		while (true) {
//
//			//////////// ���� ���� ////////////
//			System.out.println("���Ͻô� ��ȣ�� �����ϼ���.");
//			System.out.println(">>> 1.ȸ�� ����   2.ȸ�� ���� ����   3.ȸ�� ���� ����   4.ȸ�� ���� ���   5.ȸ�� �˻�");
//			System.out.println();
//			select = Integer.parseInt(br.readLine());
//
//			////////////// ���� //////////////
//			switch (select) {
//			// insert ������ �Է��ϼ���, ������ �Է��ϼ���, �ۼ��ڸ� �Է��ϼ���, �ۼ����ڴ� �ý��� �ð�����
//			case 1: {
//				int i = 0;
//				MemberVO vo2 = new MemberVO();
//				vo2.setNum(++i);
//				
//				System.out.println("���̵� �Է��ϼ���.");
//				vo2.setId(br.readLine());
//
//				System.out.println("�н����带 �Է��ϼ���.");
//				vo2.setPw(br.readLine());
//
//				System.out.println("�̸��� �Է��ϼ���.");
//				vo2.setName(br.readLine());
//
//				System.out.println("��ȭ ��ȣ�� �Է��ϼ���");
//				vo2.setTel(br.readLine());
//				
//				
//
//				// ��� ���
//				dao.insert(vo2);
//
//				// �������� ����
//				break;
//
//			} // end of case 1
//
//			// update
//			case 2: {
//				System.out.println("������ ��ȣ�� �Է��ϼ���");
//				vo.setNum(Integer.parseInt(br.readLine()));
//
//				System.out.println("������ ���̵� �Է��ϼ���.");
//				vo.setId(br.readLine());
//
//				System.out.println("������ �н����带 �Է��ϼ���.");
//				vo.setPw(br.readLine());
//
//				System.out.println("������ �̸��� �Է��ϼ���.");
//				vo.setName(br.readLine());
//
//				System.out.println("������ ��ȭ ��ȣ�� �Է��ϼ���");
//				vo.setTel(br.readLine());
//				
//				
//
//				// ��� ���
//				dao.update(vo);
//				break;
//
//			} // end of case 2
//
//			// delete
//			case 3: {
//				System.out.println("������ ȸ���� ��ȣ�� �Է��ϼ���");
//				vo.setNum(Integer.parseInt(br.readLine()));
//
//				// ��� ���
//				dao.delete(vo);
//				break;
//
//			} // end of case 3
//
//			// selectAll
//			case 4: {
//				List<MemberVO> list = dao.selectAll();
//
//				// ��� ���
//				for (MemberVO vos : list) {
//					System.out.print(vos.getNum() + "  ");
//					System.out.print(vos.getId() + "\t");
//					System.out.print(vos.getPw() + "\t");
//					System.out.print(vos.getName() + "\t");
//					System.out.print(vos.getTel() + "\n");
//				}
//				
//
//				// ���� ����
//				break;
//
//			} // end of case 4
//
//			// selectOne
//			case 5: {
//				System.out.println("�˻��� ȸ���� ��ȣ�� �Է��ϼ���");
//				vo.setNum(Integer.parseInt(br.readLine()));
//
//				// ��� ���
//				dao.selectOne(vo);
//
//			} // end of case 5
//
//			} // end of switch
//
//		} // end of while
	}	// end of main

}	// end of class
