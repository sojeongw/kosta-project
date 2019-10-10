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
public class UserInfoDAOimpl implements UserInfoDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserInfoDAOimpl.class);

	@Autowired
	SqlSession sqlSession;

	@Override
	public int user_login(UserInfoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int user_insert(UserInfoVO vo) {
	
		System.out.println("insertMember(UserVO vo).....");

		int flag = 0;
		flag = sqlSession.insert("insertUser", vo);
		
		return 0;
	}

	@Override
	public int user_update(UserInfoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int user_delete(UserInfoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
