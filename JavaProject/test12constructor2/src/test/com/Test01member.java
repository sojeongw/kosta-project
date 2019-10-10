package test.com;

public class Test01member {
	
	/* ��ȣ, ���̵�, ��й�ȣ, �̸�, ��ȭ��ȣ
	* DTO(Data Transfer Object) : �����͸� �����ϱ� ���� ������Ʈ��(DB)
	* VO(Value Object) : ���� �����ϴ� ���̳�(�ڵ�)
	* data�� value�� ���̴� ���ٰ� �����ϸ� �ȴ�.
	* ex.StudentDTO, MemberVO
	*/
	
	/* �Է� insert, create, ���� update, modify, ���� delete, remove �˻� select, select, read
	* = CRUD(Create, Read, Update, Delete) >>> ��������� ������ �� �ִ� ����
	* = storage(������)
	* = database(������)
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
		name = "�ں���";
		tel = "0262152800";
	}
	
	// ���� �ִ� ������
	Test01member(int num, String id, String pw, String name, String tel){
		System.out.println("Test01member(int num, String id, String pw, String name, String tel)");
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	}

}
