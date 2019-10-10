package test.com.model;

import java.util.List;

public interface TestDAO {

	public int insert(TestVO vo);
	public int update(TestVO vo);
	public int delete(TestVO vo);
	public TestVO selectOne(TestVO vo);
	public List<TestVO> selectAll();
	
	
}
