package test.com.service;

import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;
import java.util.*;

public class MemberService {
	
	// 얘를 콜하면 실제로 dao에 있는 함수를 불러온 것 처럼 리턴을 받아야 한다 >> dao 객체 생성
	private MemberDAO dao = new MemberDAOimpl();

	public int insert(MemberVO vo) {
		return dao.insert(vo);
	}
	public int update(MemberVO vo) {
		return dao.update(vo);
	}
	public int delete(MemberVO vo) {
		return dao.delete(vo);
	}
	public MemberVO selectOne(MemberVO vo) {
		return dao.selectOne(vo);
	}
	public List<MemberVO> selectAll(){
		return dao.selectAll();
		
	}

}
