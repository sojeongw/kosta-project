package test.com;

public class Test01member {
	
	/* 번호, 아이디, 비밀번호, 이름, 전화번호
	* DTO(Data Transfer Object) : 데이터만 전달하기 위한 오브젝트냐(DB)
	* VO(Value Object) : 값만 전달하는 것이냐(코딩)
	* data와 value의 차이는 없다고 생각하면 된다.
	* ex.StudentDTO, MemberVO
	*/
	
	/* 입력 insert, create, 수정 update, modify, 삭제 delete, remove 검색 select, select, read
	* = CRUD(Create, Read, Update, Delete) >>> 장기적으로 보관할 수 있는 공간
	* = storage(개념적)
	* = database(물리적)
	* DAO(Data Access Object) : ex.score >> StudentDAO
	*/
	int num;
	String id;
	String pw;
	String name;
	String tel;
	
	Test01member(){
		System.out.println("Test01member()");
		num = 1156789;
		id = "wang";
		pw = "1234";
		name = "박보검";
		tel = "0262152800";
	}
	
	// 인자 있는 생성자
	Test01member(int num, String id, String pw, String name, String tel){
		System.out.println("Test01member(int num, String id, String pw, String name, String tel)");
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	}

}
