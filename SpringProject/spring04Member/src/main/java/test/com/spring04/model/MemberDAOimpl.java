package test.com.spring04.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.com.spring04.model.MemberVO;

@Repository
public class MemberDAOimpl implements MemberDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert(MemberVO vo)");

		int flag = 0;
		// 내가 찾아가야될 sql 아이디 + 넘겨줄 데이터
		flag = sqlSession.insert("insert", vo);

		return flag;
	}

	@Override
	public int update(MemberVO vo) {
		System.out.println("update(MemberVO vo)");
		int flag = 0;
		// 내가 찾아가야될 sql 아이디 + 넘겨줄 데이터
		flag = sqlSession.update("update", vo);
		return flag;
	}

	@Override
	public int delete(MemberVO vo) {
		System.out.println("delete(MemberVO vo)");
		int flag = 0;
		// 내가 찾아가야될 sql 아이디 + 넘겨줄 데이터
		flag = sqlSession.delete("delete", vo);
		return flag;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("selectOne(MemberVO vo)");
		MemberVO bvo = new MemberVO();
		// 내가 찾아가야될 sql 아이디 + 넘겨줄 데이터
		bvo = sqlSession.selectOne("selectOne", vo);
		return bvo;
	}

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("selectAll()");
		List<MemberVO> list = sqlSession.selectList("selectAll");

		return list;
	}

}
