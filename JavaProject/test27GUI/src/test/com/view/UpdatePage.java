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
		// num�� �� �Ѿ�Դ��� Ȯ��
		System.out.println(num);

		// �����̳� �����
		Container con = getContentPane();
		// 2�� 1�� �׸��� ���̾ƿ� ����
		con.setLayout(new GridLayout(6, 2));

		// text ��ü ����
		con.add(new JLabel("NUM"));
		// ������ ���ڷ� �ϱ� ���ٴ� �̷��� �ϴ� �� ȿ����
		num_lb.setText(num);
		con.add(num_lb);		
		

		con.add(new JLabel("ID"));
		con.add(id_tf); // �������� �ø��� ����
		
		

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
