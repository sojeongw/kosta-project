package test.com;

import java.util.Date;

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
		vo.setTitle("1�� ����");
		vo.setContent("1�� ����");
		vo.setName("1�� �̸�");
		dao.insert(vo);
		
		vo.setTitle("2�� ����");
		vo.setContent("2�� ����");
		vo.setName("2�� �̸�");
//		dao.insert(vo);
		
	
		
		
		
		///// 2. update
		vo.setNum(2);
		vo.setTitle("2�� ���� ����");
		vo.setContent("2�� ���� ����");
		vo.setName("2�� �̸� ����");
		dao.update(vo);

		///// 3. delete
		vo.setNum(2);
		dao.delete(vo);
		
		///// 4. selectOne
		vo.setNum(2);
		dao.selectOne(vo);
		
		
		///// 5. select all
		Test02BoardVO[] vos = dao.selectAll();
		for(int i=0; i<vos.length; i++) {
			System.out.print(vos[i].getNum() + "\t");
			System.out.print(vos[i].getTitle() + "\t");
			System.out.print(vos[i].getContent() + "\t");
			System.out.print(vos[i].getName() + "\t");
			System.out.print(vos[i].getDate() + "\n");
		}
		
		
	}		// end of main
	
}		// end of class
