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
		System.out.println("\t\t방정보");

		while (!roopKey.equals("X")) {
			System.out.println("==================================");
			System.out.println("1.방정보입력  2.방정보수정  3.방정보삭제\n4.전체방정보 5.방정보검색 ");
			System.out.println("==================================");
			choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				vo = new RoomVO();
				try {
					System.out.println("방을 추가합니다.");
					System.out.println("방번호를 입력하세요.");
					vo.setR_num(Integer.parseInt(br.readLine()));
					System.out.print("방이름을 입력하세요 : ");
					vo.setR_name(br.readLine());
					System.out.print("창문의 수를 입력하세요 : ");
					vo.setWindow_cnt(Integer.parseInt(br.readLine()));
					System.out.print("문의 수를 입력하세요 : ");
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
					System.out.println("방을 수정합니다.");
					System.out.println("수정할 방 번호를 입력하세요");
					vo.setR_num(Integer.parseInt(br.readLine()));
					System.out.print("방이름을 입력하세요 : ");
					vo.setR_name(br.readLine());
					System.out.print("창문의 수를 입력하세요 : ");
					vo.setWindow_cnt(Integer.parseInt(br.readLine()));
					System.out.print("문의 수를 입력하세요 : ");
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
				System.out.println("삭제할 방의 번호를 입력하시오.");
				try {
					num = Integer.parseInt(br.readLine());
				} catch (IOException e) {
					System.out.println("IO Error");
					e.printStackTrace();
				}
				bDAO.delete(num);
				break;
			case 4:
				System.out.println("전체 방 리스트를 출력합니다.");
				list = bDAO.selectAll();
				for (int i = 0; i < list.size(); i++) {
					RoomVO temp = list.get(i);
					temp.printRoom();
				}
				break;

			case 5:
				vo = new RoomVO();
				try {
					System.out.println("검색할 글의 번호를 입력하시오.");
					vo.setR_num(Integer.parseInt(br.readLine()));
				} catch (IOException e) {
					System.out.println("IO Error");
					e.printStackTrace();
				}
				bDAO.selectOne(vo).printRoom();
				break;

			default:
				System.out.println("잘못된 번호를 입력하셨습니다.");
				break;
			}

			System.out.println("종료하려면 X를 입력하세요. 계속진행하려면 아무키나 누르세요.");
			roopKey = br.readLine();
			if (roopKey.equals("X")) {
				System.out.println("보안 프로그램을 종료합니다.");
			}
		}

	}

}