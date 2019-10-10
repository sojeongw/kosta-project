package test.com;

import java.awt.Rectangle;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectPage extends JFrame {
	private JTable table;
	
	public SelectPage() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		// 이너클래스에서 사용할 때 final을 붙여줘야 버전이 바뀌어도 인식한다.
		final String[][] datas = new String[][] {
			{"1", "T", "C", "W", "R"},
			{"2", "T", "C", "W", "R"},
			{"3", "T", "C", "W", "R"},
			{"4", "T", "C", "W", "R"},
			{"5", "T", "C", "W", "R"},
		};
		
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println(datas[table.getSelectedRow()][0]);
				
				// 데이터를 넘기기 위해
				String num = datas[table.getSelectedRow()][0];
				System.out.println(num);
				new UpdatePage(num);
				
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
