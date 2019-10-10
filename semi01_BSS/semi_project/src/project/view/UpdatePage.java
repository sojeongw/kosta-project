package project.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import project.model.RoomDAO;
import project.model.RoomDAOimpl;
import project.model.RoomVO;

public class UpdatePage extends JFrame {

	private JButton cancelBtn = new JButton("���");
	private JButton updateOk = new JButton("����");

	private JLabel r_num;

	private JTextField r_name = new JTextField();
	private JTextField window_cnt = new JTextField();
	private JTextField door_cnt = new JTextField();

	public UpdatePage(RoomVO vo) {

		RoomDAO dao = new RoomDAOimpl();

		// �����̳� ���� �� ���̾ƿ� ����
		Container con = getContentPane();
		con.setLayout(new GridLayout(0, 2));

		// �޴� �̸� ����
		JLabel label = new JLabel("����");
		con.add(label);

		// ��ȣ �޾ƿ���
		r_num = new JLabel(vo.getR_num() + "");
		con.add(r_num);

		// �̸� �޾ƿ���
		r_name = new JTextField(vo.getR_name());
		con.add(new JLabel("�̸�"));
		con.add(r_name);
		
		// â�� ����
		con.add(new JLabel("â�� ����"));
		window_cnt = new JTextField(String.valueOf(vo.getWindow_cnt()));
		con.add(window_cnt);
		
		// �� ����
		con.add(new JLabel("�� ����"));
		door_cnt = new JTextField(String.valueOf(vo.getDoor_cnt()));
		con.add(door_cnt);

		// �����ϱ�
		updateOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				vo.setR_num(Integer.parseInt(r_num.getText()));
				vo.setR_name(r_name.getText());
				vo.setWindow_cnt(Integer.parseInt(window_cnt.getText()));
				vo.setDoor_cnt(Integer.parseInt(door_cnt.getText()));
				
				int result = dao.update(vo);

				if (result == 1) {
					new SelectPage();
				} else {
					System.out.println("�Է½���");
				}

				setVisible(false);
			}
		});
		
		// ����ϱ�
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		// ��ư ����
		con.add(updateOk);
		con.add(cancelBtn);

		// �⺻ ����
		setTitle("������ �� ���� �Է�");
		setBounds(0, 0, 250, 300);
		setVisible(true);

	}

}