package project.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import project.model.LoginDAO;
import project.model.LoginDAOimpl;
import project.model.LoginVO;
import project.model.RoomVO;

public class LoginPage extends JFrame {
	
	RoomVO vo = new RoomVO();
	LoginVO lvo = new LoginVO();
	LoginDAO lDAO = new LoginDAOimpl();
	
	
	private JButton login_btn = new JButton("Log-in");

	// 라벨, 텍스트상자 생성 //
	private JLabel title = new JLabel("[[ Building Security System ]]");
	private JLabel label_id = new JLabel("     ID ");
	private JLabel label_pw = new JLabel("     PW ");
	private JLabel empty = new JLabel("");
	private JTextField id_tf = new JTextField("");
	private JTextField pw_tf = new JTextField("");
	
	
	public LoginPage() {
				
		//  //
		Container con = getContentPane();
		getContentPane().setLayout(new GridLayout(0, 1));
		title.setHorizontalAlignment(SwingConstants.CENTER);	// title을 중간에 위치시키는 문장
		
		// 버튼, 라벨, 텍스트상자 생성 //
		con.add(title);
		con.add(label_id);
		con.add(id_tf);
		con.add(label_pw);
		con.add(pw_tf);
		con.add(empty);
		
		// login_btn 클릭시 발생 이벤트
		login_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				lvo.setId(id_tf.getText());		// id 입력을 vo로 넣어줌
				lvo.setPw(pw_tf.getText());		// pw 입력을 vo로 넣어줌
				
				lvo = lDAO.selectOne(lvo);		// select 실행
				
				if(id_tf.getText().equals(lvo.getId())) 	// id가 저장된 id 와 같을 경우
				{		
					if(pw_tf.getText().equals(lvo.getPw())) // pw가 저장된 pw 와 같을 경우
					{	
						new HomePage();			// HomePage 창 열어줌
						setVisible(false);		// 창 닫기				
					}
					else 
						System.out.println("log-in 실패 비밀번호 다름");
				}
				else 
					System.out.println("log-in 실패 아이디 다름");
							
			}
		});	// 등록 버튼
	
		
		/// 버튼 ///
		con.add(login_btn);
		
		
		setTitle("BSS 로그인 화면");
		setBounds(0, 0, 250, 300);
		setVisible(true);
	}
}
