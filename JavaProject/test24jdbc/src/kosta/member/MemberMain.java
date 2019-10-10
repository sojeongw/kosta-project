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
			
			System.out.println("원하시는 메뉴를 선택하세요");
			System.out.println("1.회원가입	2.회원정보수정	3.회원정보삭제	4.회원검색	5.회원목록");
			
			try {
				select = br.readLine();
				
				if(select.equals("1")) {
					// 1.insert
					System.out.println("id를 입력하세요");
					vo.setId(br.readLine());
					
					System.out.println("pw를 입력하세요");
					vo.setPw(br.readLine());
					
					System.out.println("이름을 입력하세요");
					vo.setName(br.readLine());
					
					System.out.println("번호를 입력하세요");
					vo.setTel(br.readLine());
					dao.insert(vo);
					
				} else if(select.equals("2")) {
					// 2.update
					System.out.println("수정할 번호를 입력하세요");
					vo.setNum(Integer.parseInt(br.readLine()));
					
					System.out.println("수정할 id를 입력하세요");
					vo.setId(br.readLine());
					
					System.out.println("수정할 pw를 입력하세요");
					vo.setPw(br.readLine());
					
					System.out.println("수정할 이름을 입력하세요");
					vo.setName(br.readLine());
					
					System.out.println("수정할 번호를 입력하세요");
					vo.setTel(br.readLine());
					
					dao.update(vo);
					
				} else if(select.equals("3")) {
					// 3.delete
					System.out.println("삭제할 번호를 입력하세요");
					vo.setNum(Integer.parseInt(br.readLine()));
					
					dao.delete(vo);
					
				} else if(select.equals("4")) {
					// 4.selectOne
					System.out.println("검색할 글 번호를 입력하세요");
					vo.setNum(Integer.parseInt(br.readLine()));
					
					dao.selectOne(vo);
					
				} else if(select.equals("5")) {
					// 5.selectAll
					dao.selectAll();
				}	// end of if
			} catch (IOException e1) {
				System.out.println("메뉴를 제대로 선택해주세요");
				e1.printStackTrace();
			}
			
			try {
				System.out.println("종료하려면 x를 입력하세요.");
				exit = br.readLine();
			} catch (IOException e) {
				System.out.println("잘못된 입력입니다.");
				e.printStackTrace();
			}
		}while(exit != "x");
		

		

		



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		// 시스템 입력 설정
//		InputStream is = System.in;
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
//
//		// 선택할 번호
//		int select;
//
//
//		// 초기값 세팅
//		MemberVO vo = new MemberVO();
//
//	
//
//		MemberDAO dao = new MemberDAOimpl();
//
//		while (true) {
//
//			//////////// 질문 선택 ////////////
//			System.out.println("원하시는 번호를 선택하세요.");
//			System.out.println(">>> 1.회원 가입   2.회원 정보 수정   3.회원 정보 삭제   4.회원 정보 목록   5.회원 검색");
//			System.out.println();
//			select = Integer.parseInt(br.readLine());
//
//			////////////// 실행 //////////////
//			switch (select) {
//			// insert 제목을 입력하세요, 내용을 입력하세요, 작성자를 입력하세요, 작성일자는 시스템 시간으로
//			case 1: {
//				int i = 0;
//				MemberVO vo2 = new MemberVO();
//				vo2.setNum(++i);
//				
//				System.out.println("아이디를 입력하세요.");
//				vo2.setId(br.readLine());
//
//				System.out.println("패스워드를 입력하세요.");
//				vo2.setPw(br.readLine());
//
//				System.out.println("이름을 입력하세요.");
//				vo2.setName(br.readLine());
//
//				System.out.println("전화 번호를 입력하세요");
//				vo2.setTel(br.readLine());
//				
//				
//
//				// 결과 출력
//				dao.insert(vo2);
//
//				// 질문으로 복귀
//				break;
//
//			} // end of case 1
//
//			// update
//			case 2: {
//				System.out.println("수정할 번호를 입력하세요");
//				vo.setNum(Integer.parseInt(br.readLine()));
//
//				System.out.println("수정할 아이디를 입력하세요.");
//				vo.setId(br.readLine());
//
//				System.out.println("수정할 패스워드를 입력하세요.");
//				vo.setPw(br.readLine());
//
//				System.out.println("수정할 이름을 입력하세요.");
//				vo.setName(br.readLine());
//
//				System.out.println("수정할 전화 번호를 입력하세요");
//				vo.setTel(br.readLine());
//				
//				
//
//				// 결과 출력
//				dao.update(vo);
//				break;
//
//			} // end of case 2
//
//			// delete
//			case 3: {
//				System.out.println("삭제할 회원의 번호를 입력하세요");
//				vo.setNum(Integer.parseInt(br.readLine()));
//
//				// 결과 출력
//				dao.delete(vo);
//				break;
//
//			} // end of case 3
//
//			// selectAll
//			case 4: {
//				List<MemberVO> list = dao.selectAll();
//
//				// 결과 출력
//				for (MemberVO vos : list) {
//					System.out.print(vos.getNum() + "  ");
//					System.out.print(vos.getId() + "\t");
//					System.out.print(vos.getPw() + "\t");
//					System.out.print(vos.getName() + "\t");
//					System.out.print(vos.getTel() + "\n");
//				}
//				
//
//				// 질문 복귀
//				break;
//
//			} // end of case 4
//
//			// selectOne
//			case 5: {
//				System.out.println("검색할 회원의 번호를 입력하세요");
//				vo.setNum(Integer.parseInt(br.readLine()));
//
//				// 결과 출력
//				dao.selectOne(vo);
//
//			} // end of case 5
//
//			} // end of switch
//
//		} // end of while
	}	// end of main

}	// end of class
