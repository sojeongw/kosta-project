package test.com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;

public class SelectPage extends JFrame {
	
	MemberDAO dao = new MemberDAOimpl();
	

	private JButton insertBtn = new JButton("InsertBtn");
	// jtable�� �ȿ� �ֵ� �ۿ� �ֵ� �������.
	// �ϴ� null ó���� �ϰ� ������ �ȿ��� ������ �־� �����Ѵ�.
	private JTable jtable;

	public SelectPage() {
				
		// dao.selectAll();
		
		// �����̳� ����
		Container con = getContentPane();
		// ���̾ƿ� ����
		// con.setLayout(new GridLayout(2, 1));
		
		// ���̾ƿ� ����
		con.setLayout(new BorderLayout());

		// ���� �迭 ����
		String[] colNames = new String[] { "NUM", "ID", "PW", "NAME", "TEL" };
		// ���� �𸣰����� ���� �ѹ�, �̸�, ���̵�, �н�����, tel >> 5��
		String[][] datas = new String[20][colNames.length];
		
		List<MemberVO> list = dao.selectAll();

//		for (int i = 0; i < datas.length; i++) {
//			datas[i] = new String[] { "" + (i + 1), "id", "pw", "name", "tel" };
//		}
		
		for(int i=0; i<list.size(); i++) {
			MemberVO vo = list.get(i);
			datas[i] = new String[] { "" + (i + 1), vo.getId(), vo.getPw(), vo.getName(), vo.getTel()};
		}
		

		// ��ũ�� ���� >> jtable�� �־�� �ؼ� ������ ����
		// ���������� �����Ͱ� �� datas, columnNames�� �־��ش�.
		jtable = new JTable(datas, colNames);
		
		
		// ���� ��ü�� �ƴ� �� ��ü ���� Ư�� ������ Ŭ���� �ϰ� �ִ� ���̴ϱ� ���콺�� �̺�Ʈ�� ����
		jtable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// ���콺�� Ŭ���ϱ� �ߴµ� �� ��°������ ��
				// System.out.println("click...");
				
				// �׷��� �̷��� ���� �˾ƺ�
				// System.out.println(jtable.getSelectedRow());
				
				// �ѹ��� �˾ƾ� �Ǵµ� ������ �ѹ� +1�̶�� �����ϸ� �߰��� �����Ͱ� �������� �� ������ �߻��Ѵ�.
				// 0���� �� �´� ���� ������ �ִ� ��
				// System.out.println(datas[jtable.getSelectedRow()][0]);
				
				// >> �����ڿ� ��ȣ�� �ָ� �� ��ȣ��� ������� ������ �ȴ�.
				String num = datas[jtable.getSelectedRow()][0];
				
				new UpdatePage(num);	// �����ڿ� �����ε��� �����༭ ó���� ��������
			}
		});
		
		
		con.add(new JScrollPane(jtable), "Center");
		
		insertBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("insert button event");
				new InsertPage();
			}
		});
		
		// ��ư ����
		con.add(insertBtn, "South");

		// ��� ����
		setTitle("Select Page");

		// ��ġ �� ũ��
		setBounds(550, 250, 400, 300);

		// ���������� ����
		setVisible(true);
	}

}
