package assignment.student;

import java.util.List;

public interface StudentDAO {
	
	public int insert(StudentVO vo);
	public int update(StudentVO vo);
	public int delete(StudentVO vo);
	public List<StudentVO> selectAll();
	public StudentVO selectOne(StudentVO vo);

}
