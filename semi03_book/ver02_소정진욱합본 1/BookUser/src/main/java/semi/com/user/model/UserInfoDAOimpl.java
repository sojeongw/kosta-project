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
	
		UserInfoVO uvo;
		
		uvo= sqlSession.selectOne("login",vo);
		
		int flag = 0;
		if(uvo != null)
			flag = 1;
		else flag = 0;
		
		return flag;
	}

	@Override
	public int user_insert(UserInfoVO vo) {
	
		System.out.println("insertUser(UserVO vo).....");

		System.out.println(vo.getUser_id());
		System.out.println(vo.getUser_pw());
		System.out.println(vo.getUser_name());
		System.out.println(vo.getUser_tel());
		System.out.println(vo.getUser_email());
		System.out.println(vo.getUser_address());
			
		
		int flag = 0;
		flag = sqlSession.insert("insertUser", vo);
		
		return flag;
	}

	@Override
	public int user_update(UserInfoVO vo) {
	System.out.println("updateUser(UserVO vo).....");
		
		int flag = 0;
		flag = sqlSession.update("updateUser", vo);
		
		return flag;
	}

	@Override
	public int user_delete(UserInfoVO vo) {
		System.out.println("deleteUser(UserVO vo).....");
		int flag = 0;
		flag = sqlSession.delete("deleteUser", vo);
		
		return flag;
	}

	@Override
	public UserInfoVO user_selectone(UserInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println(vo.getUser_id());
		UserInfoVO uvo;
		
		uvo = sqlSession.selectOne("user_selectone",vo);
		
		
		
		if(uvo != null)
		return uvo;
		else {
		System.out.println("selectOne 실패");
			return null;
		}
	}

	@Override
	public int duplication_check(UserInfoVO vo) {
		int flag = 0;
		UserInfoVO dvo;
		
		dvo = sqlSession.selectOne("duplication_check",vo);
		
		if(dvo == null)
			flag =1;
		else
			flag = 0;
		
		return flag;
	}

	
	

}
