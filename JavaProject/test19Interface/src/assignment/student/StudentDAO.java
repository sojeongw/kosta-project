package assignment.student;

public interface StudentDAO {
	
	public void insert(StudentVO vo);
	public void update(StudentVO vo);
	public void delete(StudentVO vo);
	public StudentVO[] selectAll();
	public void selectOne(StudentVO vo);

}
