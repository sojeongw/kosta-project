package project.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import project.model.RoomDAO;
import project.model.RoomDAOimpl;
import project.model.RoomVO;
import javax.swing.JPanel;

public class InfoPage extends JFrame {
	
	RoomDAO dao = new RoomDAOimpl();
	
	private JButton OK_btn = new JButton("확인");
	
	private JLabel r_num;
	private JLabel r_name;
	private JLabel window_cnt;
	private JLabel door_cnt;
	private JLabel label_1;
	private JLabel empty = new JLabel("정보입니다.");
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_7;
	private JPanel panel;

	public InfoPage(RoomVO vo) {
		
		label_1 = new JLabel("       "+vo.getR_num()+"   번 방");
		r_num = new JLabel(vo.getR_num()+"");
		r_name = new JLabel(vo.getR_name()+"");
		window_cnt = new JLabel(vo.getWindow_cnt()+"");
		door_cnt = new JLabel(vo.getDoor_cnt()+"");
		
		Container con = getContentPane();
		con.setLayout(new GridLayout(0, 2));
		
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		con.add(label_1);	// 등록문구		
		con.add(empty);	// 공백
		
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
		
		label_2 = new JLabel("");
		getContentPane().add(label_2);
		
		label_7 = new JLabel("");
		getContentPane().add(label_7);
		
		label_3 = new JLabel("");
		getContentPane().add(label_3);
		
		panel = new JPanel();
		getContentPane().add(panel);
		panel.add(OK_btn);
		
		OK_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				
				setVisible(false);
			}
		});
		
		setTitle(vo.getR_num()+"번 방 상세정보");
		setBounds(0, 0, 250, 300);
		setVisible(true);
	}


}
