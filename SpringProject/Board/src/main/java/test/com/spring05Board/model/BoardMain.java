package test.com.spring05Board.model;

import java.util.Date;

public class BoardMain {
	public static void main(String[] args) {
		
		// 1.insert
		/*BoardVO vo = new BoardVO();
		vo.setNum(1);
		vo.setTitle("제목입니다");
		vo.setContent("내용입니다");
		vo.setWriter("작성자입니다");
		vo.setReg_Date(new Date());
		BoardDAO dao = new BoardDAOimpl();
		dao.insert(vo);*/
		
		// 2.delete
		/*BoardVO vo = new BoardVO();
		vo.setNum(63);
		BoardDAO dao = new BoardDAOimpl();
		int result = dao.delete(vo);
		
		if(result == 1) {
			System.out.println("delete 성공");
			
		}else {
			System.out.println("delete 실패");
		}*/
		
		// 3.update
		/*BoardVO vo = new BoardVO();
		vo.setNum(42);
		vo.setTitle("update test");
		vo.setContent("test");
		vo.setWriter("test");
		BoardDAO dao = new BoardDAOimpl();
		dao.update(vo);*/
		
		
	}	// end of main

}	// end of class
