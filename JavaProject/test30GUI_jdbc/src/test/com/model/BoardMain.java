package test.com.model;

import java.util.List;

import test.com.view.SelectPage;

public class BoardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �� ������Ʈ�� �� ���ư����� Ȯ��
		System.out.println("board");
		
		// ��ĥ �� ���ε��� �ҷ�����. �Ѳ����� �ҷ����� ���ϴ� ��.
		// �ϳ��� �Ǵ��� Ȯ���ϸ鼭 ��������.
		// ���� �𵨺��� �ϴ� �� ����. Ŭ���� ���̾�׷��� �ݹ� ������ ����.
		// Ŭ���� ���̾�׷��� �������� �װ� ���鼭 ������ �׽�Ʈ �ұ�?
		// VO���� �ұ�? VO ������ �ϴ� ��
		
		// 1.insert
		//BoardVO vo = new BoardVO();
		// num�� ���� �� �ʿ� ����
		//vo.setTitle("title");
		//vo.setContent("content");
		//vo.setWriter("kim");
		
		// ���� get set���� �� �ƴ��� Ȯ���غ� �� �ִ�		
//		System.out.println(vo.getTitle());
//		System.out.println(vo.getContent());
//		System.out.println(vo.getWriter());
//		System.out.println(vo.getRegDate());
		// �׽�Ʈ ������ ���ش�
		
		// DAO�� �����
		// impl�� �����
		//BoardDAO dao = new BoardDAOimpl();
		//int result = dao.insert(vo);	// ���� �ްڴ�.
		
		// insert page�� �����´�
		// �̶� select�� �� �����Դٰ� �������� select�� �ҷ����� ��� ���ľ� �Ǵϱ�
		// �ϴ� insert�� Ȯ���ϱ� ���� �ּ�ó�� �صд�.
		// ���� ���� �ִ� �ֵ��� ������ �� �ƴ϶� 
//		new InsertPage(); // �� �������ش�. ���� �� �ּ�ó�� �Ѵ�.
		
		// ������ �׽�Ʈ �Ϸ�� �κе��� ��ư�� ���� �� �������� �����ؼ� insertpage�� ��������.
		
		// ���� select
		new SelectPage();
		
		// select() �׽�Ʈ
//		BoardDAO dao = new BoardDAOimpl();
//		List<BoardVO> list = dao.selectAll();
//		System.out.println(list.size());
//		for(int i=0; i<list.size(); i++) {
//			System.out.print(list.get(i).getNum() + " ");
//			System.out.print(list.get(i).getTitle() + " ");
//			System.out.print(list.get(i).getContent() + " ");
//			System.out.print(list.get(i).getWriter() + " ");
//			System.out.println(list.get(i).getRegDate() + " ");
//		}
		// �׽�Ʈ �� ������ �ּ����� ó���ϰ� select page�� �ű��. �׸��� selectpage �����ڸ� ���⿡ �ҷ��´�.
		new SelectPage();
		
	}

}
