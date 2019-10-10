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
			System.out.println("박보검 팬카페에 오신 것을 환영합니다.");
			System.out.println("1.글쓰기	2.글수정	3.글삭제	4.글목록	5.글검색");
			String select = "";

			try {
				select = br.readLine();

				switch (select) {
				case "1": {

					// insert
					try {
						System.out.println("제목을 입력하세요.");
						bvo.setTitle(br.readLine());

						System.out.println("내용을 입력하세요.");
						bvo.setContent(br.readLine());

						System.out.println("이름을 입력하세요.");
						bvo.setWriter(br.readLine());

						bDAO.insert(bvo);

						System.out.println("-----insert 성공");
					} catch (IOException e) {
						System.out.println("-----insert 실패");
						e.printStackTrace();
					}
					break;
				} // case 1

				case "2": {

					// update
					try {
						Test03BoardVO bvo2 = new Test03BoardVO();
						System.out.println("수정할 글번호를 입력하세요.");
						bvo2.setNum(Integer.parseInt(br.readLine()));

						System.out.println("수정할 제목을 입력하세요.");
						bvo2.setTitle(br.readLine());

						System.out.println("내용을 입력하세요.");
						bvo2.setContent(br.readLine());

						System.out.println("이름을 입력하세요.");
						bvo2.setWriter(br.readLine());

						bDAO.update(bvo2);
						System.out.println("-----update 성공");

					} catch (IOException e) {
						System.out.println("-----update 실패");
						e.printStackTrace();
					}
					break;
				} // case 2

				case "3": {

					// delete
					System.out.println("삭제할 글번호를 입력하세요.");
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
					System.out.println("--- 게시판 목록 ---");
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
					System.out.println("검색할 글번호를 입력하세요.");
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
					System.out.println("종료하시려면 x를 누르세요\n");
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
