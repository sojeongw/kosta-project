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
	
	private JButton insertOK = new JButton("���");
	private JButton updateOK = new JButton("����");
	private JButton deleteOK = new JButton("����");
	private JButton listOK = new JButton("������");


	private JLabel label_1 = new JLabel("���Ͻô� �޴��� �����ϼ���");
	private JLabel num;
	
	public MenuPage(RoomVO vo) {
		// System.out.println(vo.getR_num());
		num = new JLabel("�� " + vo.getR_num() + "���� \\(���䤷)/ ��");
		
		/// �ʼ� ///
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
		});	// ��� ��ư
	
		updateOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				new UpdatePage(vo);
//				new CautionPage();
				setVisible(false);
			}
		});	// ���� ��ư

		deleteOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				new DeletePage(vo);
				setVisible(false);
			}
		});	// ���� ��ư

		listOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				new InfoPage(vo);
				setVisible(false);
			}
		});
		
		
		/// ��ư ///
	
		con.add(insertOK);
		con.add(updateOK);
		con.add(deleteOK);
		con.add(listOK);
		
		
		///////////
		
		setTitle("�޴�");
		setBounds(0, 0, 250, 300);
		setVisible(true);
	}
}
