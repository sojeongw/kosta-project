package kmw.com.admin.model;

import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Ctrl_DAOimpl implements Ctrl_DAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int updateMotion(Ctrl_VO vo) {
		int flag = sqlSession.update("updateMotion",vo);

		return flag;
	}

	@Override
	public int updateAngle(Ctrl_VO vo) {
		 int flag = sqlSession.update("updateAngle",vo);
		  
		 return flag;
	}

	@Override
	public int updateStart_time(Ctrl_VO vo) {
		 int flag = sqlSession.update("updateStart_time",vo);
		  
		 return flag;
	}

	@Override
	public int updateEnd_time(Ctrl_VO vo) {
		 int flag = sqlSession.update("updateEnd_time",vo);
		  
		 return flag;
	}

	
}
