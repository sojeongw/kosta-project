package project.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import project.model.RoomVO;

//// �濡 ������ ���� �� ////
public class CautionPage extends JFrame {

	RoomVO vo = new RoomVO();

	public CautionPage() {

		// constructor test
		System.out.println("Delete Page...");

		// button setting
		int input = JOptionPane.showConfirmDialog(null, "���� �����ϴ�.", "���", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE);

		// OK button event
		if (input == JOptionPane.OK_OPTION) {

			// ok ������ ������� �̵�
			// new SelectPage();
			setVisible(false);
		}

		// CANCEL button event
		if (input == JOptionPane.CANCEL_OPTION) {

			// cancel ������ update �ϴ� â���� �̵�
			setVisible(false);
			// new MenuPage(vo);
		}

	} // end of constructor

} // end of class
