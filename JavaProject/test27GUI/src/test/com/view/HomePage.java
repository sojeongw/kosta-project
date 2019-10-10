package test.com.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;

public class HomePage extends JFrame {
	// 홈페이지가 JFrame을 상속받음
	
	private JButton insertBtn = new JButton("회원가입");
	JButton selectBtn = new JButton("회원목록");
	
	MemberDAO dao = new MemberDAOimpl();
	MemberVO vo = new MemberVO();
	
	

	public HomePage() {
		
		// 컨테이너 만들기
		Container con = getContentPane();		
		// 2행 1열 그리드 레이아웃 세팅
		con.setLayout(new GridLayout(2,1));
		
		// 이벤트를 먼저 set하고 컨테이너에 add로 넣어줘야 한다.
		insertBtn.addActionListener(new ActionListener() {
			// 오버라이드를 강제해서 내부적으로 call 된다 >> 콜백 구조
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("gotoInsert");
				
				new InsertPage();
			}
		});
		
		selectBtn.addActionListener(new ActionListener() {
			// 오버라이드를 강제해서 내부적으로 call 된다 >> 콜백 구조
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("gotoSelect");
				
				new SelectPage();
			}
		});
		
		// 컨테이너는 set이 아니라 add
		// con.add(new JButton("회원가입"));
		// 여기에 이벤트를 쓰려면 나눠쓴다
		// JButton insertBtn = new JButton("회원가입"); >> 공통으로 쓰기 위해 멤버로 올린다
		con.add(insertBtn);
		
		// con.add(new JButton("회원목록")); >> 이것도 똑같이 수정
		con.add(selectBtn);
		
		// 상단에 나오는 글
		setTitle("Home Page :)");
		
		// 사이즈 설정 - 시작 좌표 x, y + 너비, 높이
		setBounds(550, 250, 250, 330);
		
		// 세팅 다 해놓고 보여지도록 설정 >> 항상 마지막에 하는 게 좋다
		setVisible(true);
		
		

	}

}
