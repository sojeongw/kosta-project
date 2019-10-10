package project.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import project.model.LoginDAO;
import project.model.LoginDAOimpl;
import project.model.LoginVO;
import project.model.RoomVO;

public class LoginPage extends JFrame {
	
	RoomVO vo = new RoomVO();
	LoginVO lvo = new LoginVO();
	LoginDAO lDAO = new LoginDAOimpl();
	
	
	private JButton login_btn = new JButton("Log-in");

	// ��, �ؽ�Ʈ���� ���� //
	private JLabel title = new JLabel("[[ Building Security System ]]");
	private JLabel label_id = new JLabel("     ID ");
	private JLabel label_pw = new JLabel("     PW ");
	private JLabel empty = new JLabel("");
	private JTextField id_tf = new JTextField("");
	private JTextField pw_tf = new JTextField("");
	
	
	public LoginPage() {
				
		//  //
		Container con = getContentPane();
		getContentPane().setLayout(new GridLayout(0, 1));
		title.setHorizontalAlignment(SwingConstants.CENTER);	// title�� �߰��� ��ġ��Ű�� ����
		
		// ��ư, ��, �ؽ�Ʈ���� ���� //
		con.add(title);
		con.add(label_id);
		con.add(id_tf);
		con.add(label_pw);
		con.add(pw_tf);
		con.add(empty);
		
		// login_btn Ŭ���� �߻� �̺�Ʈ
		login_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				lvo.setId(id_tf.getText());		// id �Է��� vo�� �־���
				lvo.setPw(pw_tf.getText());		// pw �Է��� vo�� �־���
				
				lvo = lDAO.selectOne(lvo);		// select ����
				
				if(id_tf.getText().equals(lvo.getId())) 	// id�� ����� id �� ���� ���
				{		
					if(pw_tf.getText().equals(lvo.getPw())) // pw�� ����� pw �� ���� ���
					{	
						new HomePage();			// HomePage â ������
						setVisible(false);		// â �ݱ�				
					}
					else 
						System.out.println("log-in ���� ��й�ȣ �ٸ�");
				}
				else 
					System.out.println("log-in ���� ���̵� �ٸ�");
							
			}
		});	// ��� ��ư
	
		
		/// ��ư ///
		con.add(login_btn);
		
		
		setTitle("BSS �α��� ȭ��");
		setBounds(0, 0, 250, 300);
		setVisible(true);
	}
}
