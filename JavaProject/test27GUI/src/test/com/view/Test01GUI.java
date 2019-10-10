package test.com.view;

import javax.swing.JTextField;

import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;

public class Test01GUI {
	
	public static void main(String[] args) {
		// JFrame을 상속받는 클래스는 화면을 구성할 수 있다.
		
		JTextField num_tf = new JTextField();
		MemberDAO dao = new MemberDAOimpl();
		MemberVO vo = new MemberVO();
		
		// JFrame jf = new JFrame();
		// 얘는 홈페이지가 JFrame을 상속받으면서
		// 아래로 변경
		// new HomePage();
		
		// 테스트 할 때는 homepage 주석 처리하고 insert 해보고 이렇게 하나씩
//		new InsertPage();
		
		new SelectPage();
//		new UpdatePage("2");
//		new DeletePage("2");
		
		
		
		
		
		
	}

}
