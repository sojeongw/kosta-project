package test.com.spring03.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.com.spring03.model.BoardVO;

@Repository
public class BoardDAOimpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insert(BoardVO vo) {
		System.out.println("insert(boardVO vo)");

		int flag = 0;
		// 내가 찾아가야될 sql 아이디 + 넘겨줄 데이터
		flag = sqlSession.insert("insert", vo);

		return flag;
	}

	@Override
	public int update(BoardVO vo) {
		System.out.println("update(boardVO vo)");
		int flag = 0;
		// 내가 찾아가야될 sql 아이디 + 넘겨줄 데이터
		flag = sqlSession.update("update", vo);
		return flag;
	}

	@Override
	public int delete(BoardVO vo) {
		System.out.println("delete(boardVO vo)");
		int flag = 0;
		// 내가 찾아가야될 sql 아이디 + 넘겨줄 데이터
		flag = sqlSession.delete("delete", vo);
		return flag;
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		System.out.println("selectOne(boardVO vo)");
		BoardVO bvo = new BoardVO();
		// 내가 찾아가야될 sql 아이디 + 넘겨줄 데이터
		bvo = sqlSession.selectOne("selectOne", vo);
		return bvo;
	}

	@Override
	public List<BoardVO> selectAll() {
		System.out.println("selectAll()");
		List<BoardVO> list = sqlSession.selectList("selectAll");

		return list;
	}

}
