package assignment.member;

import java.util.List;

public interface MemberDAO {
	
	public int insert(MemberVO vo);
	public int update(MemberVO vo);
	public int delete(MemberVO vo);
	public List<MemberVO> selectAll();
	public List<MemberVO> selectOne(MemberVO vo);
}
