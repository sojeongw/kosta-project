package test.com.spring04Member.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class MemberDAOimpl implements MemberDAO {

	@Autowired
	SqlSession sqlSession;
	

	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert(MemberVO vo)");

		int flag = sqlSession.insert("insert", vo);

		return flag;
	}

	@Override
	public int update(MemberVO vo) {
		System.out.println("update(MemberVO vo)");
		int flag = sqlSession.update("update", vo);

		return flag;
	}

	@Override
	public int delete(MemberVO vo) {
		System.out.println("delete(MemberVO vo)");
		int flag = sqlSession.delete("delete", vo);

		return flag;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("selectOne(MemberVO vo)");
		MemberVO mvo = sqlSession.selectOne("selectOne", vo);

		return mvo;
	}

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("selectAll()");
		List<MemberVO> list =sqlSession.selectList("selectAll");

		return list;
	}

}
