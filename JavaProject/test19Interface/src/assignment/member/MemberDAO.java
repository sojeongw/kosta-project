package assignment.member;

public interface MemberDAO {
	
	public void insert(MemberVO vo);
	public void update(MemberVO vo);
	public void delete(MemberVO vo);
	public MemberVO[] selectAll();
	public void selectOne(MemberVO vo);
}
