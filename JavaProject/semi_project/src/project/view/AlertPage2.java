package project.view;

import javax.swing.JOptionPane;

import project.control.RoomCtrl;
import project.control.RoomCtrlImpl;

///// ħ���� �߻� /////
public class AlertPage2 {

	RoomCtrl rCNT = new RoomCtrlImpl();
	
	public AlertPage2(int room_num) {

		// ��ư�� ���� ����
		Object[] btn = {"�ذ��ϱ�"};
		
		// ���â
		int result = JOptionPane.showOptionDialog(null, "ħ���� �߻�", "Alert Page2", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, btn, "1");

		// ��ư�� ������
		if (result == JOptionPane.YES_OPTION) {
			rCNT.InvAction(room_num);
		} 
		
	}
	
}
