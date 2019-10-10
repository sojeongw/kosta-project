package test.com.model;

import java.util.List;

import test.com.view.SelectPage;

public class BoardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 이 프로젝트가 잘 돌아가는지 확인
		System.out.println("board");
		
		// 합칠 때 따로따로 불러오자. 한꺼번에 불러오면 망하는 것.
		// 하나씩 되는지 확인하면서 가져오자.
		// 보통 모델부터 하는 게 좋다. 클래스 다이어그램이 금방 나오기 때문.
		// 클래스 다이어그램을 꺼내놓고 그걸 보면서 뭐부터 테스트 할까?
		// VO먼저 할까? VO 만들자 하는 것
		
		// 1.insert
		//BoardVO vo = new BoardVO();
		// num은 이제 할 필요 없음
		//vo.setTitle("title");
		//vo.setContent("content");
		//vo.setWriter("kim");
		
		// 이제 get set으로 잘 됐는지 확인해볼 수 있다		
//		System.out.println(vo.getTitle());
//		System.out.println(vo.getContent());
//		System.out.println(vo.getWriter());
//		System.out.println(vo.getRegDate());
		// 테스트 끝나면 없앤다
		
		// DAO를 만든다
		// impl을 만든다
		//BoardDAO dao = new BoardDAOimpl();
		//int result = dao.insert(vo);	// 리턴 받겠다.
		
		// insert page를 가져온다
		// 이때 select를 안 가져왔다고 에러나서 select를 불러오면 계속 고쳐야 되니까
		// 일단 insert만 확인하기 위해 주석처리 해둔다.
		// 이젠 위에 있는 애들을 실행할 게 아니라 
//		new InsertPage(); // 를 실행해준다. 위는 다 주석처리 한다.
		
		// 위에서 테스트 완료된 부분들을 버튼이 누를 때 나오도록 복사해서 insertpage에 가져간다.
		
		// 이제 select
		new SelectPage();
		
		// select() 테스트
//		BoardDAO dao = new BoardDAOimpl();
//		List<BoardVO> list = dao.selectAll();
//		System.out.println(list.size());
//		for(int i=0; i<list.size(); i++) {
//			System.out.print(list.get(i).getNum() + " ");
//			System.out.print(list.get(i).getTitle() + " ");
//			System.out.print(list.get(i).getContent() + " ");
//			System.out.print(list.get(i).getWriter() + " ");
//			System.out.println(list.get(i).getRegDate() + " ");
//		}
		// 테스트 다 됐으면 주석으로 처리하고 select page로 옮긴다. 그리고 selectpage 생성자를 여기에 불러온다.
		new SelectPage();
		
	}

}
