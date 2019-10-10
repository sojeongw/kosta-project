package test.com;

import java.util.Date;

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
		vo.setTitle("1번 제목");
		vo.setContent("1번 내용");
		vo.setName("1번 이름");
		dao.insert(vo);
		
		vo.setTitle("2번 제목");
		vo.setContent("2번 내용");
		vo.setName("2번 이름");
//		dao.insert(vo);
		
	
		
		
		
		///// 2. update
		vo.setNum(2);
		vo.setTitle("2번 제목 수정");
		vo.setContent("2번 내용 수정");
		vo.setName("2번 이름 수정");
		dao.update(vo);

		///// 3. delete
		vo.setNum(2);
		dao.delete(vo);
		
		///// 4. selectOne
		vo.setNum(2);
		dao.selectOne(vo);
		
		
		///// 5. select all
		Test02BoardVO[] vos = dao.selectAll();
		for(int i=0; i<vos.length; i++) {
			System.out.print(vos[i].getNum() + "\t");
			System.out.print(vos[i].getTitle() + "\t");
			System.out.print(vos[i].getContent() + "\t");
			System.out.print(vos[i].getName() + "\t");
			System.out.print(vos[i].getDate() + "\n");
		}
		
		
	}		// end of main
	
}		// end of class
