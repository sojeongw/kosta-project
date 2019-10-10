package test.com.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;

public class InsertPage extends JFrame {
	
	MemberDAO dao = new MemberDAOimpl();
	MemberVO vo = new MemberVO();

	private JButton insertOK = new JButton("InsertOK");
	private JTextField id_tf = new JTextField("admin"); // tf = text field
	private JTextField pw_tf = new JTextField("hi123456");
	private JTextField name_tf = new JTextField("kim");
	private JTextField tel_tf = new JTextField("010");

	// homepage랑 똑같이 설정
	public InsertPage() {
		// 컨테이너 세팅
		Container con = getContentPane();
		con.setLayout(new GridLayout(5, 2));

		// text 객체 생성
		con.add(new JLabel("ID"));
		// text 써지는 객체 생성. text는 내용 써놓고 테스트 하고 지우는 건 나중에 한다
		// con.add(new JTextField("admin"));
		con.add(id_tf); // 전역으로 올리고 수정

		con.add(new JLabel("PW"));
		con.add(pw_tf);

		con.add(new JLabel("NAME"));
		con.add(name_tf);

		con.add(new JLabel("TEL"));
		con.add(tel_tf);

		con.add(new JLabel(""));
		// con.add(new JButton("insertOK"));
		// 정보를 넘기는 건 dao가 해주지만, 그 정보를 딱 모으는 건 button이 해줘야 한다.
		// >> 위로 올려서 이벤트 설정해준다

		insertOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("insert OK");

				// id 값 주세요
				System.out.println("insertOK");
				String id = id_tf.getText();
				vo.setId(id);
				System.out.println(id);
				
				String pw = pw_tf.getText();
				vo.setPw(pw);
				System.out.println(pw);
				
				String name = name_tf.getText();
				vo.setName(name);
				System.out.println(name);
				
				String tel = tel_tf.getText();
				vo.setTel(tel);
				System.out.println(tel);
				
				dao.insert(vo);
				
				new SelectPage();

			}
		});

		con.add(insertOK);

		// 위치 및 크기
		setBounds(700, 250, 250, 300);

		// 보여지도록 설정
		setVisible(true);
	}

}
