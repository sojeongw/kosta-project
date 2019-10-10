package test.com.spring04.model;

import java.util.List;

import test.com.spring04.model.MemberVO;

public interface MemberDAO {
	
	public int insert(MemberVO vo);
	public int update(MemberVO vo);
	public int delete(MemberVO vo);
	public MemberVO selectOne(MemberVO vo);
	public List<MemberVO> selectAll();


}
