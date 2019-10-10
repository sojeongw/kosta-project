package project.view;

import java.awt.Container;
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
	
	private JButton insertOK = new JButton("���");
	private JButton cancelOK = new JButton("���");
	
	private JLabel r_num;
	private JTextField r_name = new JTextField("");
	private JTextField window_cnt = new JTextField("");
	private JTextField door_cnt = new JTextField("");
	private JLabel label_1 = new JLabel("����� ������ �Է��ϼ���");
	private JLabel label_2 = new JLabel("");

	public InsertPage(RoomVO vo) {
		
		r_num = new JLabel(vo.getR_num()+"");
		r_num.setBounds(117, 45, 117, 43);
		
		Container con = getContentPane();
		getContentPane().setLayout(null);
		label_1.setBounds(0, 2, 234, 43);
		
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		con.add(label_1);	// ��Ϲ���		
		label_2.setBounds(117, 2, 117, 43);
		con.add(label_2);	// ����
		
		JLabel label = new JLabel("�� ����");
		label.setBounds(0, 45, 117, 43);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(label);
		con.add(r_num);
		JLabel label_4 = new JLabel("�� �̸�");
		label_4.setBounds(0, 88, 117, 43);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(label_4);
		r_name.setBounds(117, 88, 117, 43);
		con.add(r_name);
		JLabel label_5 = new JLabel("â�� ����");
		label_5.setBounds(0, 131, 117, 43);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(label_5);
		window_cnt.setBounds(117, 131, 117, 43);
		con.add(window_cnt);
		JLabel label_6 = new JLabel("�湮 ����");
		label_6.setBounds(0, 174, 117, 43);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(label_6);
		door_cnt.setBounds(117, 174, 117, 43);
		con.add(door_cnt);
		insertOK.setBounds(0, 217, 117, 43);
		
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
					System.out.println("�Է½���");
				}
				
				dispose();
				// setVisible(false);�� ���� �ð������� ������ �����̰� �ٸ���, 
				// dispose�� ������ ������.
			}
		});
		cancelOK.setBounds(117, 217, 117, 43);
		
		cancelOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				setVisible(false);
			}
		});
		
		con.add(insertOK);
		con.add(cancelOK);
		
		setTitle("�� ���� �Է�");
		setBounds(0, 0, 250, 300);
		setVisible(true);
	}

}
