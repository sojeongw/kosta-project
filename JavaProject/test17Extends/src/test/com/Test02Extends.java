package test.com;

public class Test02Extends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ��� ������ �� ��ü�� '���' �� �� ���� �� �ִ��� �����
		// object�� �����ؼ� ��������� �Ѵ�.
		
		Object obj1 = new Object();
		Object obj2 = new Test02Animal();
		Object obj3 = new Test02Human();
		Object obj4 = new Test02Instructor();
		Object obj5 = new Test02Student();

		///// ����
		Test02Animal a01 = new Test02Animal();
		a01.move();
		Test02Animal a02 = new Test02Human();
		Test02Animal a03 = new Test02Instructor();
		Test02Animal a04 = new Test02Student();

		System.out.println("----------------");
		
		///// �ΰ�
		Test02Human h01 = new Test02Human();
		Test02Human h02 = new Test02Student();
		Test02Human h03 = new Test02Instructor();
		h01.talk();
		
		System.out.println("----------------");

		///// ����
		Test02Instructor i01 = new Test02Instructor();
		i01.teach();
		System.out.println("----------------");

		///// �л�
		Test02Student s01 = new Test02Student();
		s01.study();
		
//		///// ĳ����
//		// �θ��� �����ڷ� ����� ĳ����, �ڽ��� �����ڷ� ����� ������
//		// ????????????��???
//		Test02Instructor i02 = (Test02Instructor)h03;
//		Test02Instructor i03 = (Test02Instructor)a04;
//		Test02Instructor i04 = (Test02Instructor)obj5;
//		// human���� ��������� animal ��� ����
//		System.out.println(i02.hands);
		
		Test02DAO dao = new Test02DAO();
		dao.insert(i01);
		dao.insert((Test02Instructor)h03);
		dao.insert(h01);
		dao.insert(h02);
		
		
		Test02DAO dao2 = new Test02DAO(new Test02Human());
		Test02DAO dao3 = new Test02DAO(new Test02Student());
		Test02DAO dao4 = new Test02DAO(new Test02Instructor());
		
		System.out.println("----------------");
		
		Test02DAO dao5 = new Test02DAO();
		
		// �������̵� : �θ� Ŭ������ �ִ� �޼ҵ带 �̸��� ������ �ٸ� �ɷ� ���꿡 �������� ��
		// ������ : �׳� call�� �ϴ� �� �ƴ϶� ������ ��
		
		

	}		// end of main

}		// end of class
