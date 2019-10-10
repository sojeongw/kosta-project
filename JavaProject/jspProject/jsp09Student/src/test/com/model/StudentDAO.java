package test.com.model;

import java.util.List;

public interface StudentDAO {
	
	public int insert(StudentVO vo);
	public int update(StudentVO vo);
	public int delete(StudentVO vo);
	public StudentVO selectOne(StudentVO vo);
	public List<StudentVO> selectAll();

}
