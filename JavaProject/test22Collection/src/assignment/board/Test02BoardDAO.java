package assignment.board;

import java.util.List;

public interface Test02BoardDAO {

	public int insert(Test02BoardVO vo);
	public int update(Test02BoardVO vo);
	public int delete(Test02BoardVO vo);
	public List<Test02BoardVO>  selectOne(Test02BoardVO vo);
	public List<Test02BoardVO> selectAll();
	
	
	
}	// end of interface
