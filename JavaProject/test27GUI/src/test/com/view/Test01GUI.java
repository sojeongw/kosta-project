package test.com.view;

import javax.swing.JTextField;

import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;

public class Test01GUI {
	
	public static void main(String[] args) {
		// JFrame�� ��ӹ޴� Ŭ������ ȭ���� ������ �� �ִ�.
		
		JTextField num_tf = new JTextField();
		MemberDAO dao = new MemberDAOimpl();
		MemberVO vo = new MemberVO();
		
		// JFrame jf = new JFrame();
		// ��� Ȩ�������� JFrame�� ��ӹ����鼭
		// �Ʒ��� ����
		// new HomePage();
		
		// �׽�Ʈ �� ���� homepage �ּ� ó���ϰ� insert �غ��� �̷��� �ϳ���
//		new InsertPage();
		
		new SelectPage();
//		new UpdatePage("2");
//		new DeletePage("2");
		
		
		
		
		
		
	}

}
