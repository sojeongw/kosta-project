package test.com;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertPage extends JFrame {
	private JTextField title_tf;
	private JTextField content_tf;
	private JTextField writer_tf;

	public InsertPage() {
		getContentPane().setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel title_lb = new JLabel("제목");
		getContentPane().add(title_lb);
		
		title_tf = new JTextField("title");
		getContentPane().add(title_tf);
		title_tf.setColumns(10);
		
		JLabel content_lb = new JLabel("내용");
		getContentPane().add(content_lb);
		
		content_tf = new JTextField("content");
		getContentPane().add(content_tf);
		content_tf.setColumns(10);
		
		JLabel writer_lb = new JLabel("작성자");
		getContentPane().add(writer_lb);
		
		writer_tf = new JTextField("writer");
		getContentPane().add(writer_tf);
		writer_tf.setColumns(10);
		
		JLabel label = new JLabel("");
		getContentPane().add(label);
		
		JButton insertOK = new JButton("insertOK");
		insertOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(title_tf.getText());
				System.out.println(content_tf.getText());
				System.out.println(writer_tf.getText());
				
				
				
				new SelectPage();
				
			}
		});
		getContentPane().add(insertOK);
		
		
		
		setBounds(new Rectangle(250, 0, 250, 300));
		setTitle("Insert Page");
		setVisible(true);
	}
}
