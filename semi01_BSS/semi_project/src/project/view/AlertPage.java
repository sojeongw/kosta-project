package project.view;


import javax.swing.JOptionPane;

import project.control.RoomCtrl;
import project.control.RoomCtrlImpl;

///// ȭ��߻� /////
public class AlertPage {

	RoomCtrl rCNT = new RoomCtrlImpl();

	public AlertPage(int room_num) {

		// ��ư�� ���� ����
		String[] btn = { "�����ϱ�" };

		// ȭ�� �߻� �޽���
		int result = JOptionPane.showOptionDialog(null, "ȭ�簡 �߻��Ͽ����ϴ�.", "ȭ����!", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, btn, "1");

		// �����ϱ⸦ ������ FireAction
		if (result == JOptionPane.YES_OPTION) {
			
			rCNT.FireAction(room_num);
		}

	}

}
