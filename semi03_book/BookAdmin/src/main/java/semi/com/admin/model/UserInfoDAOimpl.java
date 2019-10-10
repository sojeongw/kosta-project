package semi.com.admin.model;

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
	private SqlSession sqlSession;

	@Override
	public int user_login(UserInfoVO vo) {
	
		UserInfoVO uvo;
		
		uvo= sqlSession.selectOne("login",vo);
		
		int flag = 0;
		if(uvo != null)
			flag = 1;
		//else flag = 0;
		
		return flag;
	}


}
