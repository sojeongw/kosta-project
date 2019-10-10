package project.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import project.model.RoomDAO;
import project.model.RoomDAOimpl;
import project.model.RoomVO;

public class SelectPage extends JFrame {

	private JTable table;
	private JButton OK_Btn = new JButton("확인");
	
	public SelectPage() {
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		RoomDAO dao = new RoomDAOimpl();
		List<RoomVO> list = dao.selectAll();
		
		System.out.println(list.size());
		
		final String[][] datas = new String[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			String[] row = new String[] {
					String.valueOf(list.get(i).getR_num()),
					list.get(i).getR_name(),
					String.valueOf(list.get(i).getWindow_cnt()),
					String.valueOf(list.get(i).getDoor_cnt())};
			
			datas[i] = row;
		}
		
		// list에 스크롤 만들어주는 생성자 //
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String num = datas[table.getSelectedRow()][0];
				// table의 row(행)에서 0번째 index(?)를 num으로 한다.
				System.out.println(num);
			}
		});
		
		table.setModel(new DefaultTableModel(datas,
			new String[] {
				"방순번", "방이름", "창문갯수", "방문갯수"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		// 목록 화면에서 "확인" button event
		OK_Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		con.add(OK_Btn,"South");
		
		setTitle("방 목록");
		setBounds(0, 0, 400, 300);
		setVisible(true);
	}
	
}
