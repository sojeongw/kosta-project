package semi.com.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BookInfoDAOimpl implements BookInfoDAO {
	private static final Logger logger = LoggerFactory.getLogger(BookInfoDAOimpl.class);

	@Autowired
	SqlSession sqlSession;


	@Override
	public int book_insert(BookInfoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int book_update(BookInfoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int book_delete(BookInfoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookInfoVO book_selectone(BookInfoVO vo) {
		System.out.println("book_selectone(BookInfoVO vo)");
		System.out.println(vo.getBook_num());
		
		BookInfoVO bvo = sqlSession.selectOne("book_selectone", vo);
		return bvo;
	}

	@Override
	public List<BookInfoVO> book_selectall(BookInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("book_selectall(BookInfoVO vo) "+sqlSession);
		List<BookInfoVO> list = sqlSession.selectList("book_selectall");
		
		return list;
	}


	

}
