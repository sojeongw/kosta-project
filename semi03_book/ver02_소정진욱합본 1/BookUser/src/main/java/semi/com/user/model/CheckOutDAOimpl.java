package semi.com.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CheckOutDAOimpl implements CheckOutDAO {
	private static final Logger logger = LoggerFactory.getLogger(CheckOutDAOimpl.class);

	@Autowired
	SqlSession sqlSession;

	@Override
	public int book_register(CheckOutVO vo) {
		// TODO Auto-generated method stub
		System.out.println("book_register(CheckOutVO vo)");
		System.out.println(vo.getCheckout_num());
		System.out.println(vo.getBook_num());
		System.out.println(vo.getUser_id());
		System.out.println(vo.getCheckout_start());
		System.out.println(vo.getCheckout_end());

		int flag = 0;
		flag = sqlSession.insert("book_register", vo);

		return flag;
	}

	@Override
	public int book_return(CheckOutVO vo) {
		// TODO Auto-generated method stub
		System.out.println("book_return(CheckOutVO vo)");
		System.out.println(vo.getCheckout_num());

		int flag = 0;
		flag = sqlSession.delete("book_return", vo);

		return flag;
	}

	@Override
	public List<CheckOutVO> book_admin_selectall(CheckOutVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckOutVO book_user_selectone(CheckOutVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CheckOutVO> checkoutList(CheckOutVO vo) {
		System.out.println("checkoutList(CheckOutVO vo)");
		
		List<CheckOutVO> list = sqlSession.selectList("checkoutList");
		System.out.println(vo.getUser_id());
		return list;
	}

}
