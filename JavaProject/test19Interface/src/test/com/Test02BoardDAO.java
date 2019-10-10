package test.com;

public interface Test02BoardDAO {

	public int insert(Test02BoardVO vo);
	public int update(Test02BoardVO vo);
	public int delete(Test02BoardVO vo);
	public Test02BoardVO  selectOne(Test02BoardVO vo);
	public Test02BoardVO[] selectAll();
	
	
	
}	// end of interface
