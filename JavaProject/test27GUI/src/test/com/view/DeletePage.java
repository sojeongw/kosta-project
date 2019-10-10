package test.com.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;


public class DeletePage extends JFrame {
	
	MemberDAO dao = new MemberDAOimpl();
	MemberVO vo = new MemberVO();
	
	private JLabel num_lb = new JLabel("99");
	private JButton deleteOK = new JButton("deleteOK");

	public DeletePage(String num) {
		System.out.println(num);
		
		Container con = getContentPane();
		con.setLayout(new GridLayout(2, 2));
		num_lb.setText(num); 
		con.add(num_lb);
		con.add(new JLabel("번 회원을 삭제 하시겠습니까?"));
		con.add(new JLabel(""));
		
		// delete 버튼 이벤트
		deleteOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 나와야 할 값 테스트
				System.out.println("delete ok " + num_lb.getText());
				
				dao.delete(vo);
				
				new SelectPage();
				setVisible(false);
			}
		});
		con.add(deleteOK);
		
		
		setTitle("Delete Page");
		setBounds(0, 300, 250, 100);
		setVisible(true);
		
	}

}
