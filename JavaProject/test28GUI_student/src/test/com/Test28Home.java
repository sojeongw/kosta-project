package test.com;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test28Home extends JFrame {

	// ��ü �����
	private JButton insertBtn = new JButton("���� �Է�");
	private JButton selectBtn = new JButton("�л� ���");

	public Test28Home() {
		System.out.println("home");

		// �����̳� �����
		Container con = getContentPane();

		// ���̾ƿ� �����
		con.setLayout(new GridLayout(2, 1));

		// �̺�Ʈ �ֱ� - insert
		insertBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("insert event");
				new Test28Insert();
			}
		});

		// �̺�Ʈ �ֱ� - select
		selectBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("select event");
				new Test28Select();
			}
		});

		// add �ϱ�
		con.add(insertBtn);
		con.add(selectBtn);

		// �⺻ ����
		setTitle("Home page");
		setBounds(250, 250, 300, 250);
		setVisible(true);

	}

}
