package test.com;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Test28Insert extends JFrame {
	
	// 객체 생성
	private JTextField name_tf = new JTextField("NAME");
	private JTextField kor_tf = new JTextField("KOR");
	private JTextField eng_tf = new JTextField("ENG");
	private JTextField math_tf = new JTextField("MATH");
	private JTextField total_tf = new JTextField("TOTAL");
	private JTextField avg_tf = new JTextField("AVG");
	private JTextField grade_tf = new JTextField("GRADE");
	
	private JButton insertBtn = new JButton("insert OK");
	

	public Test28Insert() {
		// System.out.println("insert...");
		
		// 컨테이너 만들기
		Container con = getContentPane();
		
		// 레이아웃
		con.setLayout(new GridLayout(9, 2));
		
		// 이벤트
		insertBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("insert OK event");
				new Test28Select();
			}
		});
		
		
		// add
		con.add(new JLabel("NUM"));
		con.add(new JLabel("1"));
		con.add(new JLabel("NAME"));
		con.add(name_tf);
		con.add(new JLabel("KOR"));
		con.add(kor_tf);
		con.add(new JLabel("ENG"));
		con.add(eng_tf);
		con.add(new JLabel("MATH"));
		con.add(math_tf);
		con.add(new JLabel("TOTAL"));
		con.add(total_tf);
		con.add(new JLabel("AVG"));
		con.add(avg_tf);
		con.add(new JLabel("GRADE"));
		con.add(grade_tf);
		con.add(new JLabel(""));
		con.add(insertBtn);

		// 기본 세팅
		setTitle("Insert Page");
		setBounds(250, 250, 300, 250);
		setVisible(true);
	}

}
