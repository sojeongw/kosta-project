package assignment.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

public class Asm01BoardMain {

	public static void main(String[] args) throws IOException {

		// 시스템 입력
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// 초기화
		int select;

		String title = "";
		String content = "";
		String name = "";
		Date date;
		int num = 0;

		// 초기화 입력
		Asm01BoardVO bVO = new Asm01BoardVO();
//		bVO.setNum(1);
//		bVO.setTitle("소정아 나랑 결혼해줄래?");
//		bVO.setContent("널 사랑해");
//		bVO.setName("서강준");
//		bVO.setDate(new Date());

		// 
		// System.out.println(bVO.getNum());
		// System.out.println(bVO.getTitle());
		// System.out.println(bVO.getContent());
		// System.out.println(bVO.getName());
		// System.out.println(bVO.getDate());

		Asm01BoardDAO bDAO = new Asm01BoardDAO();

		while (true) {
			
			//////////// 메뉴 선택 ////////////
			System.out.println("원하시는 항목을 입력해주세요.");
			System.out.println(">>> 1.글쓰기 2.글수정 3.글삭제 4.글목록 5.글검색");
			System.out.println();
			select = Integer.parseInt(br.readLine());

			////////////// 반복문//////////////
			switch (select) {
			case 1: {
				int i = 0;
				bVO.setNum(++i);
				System.out.println("제목을 입력해주세요.");
				bVO.setTitle(br.readLine());

				System.out.println("내용을 입력해주세요.");
				bVO.setContent(br.readLine());

				System.out.println("이름을 입력해주세요.");
				bVO.setName(br.readLine());

			
				bVO.setDate(new Date());	

				
				bDAO.insert(bVO);
				
			
				break;	
				
			} // end of case 1

			// update
			case 2: {
				System.out.println("수정할 번호를 입력해주세요");
				bVO.setNum(Integer.parseInt(br.readLine()));
				
				System.out.println("수정할 제목을 입력해주세요");
				bVO.setTitle(br.readLine());
				
				System.out.println("수정할 내용을 입력해주세요");
				bVO.setContent(br.readLine());
				
				System.out.println("수정할 이름을 입력해주세요");
				bVO.setName(br.readLine());
				
				
				bVO.setDate(new Date());
				
			
				bDAO.update(bVO);
				break;
			} // end of case 2

			// delete
			case 3: {
				System.out.println("삭제할 번호를 선택해주세요");
				bVO.setNum(Integer.parseInt(br.readLine()));
				
			
				bDAO.delete(bVO);
				break;
			} // end of case 3

			// selectAll
			case 4: {
				bDAO.selectAll();
				Asm01BoardVO[] bArr = bDAO.selectAll();
				
		
				for(int i=0; i<bArr.length; i++) {
					System.out.println("---------------------------------------------------");
					System.out.print(bArr[i].getNum() + "  ");
					System.out.print(bArr[i].getTitle() + "\t");
					System.out.print(bArr[i].getContent() + "\t");
					System.out.print(bArr[i].getName());
					System.out.println("\t" + bArr[i].getDate());
					//배열 넣을 때도 시스템 시간이니까 여기서 굳이 안 해도 된다.
					
				}
				System.out.println();
				

				break;
				
			} // end of case 4

			// selectOne
			case 5: {
				System.out.println("글 번호를 선택해주세요");
				bVO.setNum(Integer.parseInt(br.readLine()));
				
			
				bDAO.selectOne(bVO);

			} // end of case 5
			} // end of switch
		} // end of while

	} // end of main

} // end of class
