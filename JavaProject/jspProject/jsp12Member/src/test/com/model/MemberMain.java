package test.com.model;

import java.util.ArrayList;
import java.util.List;

public class MemberMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1.insert
	/*	MemberVO vo = new MemberVO();
		vo.setNum(1);
		vo.setId("test id");
		vo.setPw("test pw");
		vo.setName("test name");
		vo.setTel("011");
		
		MemberDAO dao = new MemberDAOimpl();
		int result = dao.insert(vo);
		
		if(result == 1) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}*/
		
		// 2. selectAll
		/*MemberDAO dao = new MemberDAOimpl();
		MemberVO vo = new MemberVO();

		List<MemberVO> list = dao.selectAll();
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getNum());
			System.out.println(list.get(i).getId());
			System.out.println(list.get(i).getPw());
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getTel());
		}*/
		
		// 3.delete
		/*MemberVO vo = new MemberVO();
		vo.setNum(63);
		MemberDAO dao = new MemberDAOimpl();
		int result = dao.delete(vo);
		if(result==1) {
			System.out.println("delete 성공");
		} else {
			System.out.println("delete 실패");
		}*/
		
		// 4.selectOne
		/*MemberVO vo = new MemberVO();
		vo.setNum(82);
		
		MemberDAO dao = new MemberDAOimpl();
		MemberVO mvo = dao.selectOne(vo);
		System.out.println(mvo.getNum());
		System.out.println(mvo.getId());
		System.out.println(mvo.getPw());
		System.out.println(mvo.getName());
		System.out.println(mvo.getTel());*/
		
		// 5.update
		/*MemberVO vo = new MemberVO();
		vo.setNum(41);
		vo.setId("update test");
		vo.setPw("hi123456");
		vo.setName("sojeong");
		vo.setTel("019");
		
		MemberDAO dao = new MemberDAOimpl();
		int result = dao.update(vo);*/
		
		
	}

}
