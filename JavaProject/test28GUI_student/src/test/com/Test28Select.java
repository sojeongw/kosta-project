package test.com;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Test28Select extends JFrame{
	
	private JButton insertBtn = new JButton("ȸ������");
	private JTable jtable;
	
	public Test28Select() {
		// �����̳�
		Container con = getContentPane();
		
		// ���̾ƿ�
		//con.setLayout(new GridLayout(2, 1));
		con.setLayout(new BorderLayout());
		
		// �迭
		String[] colNames = new String[] {"NUM","NAME","KOR","ENG","MATH","TOTAL","AVG","GRADE"};
		String[][] datas = new String[20][colNames.length];
		
		for(int i = 0; i<datas.length; i++) {
			datas[i] = new String[] {""+(i+1),"NAME"+(i+1),"KOR","ENG","MATH","TOTAL","AVG","GRADE"};
		}
		
		// ���̺�
		jtable = new JTable(datas, colNames);
		
		// �̺�Ʈ
		jtable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// System.out.println("mouse adaptor");
				// System.out.println(jtable.getSelectedRow());
				System.out.println(datas[jtable.getSelectedRow()][0]);
				String num = datas[jtable.getSelectedRow()][0];
				new Test28Update(num);
			}
		});
		
		
		insertBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("insert OK");	
				new Test28Insert();
			}
		});
		
		// add
		con.add(new JScrollPane(jtable), "Center");
		//con.add(new JLabel(""));
		con.add(insertBtn, "South");
		
		// �⺻ ����
		setTitle("Select Page");
		setBounds(250, 250, 800, 350);
		setVisible(true);
		
	}

}
