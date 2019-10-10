package test.com.view;

import java.awt.Rectangle;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import test.com.model.BoardDAO;
import test.com.model.BoardDAOimpl;
import test.com.model.BoardVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class SelectPage extends JFrame {
	private JTable table;
	
	public SelectPage() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		// �̳�Ŭ�������� ����� �� final�� �ٿ���� ������ �ٲ� �ν��Ѵ�.
//		final String[][] datas = new String[][] {
//			{"1", "T", "C", "W", "R"},
//			{"2", "T", "C", "W", "R"},
//			{"3", "T", "C", "W", "R"},
//			{"4", "T", "C", "W", "R"},
//			{"5", "T", "C", "W", "R"},
//		};
		
		// ���� ���� ���
		BoardDAO dao = new BoardDAOimpl();
		List<BoardVO> list = dao.selectAll();
		// System.out.println(list.size());
		
		final String[][] datas = new String[list.size()][5];
		// ���⿡ String �迭 Ÿ���� ���� �ϴϱ� ������ش�
		for(int i=0; i<list.size(); i++) {
											// int Ÿ���̶� string���� ����
			String[] row = new String[] {String.valueOf(list.get(i).getNum()), list.get(i).getTitle(),
								list.get(i).getTitle(),list.get(i).getContent(),
								list.get(i).getWriter(),list.get(i).getRegDate().toString()};
																// date ��ü�ϱ� string���� ��������
			
			datas[i] = row;
		}
		
		
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println(datas[table.getSelectedRow()][0]);
				
				// �����͸� �ѱ�� ����
				String num = datas[table.getSelectedRow()][0];
				System.out.println(num);
				// new UpdatePage(num);
				
			}
		});
		
		table.setModel(new DefaultTableModel(datas,
			new String[] {
				"NUM", "TITLE", "CONTENT", "WRITER", "REG_DATE"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		
		
		JButton insertBtn = new JButton("insertBtn");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		getContentPane().add(insertBtn, BorderLayout.SOUTH);
		
		
		
		setBounds(new Rectangle(500, 0, 500, 300));
		setTitle("Select Page");
		setVisible(true);
	}

}
