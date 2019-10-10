package test.com.spring01.model;

import java.util.List;

public interface TestDAO {
	
	public int insert(TestVO vo);

	public TestVO selectOne(TestVO vo);
	
	public List<TestVO> selectAll();

	public int update(TestVO vo);
	
	public int delete(TestVO vo);

}
