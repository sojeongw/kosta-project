package kosta.board;

import java.util.List;

public interface Test03BoardDAO {
	
	public int insert(Test03BoardVO bvo);	
	public int update(Test03BoardVO bvo);
	public int delete(Test03BoardVO bvo);
	public Test03BoardVO selectOne(Test03BoardVO bvo);
	public List<Test03BoardVO>  selectAll();


}
