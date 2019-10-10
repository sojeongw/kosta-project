package test.com;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test28Home extends JFrame {

	// 객체 만들기
	private JButton insertBtn = new JButton("점수 입력");
	private JButton selectBtn = new JButton("학생 목록");

	public Test28Home() {
		System.out.println("home");

		// 컨테이너 만들기
		Container con = getContentPane();

		// 레이아웃 만들기
		con.setLayout(new GridLayout(2, 1));

		// 이벤트 넣기 - insert
		insertBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("insert event");
				new Test28Insert();
			}
		});

		// 이벤트 넣기 - select
		selectBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("select event");
				new Test28Select();
			}
		});

		// add 하기
		con.add(insertBtn);
		con.add(selectBtn);

		// 기본 세팅
		setTitle("Home page");
		setBounds(250, 250, 300, 250);
		setVisible(true);

	}

}
