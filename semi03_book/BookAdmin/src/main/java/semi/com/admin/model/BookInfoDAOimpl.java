package semi.com.admin.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookInfoDAOimpl implements BookInfoDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int book_insert(BookInfoVO vo) {
		int flag = 0;

		flag = sqlSession.insert("book_insert", vo);

		return flag;
	}

	@Override
	public int book_update(BookInfoVO vo) {
		int flag = 0;

		flag = sqlSession.update("book_update", vo);

		return flag;

	}

	@Override
	public int book_delete(BookInfoVO vo) {
		int flag = 0;

		flag = sqlSession.delete("book_delete", vo);

		return flag;
	}

	@Override
	public int book_return(BookInfoVO vo) {
		
		int flag = 0;

		flag = sqlSession.update("book_return", vo);

		return flag;
	}

	@Override
	public List<BookInfoVO> book_selectAll() {

		List<BookInfoVO> list = sqlSession.selectList("book_selectAll");

		return list;
	}

	

}
