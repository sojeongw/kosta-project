package test.com.model;

import java.util.List;

public interface TestDAO {

	public List<TestVO> json_selectAll();
	public TestVO json_selectOne(TestVO vo);

}
