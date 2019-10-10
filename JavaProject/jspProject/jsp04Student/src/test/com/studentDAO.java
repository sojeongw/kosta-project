package test.com;

import java.util.List;

public interface studentDAO {
	
	public int insert(studentVO vo);
	public int update(studentVO vo);
	public int delete(studentVO vo);
	public studentVO selectOne(studentVO vo);
	public List<studentVO> selectAll();

}
