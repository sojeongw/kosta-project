package project.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import project.model.RoomVO;

public class MenuPage extends JFrame {
	
	RoomVO vo = new RoomVO();
	
	private JButton insertOK = new JButton("등록");
	private JButton updateOK = new JButton("수정");
	private JButton deleteOK = new JButton("삭제");
	private JButton listOK = new JButton("상세정보");


	private JLabel label_1 = new JLabel("원하시는 메뉴를 선택하세요");
	private JLabel num;
	
	public MenuPage(RoomVO vo) {
		// System.out.println(vo.getR_num());
		num = new JLabel("☆ " + vo.getR_num() + "번방 \\(ㅇ▽ㅇ)/ ☆");
		
		/// 필수 ///
		Container con = getContentPane();
		getContentPane().setLayout(new GridLayout(0, 1));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		num.setHorizontalAlignment(SwingConstants.CENTER);
		
		//////////
//		this.vo = vo;
		System.out.println(vo.getR_name());
		
		if(vo.getR_name() == null) {
			insertOK.setEnabled(true);
		}else {
			insertOK.setEnabled(false);
		}
		
		if(vo.getR_name() != null) {
			updateOK.setEnabled(true);
		}else {
			updateOK.setEnabled(false);
		}
		
		if(vo.getR_name() != null) {
			deleteOK.setEnabled(true);
		}else {
			deleteOK.setEnabled(false);
		}
		
		con.add(num);
		con.add(label_1);
		
		insertOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new InsertPage(vo);				
				setVisible(false);
			}
		});	// 등록 버튼
	
		updateOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				new UpdatePage(vo);
//				new CautionPage();
				setVisible(false);
			}
		});	// 수정 버튼

		deleteOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				new DeletePage(vo);
				setVisible(false);
			}
		});	// 삭제 버튼

		listOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				new InfoPage(vo);
				setVisible(false);
			}
		});
		
		
		/// 버튼 ///
	
		con.add(insertOK);
		con.add(updateOK);
		con.add(deleteOK);
		con.add(listOK);
		
		
		///////////
		
		setTitle("메뉴");
		setBounds(0, 0, 250, 300);
		setVisible(true);
	}
}
