package semi.com.admin.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CheckOutDAOimpl implements CheckOutDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int book_return_delete(CheckOutVO vo) {
		int flag = 0;

		flag = sqlSession.delete("book_return_delete", vo);

		return flag;
	}

	@Override
	public List<CheckOutVO> book_checkout_selectAll() {
		
		List<CheckOutVO> list = sqlSession.selectList("book_checkout_selectAll");

		return list;
	}

	
}
