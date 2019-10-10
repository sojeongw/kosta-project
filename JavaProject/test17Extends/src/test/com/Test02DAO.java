package test.com;

public class Test02DAO {
	
	Test02Student vo;
	
	public Test02DAO() {
		
	}
	
	public Test02DAO(Test02Student vo) {
		// 객체 생성할 때 student 타입을 줘야 한다.
		// person vo를 받는다면 student, person, teacher 다 됨.
		// 멤버필드를 초기화 하기 위해 생성자를 만드는 거니까
		// 결국 멤버 변수가 있다는 뜻
		
		this.vo = vo;
	}
	
	public Test02DAO(Test02Animal vo) {
		//this.vo = (Test02Human)vo;	에러
		
		
	}
	
	public int insert(Test02Instructor vo) {
		return 0;
	}
	
	
	
	
	// 오버로딩
	public int insert(Test02Human vo) {
		return 0;
	}
	
	public Test02Student[] selectAll() {
		return null;
	}
	
	public Test02Student selectOne(Test02Human vo) {
		// return new Test02Student(); 
		// return new Test02Teacher(); 
		return null;
	}

}	// end of class
