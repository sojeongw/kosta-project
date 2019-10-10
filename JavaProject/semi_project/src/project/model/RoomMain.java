package project.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import project.control.RoomCtrl;
import project.control.RoomCtrlImpl;

import java.util.ArrayList;

public class RoomMain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.out.println("Homework");

		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String roopKey = "A";
		int choice = 0;
		List<RoomVO> list = new ArrayList<RoomVO>();
		RoomDAO bDAO = new RoomDAOimpl();
		//RoomCtrl rCon = new RoomCtrlImpl();
		RoomVO vo;
		//try {
		//rCon.RandomFire();
		//int num = rCon.FireDetect();
		//rCon.FireAction(num);
		//System.out.println(num);
		//} catch(Exception e) {
		//	e.printStackTrace();
		//}
		System.out.println("==================================");
		System.out.println("\t\t������");

		while (!roopKey.equals("X")) {
			System.out.println("==================================");
			System.out.println("1.�������Է�  2.����������  3.����������\n4.��ü������ 5.�������˻� ");
			System.out.println("==================================");
			choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				vo = new RoomVO();
				try {
					System.out.println("���� �߰��մϴ�.");
					System.out.println("���ȣ�� �Է��ϼ���.");
					vo.setR_num(Integer.parseInt(br.readLine()));
					System.out.print("���̸��� �Է��ϼ��� : ");
					vo.setR_name(br.readLine());
					System.out.print("â���� ���� �Է��ϼ��� : ");
					vo.setWindow_cnt(Integer.parseInt(br.readLine()));
					System.out.print("���� ���� �Է��ϼ��� : ");
					vo.setDoor_cnt(Integer.parseInt(br.readLine()));
					vo.setFire(0);
				} catch (IOException e) {
					System.out.println("IO Error");
					e.printStackTrace();
				}
				bDAO.insert(vo);
				break;
			case 2:
				vo = new RoomVO();
				try {
					System.out.println("���� �����մϴ�.");
					System.out.println("������ �� ��ȣ�� �Է��ϼ���");
					vo.setR_num(Integer.parseInt(br.readLine()));
					System.out.print("���̸��� �Է��ϼ��� : ");
					vo.setR_name(br.readLine());
					System.out.print("â���� ���� �Է��ϼ��� : ");
					vo.setWindow_cnt(Integer.parseInt(br.readLine()));
					System.out.print("���� ���� �Է��ϼ��� : ");
					vo.setDoor_cnt(Integer.parseInt(br.readLine()));
					vo.setFire(0);
				} catch (IOException e) {
					System.out.println("IO Error");
					e.printStackTrace();
				}
				bDAO.update(vo);
				break;
			case 3:
				int num = 0;
				System.out.println("������ ���� ��ȣ�� �Է��Ͻÿ�.");
				try {
					num = Integer.parseInt(br.readLine());
				} catch (IOException e) {
					System.out.println("IO Error");
					e.printStackTrace();
				}
				bDAO.delete(num);
				break;
			case 4:
				System.out.println("��ü �� ����Ʈ�� ����մϴ�.");
				list = bDAO.selectAll();
				for (int i = 0; i < list.size(); i++) {
					RoomVO temp = list.get(i);
					temp.printRoom();
				}
				break;

			case 5:
				vo = new RoomVO();
				try {
					System.out.println("�˻��� ���� ��ȣ�� �Է��Ͻÿ�.");
					vo.setR_num(Integer.parseInt(br.readLine()));
				} catch (IOException e) {
					System.out.println("IO Error");
					e.printStackTrace();
				}
				bDAO.selectOne(vo).printRoom();
				break;

			default:
				System.out.println("�߸��� ��ȣ�� �Է��ϼ̽��ϴ�.");
				break;
			}

			System.out.println("�����Ϸ��� X�� �Է��ϼ���. ��������Ϸ��� �ƹ�Ű�� ��������.");
			roopKey = br.readLine();
			if (roopKey.equals("X")) {
				System.out.println("���� ���α׷��� �����մϴ�.");
			}
		}

	}

}