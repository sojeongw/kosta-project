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

public class UpdatePage extends JFrame {
	
	MemberVO vo = new MemberVO();
	MemberDAO dao = new MemberDAOimpl();

	private JButton updateBtn = new JButton("UpdateBtn");
	private JButton deleteBtn = new JButton("DeleteBtn");
	private JTextField id_tf = new JTextField("admin");
	private JTextField pw_tf = new JTextField("hi123456");
	private JTextField name_tf = new JTextField("kim");
	private JTextField tel_tf = new JTextField("010");
	private JLabel num_lb = new JLabel("99");

	public UpdatePage(String num) {
		// num이 잘 넘어왔는지 확인
		System.out.println(num);

		// 컨테이너 만들기
		Container con = getContentPane();
		// 2행 1열 그리드 레이아웃 세팅
		con.setLayout(new GridLayout(6, 2));

		// text 객체 생성
		con.add(new JLabel("NUM"));
		// 생성자 인자로 하기 보다는 이렇게 하는 게 효율적
		num_lb.setText(num);
		con.add(num_lb);		
		

		con.add(new JLabel("ID"));
		con.add(id_tf); // 전역으로 올리고 수정
		
		

		con.add(new JLabel("PW"));
		con.add(pw_tf);
		String pw = pw_tf.getText();
		vo.setPw(pw);

		con.add(new JLabel("NAME"));
		con.add(name_tf);
		String name = name_tf.getText();
		vo.setName(name);

		con.add(new JLabel("TEL"));
		con.add(tel_tf);
		String tel = tel_tf.getText();
		vo.setTel(tel);
		
		

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("delete complete");
				new DeletePage(num);
			}

		});
		
		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("update complete");
				
				String id_l = num_lb.getText();
				System.out.println(id_l);
				
				String id = id_tf.getText();
				System.out.println(id);
				vo.setId(id);
				
				String pw = pw_tf.getText();
				System.out.println(pw);
				vo.setPw(pw);
				
				String name = name_tf.getText();
				System.out.println(name);
				vo.setName(name);
				
				String tel = tel_tf.getText();
				System.out.println(tel);
				vo.setTel(tel);
				
				dao.update(vo);
			}

		});
		
		con.add(updateBtn);
		con.add(deleteBtn);

		setTitle("update page");
		setBounds(550, 250, 400, 300);
		setVisible(true);

	}

}
