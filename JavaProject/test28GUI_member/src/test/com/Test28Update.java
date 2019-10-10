package test.com;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Test28Update extends JFrame{
	
	private JButton updateBtn = new JButton("Update OK");
	private JButton deleteBtn = new JButton("Delete OK");
	private JTextField name_tf = new JTextField("NAME");
	private JTextField kor_tf = new JTextField("KOR");
	private JTextField eng_tf = new JTextField("ENG");
	private JTextField math_tf = new JTextField("MATH");
	private JTextField total_tf = new JTextField("TOTAL");
	private JTextField avg_tf = new JTextField("AVG");
	private JTextField grade_tf = new JTextField("GRADE");
	
	private JLabel num_lb = new JLabel("99");

	public Test28Update(String num) {
		// 컨테이너
		Container con = getContentPane();
		
		// 레이아웃
		con.setLayout(new GridLayout(9, 2));
		
		// 이벤트
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("update event");
				
				String num_l = num_lb.getText();
				System.out.println(num_l);
				String name = name_tf.getText();
				System.out.println(name);
				String kor = kor_tf.getText();
				System.out.println(kor);
				String eng = eng_tf.getText();
				System.out.println(eng);
				String math = math_tf.getText();
				System.out.println(math);
				String total = total_tf.getText();
				System.out.println(total);
				String avg = avg_tf.getText();
				System.out.println(avg);
				String grade = grade_tf.getText();
				System.out.println(grade);
				
				new Test28Select();
			}
		});
		
		// add
		num_lb.setText(num);
		con.add(new JLabel("NUM"));
		con.add(num_lb);
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
		
		
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("delete event");
				new Test28Delete("2");
			}
		});
		
		con.add(deleteBtn);
		con.add(updateBtn);
		
		// 기본 세팅
		setTitle("Update Page");
		setBounds(250, 250, 300, 250);
		setVisible(true);
	}

}
