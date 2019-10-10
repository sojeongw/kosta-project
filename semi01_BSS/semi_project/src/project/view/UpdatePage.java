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

	private JButton cancelBtn = new JButton("취소");
	private JButton updateOk = new JButton("수정");

	private JLabel r_num;

	private JTextField r_name = new JTextField();
	private JTextField window_cnt = new JTextField();
	private JTextField door_cnt = new JTextField();

	public UpdatePage(RoomVO vo) {

		RoomDAO dao = new RoomDAOimpl();

		// 컨테이너 생성 및 레이아웃 설정
		Container con = getContentPane();
		con.setLayout(new GridLayout(0, 2));

		// 메뉴 이름 설정
		JLabel label = new JLabel("순번");
		con.add(label);

		// 번호 받아오기
		r_num = new JLabel(vo.getR_num() + "");
		con.add(r_num);

		// 이름 받아오기
		r_name = new JTextField(vo.getR_name());
		con.add(new JLabel("이름"));
		con.add(r_name);
		
		// 창문 개수
		con.add(new JLabel("창문 개수"));
		window_cnt = new JTextField(String.valueOf(vo.getWindow_cnt()));
		con.add(window_cnt);
		
		// 문 개수
		con.add(new JLabel("문 개수"));
		door_cnt = new JTextField(String.valueOf(vo.getDoor_cnt()));
		con.add(door_cnt);

		// 수정하기
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
					System.out.println("입력실패");
				}

				setVisible(false);
			}
		});
		
		// 취소하기
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		// 버튼 생성
		con.add(updateOk);
		con.add(cancelBtn);

		// 기본 세팅
		setTitle("수정할 방 정보 입력");
		setBounds(0, 0, 250, 300);
		setVisible(true);

	}

}