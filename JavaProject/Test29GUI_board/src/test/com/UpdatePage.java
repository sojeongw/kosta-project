package test.com;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatePage extends JFrame {
	private JTextField txtTitle;
	private JTextField txtContent;
	private JTextField txtKim;
	
	public UpdatePage() {
		getContentPane().setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblNum = new JLabel("NUM");
		getContentPane().add(lblNum);
		
		JLabel num_lb = new JLabel("99");
		getContentPane().add(num_lb);
		
		JLabel lblTitle = new JLabel("TITLE");
		getContentPane().add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setText("TITLE");
		getContentPane().add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblContent = new JLabel("CONTENT");
		getContentPane().add(lblContent);
		
		txtContent = new JTextField();
		txtContent.setText("CONTENT");
		getContentPane().add(txtContent);
		txtContent.setColumns(10);
		
		JLabel lblWriter = new JLabel("WRITER");
		getContentPane().add(lblWriter);
		
		txtKim = new JTextField();
		txtKim.setText("KIM");
		getContentPane().add(txtKim);
		txtKim.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(btnDelete);
		
		JButton btnUpdateok = new JButton("UPDATE_OK");
		btnUpdateok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnUpdateok);
		
		
		
		setTitle("Update Page");
		setBounds(new Rectangle(1000, 0, 250, 300));
		setBackground(Color.RED);
		setVisible(true);
		
	}

	public UpdatePage(String num) {
		this();
		System.out.println(num);
	}

}
