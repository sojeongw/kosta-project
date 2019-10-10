package test.com.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;

public class HomePage extends JFrame {
	// Ȩ�������� JFrame�� ��ӹ���
	
	private JButton insertBtn = new JButton("ȸ������");
	JButton selectBtn = new JButton("ȸ�����");
	
	MemberDAO dao = new MemberDAOimpl();
	MemberVO vo = new MemberVO();
	
	

	public HomePage() {
		
		// �����̳� �����
		Container con = getContentPane();		
		// 2�� 1�� �׸��� ���̾ƿ� ����
		con.setLayout(new GridLayout(2,1));
		
		// �̺�Ʈ�� ���� set�ϰ� �����̳ʿ� add�� �־���� �Ѵ�.
		insertBtn.addActionListener(new ActionListener() {
			// �������̵带 �����ؼ� ���������� call �ȴ� >> �ݹ� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("gotoInsert");
				
				new InsertPage();
			}
		});
		
		selectBtn.addActionListener(new ActionListener() {
			// �������̵带 �����ؼ� ���������� call �ȴ� >> �ݹ� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("gotoSelect");
				
				new SelectPage();
			}
		});
		
		// �����̳ʴ� set�� �ƴ϶� add
		// con.add(new JButton("ȸ������"));
		// ���⿡ �̺�Ʈ�� ������ ��������
		// JButton insertBtn = new JButton("ȸ������"); >> �������� ���� ���� ����� �ø���
		con.add(insertBtn);
		
		// con.add(new JButton("ȸ�����")); >> �̰͵� �Ȱ��� ����
		con.add(selectBtn);
		
		// ��ܿ� ������ ��
		setTitle("Home Page :)");
		
		// ������ ���� - ���� ��ǥ x, y + �ʺ�, ����
		setBounds(550, 250, 250, 330);
		
		// ���� �� �س��� ���������� ���� >> �׻� �������� �ϴ� �� ����
		setVisible(true);
		
		

	}

}
