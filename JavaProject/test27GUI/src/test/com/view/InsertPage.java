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

	// homepage�� �Ȱ��� ����
	public InsertPage() {
		// �����̳� ����
		Container con = getContentPane();
		con.setLayout(new GridLayout(5, 2));

		// text ��ü ����
		con.add(new JLabel("ID"));
		// text ������ ��ü ����. text�� ���� ����� �׽�Ʈ �ϰ� ����� �� ���߿� �Ѵ�
		// con.add(new JTextField("admin"));
		con.add(id_tf); // �������� �ø��� ����

		con.add(new JLabel("PW"));
		con.add(pw_tf);

		con.add(new JLabel("NAME"));
		con.add(name_tf);

		con.add(new JLabel("TEL"));
		con.add(tel_tf);

		con.add(new JLabel(""));
		// con.add(new JButton("insertOK"));
		// ������ �ѱ�� �� dao�� ��������, �� ������ �� ������ �� button�� ����� �Ѵ�.
		// >> ���� �÷��� �̺�Ʈ �������ش�

		insertOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("insert OK");

				// id �� �ּ���
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

		// ��ġ �� ũ��
		setBounds(700, 250, 250, 300);

		// ���������� ����
		setVisible(true);
	}

}
