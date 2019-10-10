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
	// jtable은 안에 있든 밖에 있든 상관없다.
	// 일단 null 처리를 하고 생성자 안에서 정보를 넣어 가공한다.
	private JTable jtable;

	public SelectPage() {
				
		// dao.selectAll();
		
		// 컨테이너 세팅
		Container con = getContentPane();
		// 레이아웃 세팅
		// con.setLayout(new GridLayout(2, 1));
		
		// 레이아웃 조정
		con.setLayout(new BorderLayout());

		// 사용될 배열 선언
		String[] colNames = new String[] { "NUM", "ID", "PW", "NAME", "TEL" };
		// 행은 모르겠지만 열은 넘버, 이름, 아이디, 패스워드, tel >> 5개
		String[][] datas = new String[20][colNames.length];
		
		List<MemberVO> list = dao.selectAll();

//		for (int i = 0; i < datas.length; i++) {
//			datas[i] = new String[] { "" + (i + 1), "id", "pw", "name", "tel" };
//		}
		
		for(int i=0; i<list.size(); i++) {
			MemberVO vo = list.get(i);
			datas[i] = new String[] { "" + (i + 1), vo.getId(), vo.getPw(), vo.getName(), vo.getTel()};
		}
		

		// 스크롤 세팅 >> jtable을 넣어야 해서 전역에 선언
		// 실질적으로 데이터가 될 datas, columnNames를 넣어준다.
		jtable = new JTable(datas, colNames);
		
		
		// 단일 객체가 아닌 그 객체 안의 특정 영역을 클릭을 하고 있는 것이니까 마우스로 이벤트를 받음
		jtable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 마우스를 클릭하긴 했는데 몇 번째인지는 모름
				// System.out.println("click...");
				
				// 그래서 이렇게 행을 알아봄
				// System.out.println(jtable.getSelectedRow());
				
				// 넘버도 알아야 되는데 무조건 넘버 +1이라고 설정하면 중간에 데이터가 지워졌을 때 문제가 발생한다.
				// 0열일 때 맞는 행을 가져다 주는 법
				// System.out.println(datas[jtable.getSelectedRow()][0]);
				
				// >> 생성자에 번호를 주면 그 번호대로 결과값이 나오게 된다.
				String num = datas[jtable.getSelectedRow()][0];
				
				new UpdatePage(num);	// 생성자에 오버로딩을 안해줘서 처음엔 에러난다
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
		
		// 버튼 세팅
		con.add(insertBtn, "South");

		// 상단 정보
		setTitle("Select Page");

		// 위치 및 크기
		setBounds(550, 250, 400, 300);

		// 보여지도록 설정
		setVisible(true);
	}

}
