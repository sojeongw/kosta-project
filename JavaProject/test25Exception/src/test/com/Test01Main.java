package test.com;

import java.util.List;

public class Test01Main {

	public static void main(String[] args) {

		System.out.println("jdbc");

		// // Class.forName("oracle.jdbc.OracleDriver");
		// // or �� path�� ���� ������ ã�� �� �ִ�.
		// try {
		// Class.forName("test.com.Test01Main");
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("jdbc successed");

		// �Ʒ��� DAO�� �Ű� ��ü�� �������ָ� ����ȴ�.
		// try {
		// Class.forName("oracle.jdbc.OracleDriver");
		// System.out.println("jdbc successed");
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// System.out.println("jdbc failed");
		// e.printStackTrace();
		// }

		// �����ڸ� ���� ����̹� ����
		Test01DAOimpl dao = new Test01DAOimpl();

		///// insert
		// ���� ��Ű�� ������ �ҷ��� �� �־�� �ϴϱ� �ּ��� default�̸� int�� ��ȯ�ϴ� int�� ����
		Test01VO vo1 = new Test01VO();
		vo1.setNum(1);
		vo1.setName("kim");
		
		Test01VO vo2 = new Test01VO();
		vo2.setNum(2);
		vo2.setName("lee");
		
		Test01VO vo3 = new Test01VO();
		vo3.setNum(3);
		vo3.setName("park");
		
		Test01VO vo4 = new Test01VO();
		vo4.setNum(4);
		vo4.setName("wang");
		
		Test01VO vo5 = new Test01VO();
		vo5.setNum(5);
		vo5.setName("jang");

		int result = dao.insert(vo1);
		result = dao.insert(vo2);
		result = dao.insert(vo3);
		result = dao.insert(vo4);
		result = dao.insert(vo5);
		
		if (result == 1) {
			System.out.println("insert succeeded");
		} else {
			System.out.println("insert failed");
		}	// end of if
		
		
		
		///// selectAll
		List<Test01VO> list = dao.selectAll();
		System.out.println(list);
		System.out.println(list.size());
		for (Test01VO x : list) {
			System.out.println(x.getNum());
			System.out.println(x.getName());
		}
		
		
		///// update
		Test01VO vo6 = new Test01VO();
		vo6.setNum(2);
		vo6.setName("lee");
		
		int result2 = dao.update(vo6);
		if(result2 == 1) {
			System.out.println("update suceeded");
		}	 // end of if
		
		
		///// delete
		Test01VO vo7 = new Test01VO();
		vo7.setNum(2);
		
		int result3 = dao.delete(vo7);
		if(result2 == 1) {
			System.out.println("delete suceeded");
		}else {
			System.out.println("delete failed");
		}	// end of if
		
		
		///// selectOne
		Test01VO vo8 = dao.selectOne(vo4);
		
		
		
		
		
		
		
		

	}		// end of main

}		// end of class
