package test.com;

import java.util.List;

public interface Test01DAO {
	
	public int insert(Test01VO vo);
	public int update(Test01VO vo);
	public List<Test01VO> selectAll();
	public int delete(Test01VO vo);
	public Test01VO selectOne(Test01VO vo);
	

}
