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

import project.model.RoomDAO;
import project.model.RoomDAOimpl;
import project.model.RoomVO;
import project.view.SelectPage;

public class InsertPage extends JFrame {
	
	private JButton insertOK = new JButton("등록");
	private JButton cancelOK = new JButton("취소");
	
	private JLabel r_num;
	private JTextField r_name = new JTextField("");
	private JTextField window_cnt = new JTextField("");
	private JTextField door_cnt = new JTextField("");
	private JLabel label_1 = new JLabel("등록할 정보를 입력하세요");
	private JLabel label_2 = new JLabel("");
//	private JLabel label_3 = new JLabel("");

	public InsertPage(RoomVO vo) {
		
		r_num = new JLabel(vo.getR_num()+"");
		
		Container con = getContentPane();
		con.setLayout(new GridLayout(0, 2));
		
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		con.add(label_1);	// 등록문구		
		con.add(label_2);	// 공백
		
		JLabel label = new JLabel("방 순번");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(label);
		con.add(r_num);
		JLabel label_4 = new JLabel("방 이름");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(label_4);
		con.add(r_name);
		JLabel label_5 = new JLabel("창문 갯수");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(label_5);
		con.add(window_cnt);
		JLabel label_6 = new JLabel("방문 갯수");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(label_6);
		con.add(door_cnt);
		
		insertOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				RoomDAO dao = new RoomDAOimpl();
				
				vo.setR_num(Integer.parseInt(r_num.getText()));
				vo.setR_name(r_name.getText());
				vo.setWindow_cnt(Integer.parseInt(window_cnt.getText()));
				vo.setDoor_cnt(Integer.parseInt(door_cnt.getText()));
				int result = dao.insert(vo);
				
				if(result==1){
					new SelectPage();	
				}else {
					System.out.println("입력실패");
				}
				
				dispose();
				// setVisible(false);와 눈에 시각적으로 같지만 딜레이가 다르다, 
				// dispose는 완전히 꺼진다.
			}
		});
		
		cancelOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				setVisible(false);
			}
		});
		
		
		
		con.add(insertOK);
		con.add(cancelOK);
		
		
		setTitle("성적 정보 입력");
		setBounds(0, 0, 250, 300);
		setVisible(true);
	}


}
