package test.com;

public class Test02DAO {
	
	Test02Student vo;
	
	public Test02DAO() {
		
	}
	
	public Test02DAO(Test02Student vo) {
		// ��ü ������ �� student Ÿ���� ��� �Ѵ�.
		// person vo�� �޴´ٸ� student, person, teacher �� ��.
		// ����ʵ带 �ʱ�ȭ �ϱ� ���� �����ڸ� ����� �Ŵϱ�
		// �ᱹ ��� ������ �ִٴ� ��
		
		this.vo = vo;
	}
	
	public Test02DAO(Test02Animal vo) {
		//this.vo = (Test02Human)vo;	����
		
		
	}
	
	public int insert(Test02Instructor vo) {
		return 0;
	}
	
	
	
	
	// �����ε�
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
