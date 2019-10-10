package test.com;

public class Test03memberDAO {
	private Test03memberVO mVO;
	
	// 1.insert
	public void insert(Test03memberVO mVO) {
		System.out.println("insert()");
		System.out.println(mVO.getNum());
		System.out.println(mVO.getId());
		System.out.println(mVO.getPw());
		System.out.println(mVO.getName());
		System.out.println(mVO.getTel());
	}
	
	// 2.select
	public void select(Test03memberVO mVO) {
		System.out.println("select()");
		System.out.println(mVO.getNum());
		System.out.println(mVO.getId());
		System.out.println(mVO.getPw());
		System.out.println(mVO.getName());
		System.out.println(mVO.getTel());
	}
	
	// 3.update
	public void update(Test03memberVO mVO) {
		System.out.println("update()");
		System.out.println(mVO.getNum());
		System.out.println(mVO.getId());
		System.out.println(mVO.getPw());
		System.out.println(mVO.getName());
		System.out.println(mVO.getTel());
	}
	
	// 4. delete
	public void delete(Test03memberVO mVO) {
		System.out.println("delete()");
		System.out.println(mVO.getNum());
		System.out.println(mVO.getId());
		System.out.println(mVO.getPw());
		System.out.println(mVO.getName());
		System.out.println(mVO.getTel());
	}

}
