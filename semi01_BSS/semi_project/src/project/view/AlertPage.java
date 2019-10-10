package project.view;


import javax.swing.JOptionPane;

import project.control.RoomCtrl;
import project.control.RoomCtrlImpl;

///// 화재발생 /////
public class AlertPage {

	RoomCtrl rCNT = new RoomCtrlImpl();

	public AlertPage(int room_num) {

		// 버튼에 적힐 내용
		String[] btn = { "진압하기" };

		// 화재 발생 메시지
		int result = JOptionPane.showOptionDialog(null, "화재가 발생하였습니다.", "화재경고!", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, btn, "1");

		// 진압하기를 누르면 FireAction
		if (result == JOptionPane.YES_OPTION) {
			
			rCNT.FireAction(room_num);
		}

	}

}
