package test.com.spring04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.spring04.model.MemberDAO;
import test.com.spring04.model.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;

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
