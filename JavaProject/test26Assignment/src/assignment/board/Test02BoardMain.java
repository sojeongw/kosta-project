package assignment.board;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test02BoardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 주어진 Test02BoardDAO interface를
		// 상속받는 클래스(Test02BoardDAOimpl)를 구현하고
		// 각 메소드들을 콜하고 출력하시오
		// 조건 : Test02BoardDAOimple 객체를 직접 생성하지 말 것 = 다형성 이용
		
		
		Test02BoardDAO dao = new Test02BoardDAOimpl();
		Test02BoardVO vo = new Test02BoardVO();
		
		
		///// 1. insert
		
		vo.setNum(1);
		vo.setTitle("1번 제목");
		vo.setContent("1번 내용");
		vo.setName("1번 이름");
		dao.insert(vo);
		
		vo.setNum(2);
		vo.setTitle("2번 제목");
		vo.setContent("2번 내용");
		vo.setName("2번 이름");
		dao.insert(vo);
		
		vo.setNum(3);
		vo.setTitle("3번 제목");
		vo.setContent("3번 내용");
		vo.setName("3번 이름");
		dao.insert(vo);
	
		
		///// 2. update
		Test02BoardVO vo2 = new Test02BoardVO();
		vo2.setNum(1);
		vo2.setTitle("1번 수정");
		vo2.setContent("1번 수정");
		vo2.setName("1번 수정");
		dao.update(vo2);

		///// 3. delete
		vo.setNum(2);
		dao.delete(vo);
		
		///// 4. selectOne
		vo.setNum(2);
		dao.selectOne(vo);
		
		
		///// 5. select all
		List<Test02BoardVO> list = dao.selectAll();
		
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
		for(Test02BoardVO x : list) {
			System.out.print(x.getNum() + "\t");
			System.out.print(x.getTitle()+ "\t");
			System.out.print(x.getContent() + "\t");
			System.out.print(x.getDate() + "\t");
			System.out.println("");
		}

		
		
	}		// end of main
	
}		// end of class
