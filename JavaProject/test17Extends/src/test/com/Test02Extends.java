package test.com;

public class Test02Extends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 상속 관계일 때 객체를 '모두' 몇 개 만들 수 있는지 물어보면
		// object도 포함해서 설명해줘야 한다.
		
		Object obj1 = new Object();
		Object obj2 = new Test02Animal();
		Object obj3 = new Test02Human();
		Object obj4 = new Test02Instructor();
		Object obj5 = new Test02Student();

		///// 동물
		Test02Animal a01 = new Test02Animal();
		a01.move();
		Test02Animal a02 = new Test02Human();
		Test02Animal a03 = new Test02Instructor();
		Test02Animal a04 = new Test02Student();

		System.out.println("----------------");
		
		///// 인간
		Test02Human h01 = new Test02Human();
		Test02Human h02 = new Test02Student();
		Test02Human h03 = new Test02Instructor();
		h01.talk();
		
		System.out.println("----------------");

		///// 교사
		Test02Instructor i01 = new Test02Instructor();
		i01.teach();
		System.out.println("----------------");

		///// 학생
		Test02Student s01 = new Test02Student();
		s01.study();
		
//		///// 캐스팅
//		// 부모의 생성자로 만들면 캐스팅, 자식의 생성자로 만들면 다형성
//		// ????????????응???
//		Test02Instructor i02 = (Test02Instructor)h03;
//		Test02Instructor i03 = (Test02Instructor)a04;
//		Test02Instructor i04 = (Test02Instructor)obj5;
//		// human으로 만들었지만 animal 사용 가능
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
		
		// 오버라이딩 : 부모 클래스에 있는 메소드를 이름은 같은데 다른 걸로 서브에 재정의할 때
		// 재정의 : 그냥 call만 하는 게 아니라 수정한 거
		
		

	}		// end of main

}		// end of class
