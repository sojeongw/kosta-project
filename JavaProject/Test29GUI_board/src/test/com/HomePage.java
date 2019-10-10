package test.com;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {
	
	public HomePage() {
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton insertBtn = new JButton("글쓰기");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsertPage();
			}
		});
		getContentPane().add(insertBtn);
		
		JButton selectBtn = new JButton("글목록");
		selectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectPage();
			}
		});
		getContentPane().add(selectBtn);
		
		
		
		setBounds(new Rectangle(0, 0, 250, 300));
		setTitle("Home Page");
		setVisible(true);
	
		
	}

}
