package test.com;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test28Delete extends JFrame {

	private JButton ok = new JButton("Delete OK");
	private JButton cancel = new JButton("cancel");
	private JLabel num_lb = new JLabel("99");

	public Test28Delete(String num) {
		Container con = getContentPane();

		con.setLayout(new GridLayout(2, 2));

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ok event");
				new Test28Select();
			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("cancel event");
				new Test28Update("2");
			}
		});
		
		num_lb.setText(num);
		con.add(new JLabel(num));
		con.add(new JLabel("번 회원을 삭제 하시겠습니까?"));
		
		con.add(ok);
		con.add(cancel);

		// 기본 세팅
		setTitle("Delete Page");
		setBounds(250, 250, 500, 150);
		setVisible(true);

	}

}
