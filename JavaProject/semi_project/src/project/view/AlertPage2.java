package project.view;

import javax.swing.JOptionPane;

import project.control.RoomCtrl;
import project.control.RoomCtrlImpl;

///// 침입자 발생 /////
public class AlertPage2 {

	RoomCtrl rCNT = new RoomCtrlImpl();
	
	public AlertPage2(int room_num) {

		// 버튼에 적힐 내용
		Object[] btn = {"해결하기"};
		
		// 경고창
		int result = JOptionPane.showOptionDialog(null, "침입자 발생", "Alert Page2", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, btn, "1");

		// 버튼을 누르면
		if (result == JOptionPane.YES_OPTION) {
			rCNT.InvAction(room_num);
		} 
		
	}
	
}
