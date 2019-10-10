package test.com.view;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import test.com.model.BoardDAO;
import test.com.model.BoardDAOimpl;
import test.com.model.BoardVO;

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
				
				// 누를 때 insert가 작동해야 하니까 그대로 여기로 복사된다.
				// 변수를 수정해준다.
				
				// 1.insert
				BoardVO vo = new BoardVO();
				// num은 이제 할 필요 없음
				vo.setTitle(title_tf.getText());
				vo.setContent(content_tf.getText());
				vo.setWriter(writer_tf.getText());
				
				// DAO를 만든다
				// impl을 만든다
				BoardDAO dao = new BoardDAOimpl();
				int result = dao.insert(vo);	// 리턴 받겠다.
				
				// 리턴 성공하면
				if(result == 1) {
					new SelectPage();
				}else {
					System.out.println("입력실패");
				}
				
				
				
				//new SelectPage();
				
			}
		});
		getContentPane().add(insertOK);
		
		
		
		setBounds(new Rectangle(250, 0, 250, 300));
		setTitle("Insert Page");
		setVisible(true);
	}
}
