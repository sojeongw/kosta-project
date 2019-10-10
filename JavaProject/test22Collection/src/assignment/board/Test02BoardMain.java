package assignment.board;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test02BoardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �־��� Test02BoardDAO interface��
		// ��ӹ޴� Ŭ����(Test02BoardDAOimpl)�� �����ϰ�
		// �� �޼ҵ���� ���ϰ� ����Ͻÿ�
		// ���� : Test02BoardDAOimple ��ü�� ���� �������� �� �� = ������ �̿�
		
		
		Test02BoardDAO dao = new Test02BoardDAOimpl();
		Test02BoardVO vo = new Test02BoardVO();
		
		
		///// 1. insert
		
		vo.setNum(1);
		vo.setTitle("1�� ����");
		vo.setContent("1�� ����");
		vo.setName("1�� �̸�");
		dao.insert(vo);
		
		vo.setNum(2);
		vo.setTitle("2�� ����");
		vo.setContent("2�� ����");
		vo.setName("2�� �̸�");
		dao.insert(vo);
		
		vo.setNum(3);
		vo.setTitle("3�� ����");
		vo.setContent("3�� ����");
		vo.setName("3�� �̸�");
		dao.insert(vo);
	
		
		///// 2. update
		Test02BoardVO vo2 = new Test02BoardVO();
		vo2.setNum(1);
		vo2.setTitle("1�� ����");
		vo2.setContent("1�� ����");
		vo2.setName("1�� ����");
		dao.update(vo2);

		///// 3. delete
		vo.setNum(2);
		dao.delete(vo);
		
		///// 4. selectOne
		vo.setNum(2);
		dao.selectOne(vo);
		
		
		///// 5. select all
		List<Test02BoardVO> list = dao.selectAll();
		
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
		for(Test02BoardVO x : list) {
			System.out.print(x.getNum() + "\t");
			System.out.print(x.getTitle()+ "\t");
			System.out.print(x.getContent() + "\t");
			System.out.print(x.getDate() + "\t");
			System.out.println("");
		}

		
		
	}		// end of main
	
}		// end of class
