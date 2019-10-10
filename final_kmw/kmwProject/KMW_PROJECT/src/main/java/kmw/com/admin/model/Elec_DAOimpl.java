package kmw.com.admin.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Elec_DAOimpl implements Elec_DAO {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int updateElec(Elec_VO vo) {
		System.out.println("updateElec()..");
		int flag = sqlSession.update("updateElec", vo);
		return flag;
	}

	@Override
	public Elec_VO selectOneElec(Elec_VO vo) {
		System.out.println("selectOneElec()..");
		Elec_VO elecvo = sqlSession.selectOne("selectOneElec", vo);
		return elecvo;
	}

	@Override
	public List<Elec_VO> selectAllElec() {
		System.out.println("selectAllElec()..");
		List<Elec_VO> list = sqlSession.selectList("selectAllElec");
		return list;
	}
}
