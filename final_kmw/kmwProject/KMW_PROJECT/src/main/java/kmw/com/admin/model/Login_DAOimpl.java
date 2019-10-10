package kmw.com.admin.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Login_DAOimpl implements Login_DAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public Login_VO LoginSelectOne(Login_VO vo) {
		Login_VO login_vo = sqlSession.selectOne("LoginSelectOne", vo);
		return login_vo;
	}

	@Override
	public Login_VO AndroidLoginSelectOne(Login_VO vo) {
		Login_VO login_vo = sqlSession.selectOne("AndroidLoginSelectOne", vo);
		return login_vo;
	}


}
