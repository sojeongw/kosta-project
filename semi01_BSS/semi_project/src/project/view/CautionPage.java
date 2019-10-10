package project.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import project.model.RoomVO;

//// 방에 정보가 없을 때 ////
public class CautionPage extends JFrame {

	RoomVO vo = new RoomVO();

	public CautionPage() {

		// constructor test
		System.out.println("Delete Page...");

		// button setting
		int input = JOptionPane.showConfirmDialog(null, "방이 없습니다.", "경고", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE);

		// OK button event
		if (input == JOptionPane.OK_OPTION) {

			// ok 누르면 목록으로 이동
			// new SelectPage();
			setVisible(false);
		}

		// CANCEL button event
		if (input == JOptionPane.CANCEL_OPTION) {

			// cancel 누르면 update 하던 창으로 이동
			setVisible(false);
			// new MenuPage(vo);
		}

	} // end of constructor

} // end of class
