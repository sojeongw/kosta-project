package test.com;

public class Test01Main {

	public static void main(String[] args) {

		// 1.����̹� ����
		Test01DAO dao = new Test01DAOimpl();

		Test01VO vo1 = new Test01VO();
		vo1.setName("bbbb");

		Test01VO vo2 = new Test01VO();
		vo2.setNum(2);
		vo2.setName("kim2");

		Test01VO vo3 = new Test01VO();
		vo3.setNum(3);
		vo3.setName("kim3");

		// 2.Connection(����ڻ���)

		// 3.
		// int result = dao.insert(vo1);
		// if (result == 1) {
		// System.out.println("insert successed..");
		// } else {
		// System.out.println("insert failed");
		// }
		/////////////////////////

		// Test01VO vo22 = new Test01VO();
		// vo22.setNum(19);
		// vo22.setName("lee");
		//
		// int result2 = dao.update(vo22);
		// if (result2 >= 1) {
		// System.out.println("update successed..");
		// } else {
		// System.out.println("update failed");
		// }
		// /////////////////////////
		//
		//

		Test01VO vo4 = new Test01VO();
		vo4.setNum(15);
		//Test01VO result44 = dao.selectOne(vo4);
		dao.selectOne(vo4);
		//System.out.println(result44.getNum() + ":" + result44.getName());
	
		// /////////////////////////
		// Test01VO vo33 = new Test01VO();
		// vo33.setNum(11);
		//
		// int result33 = dao.delete(vo33);
		// if (result33 >= 1) {
		// System.out.println("delete successed..");
		// } else {
		// System.out.println("delete failed");
		// }
		// /////////////////////////
		//
		//
		// List<Test01VO> list = dao.selectAll();
		// System.out.println(list);
		// System.out.println(list.size());
		// for (Test01VO x : list) {
		// System.out.println(x.getNum() + ":" + x.getName());
		// }

		/////////////////////////////////////////////////////////////

		// System.out.println("jdbc");

		/*
		 * Class.forName("oracle.jdbc.OracleDriver"); or �� path�� ���� ������ ã�� �� �ִ�.
		 * 
		 * try { Class.forName("test.com.Test01Main"); } catch (ClassNotFoundException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * System.out.println("jdbc successed");
		 */

		/*
		 * �Ʒ��� DAO�� �Ű� ��ü�� �������ָ� ����ȴ�. try { Class.forName("oracle.jdbc.OracleDriver");
		 * System.out.println("jdbc successed"); } catch (ClassNotFoundException e) {
		 * System.out.println("jdbc failed"); e.printStackTrace(); }
		 */

		// 1.�����ڸ� ���� ����̹� ����
		// Test01DAOimpl dao = new Test01DAOimpl();

		// 2.connection >> ����� ���� �ʿ�

		// 3.
		///// insert
		// ���� ��Ű�� ������ �ҷ��� �� �־�� �ϴϱ� �ּ��� default�̸� int�� ��ȯ�ϴ� int�� ����
		// Test01VO vo1 = new Test01VO();
		// vo1.setName("kim");
		//
		// int result = dao.insert(vo1);
		//
		// if (result == 1) {
		// System.out.println("insert succeeded");
		// } else {
		// System.out.println("insert failed");
		// } // end of if

		///// selectAll
		// List<Test01VO> list = dao.selectAll();
		// System.out.println(list);
		// System.out.println(list.size());
		// for (Test01VO x : list) {
		// System.out.println(x.getNum() + "\t" + x.getName());
		// }
		//
		//
		///// update
		// Test01VO vo6 = new Test01VO();
		// vo6.setNum(2);
		// vo6.setName("lee");
		//
		// int result2 = dao.update(vo6);
		// if(result2 == 1) {
		// System.out.println("update suceeded");
		// } else {
		// System.out.println("update failed");
		// }
		//
		//
		///// delete
		// Test01VO vo7 = new Test01VO();
		// vo7.setNum(2);
		//
		// int result3 = dao.delete(vo7);
		// if(result2 == 1) {
		// System.out.println("delete suceeded");
		// }else {
		// System.out.println("delete failed");
		// } // end of if
		//
		//
		///// selectOne
		// Test01VO vo8 = dao.selectOne(vo1);

	} // end of main

} // end of class
