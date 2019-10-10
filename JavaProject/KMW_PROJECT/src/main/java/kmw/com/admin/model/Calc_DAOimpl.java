package kmw.com.admin.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Calc_DAOimpl implements Calc_DAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insertCalc(Calc_VO vo) {
		System.out.println("insertCalc()..");	
		
		int flag = sqlSession.insert("insertCalc", vo);
		
		return flag;
	}

	@Override
	public int updateCalc(Calc_VO vo) {
		System.out.println("updateCalc()..");		
		
		int flag = sqlSession.update("updateCalc", vo);
		
		return flag;
	}

	@Override
	public Calc_VO selectOneCalc(Calc_VO vo) {
		System.out.println("selectOneCalc()..");		

		Calc_VO calcvo = sqlSession.selectOne("selectOneCalc", vo);
		
		return calcvo;
	}

	@Override
	public List<Calc_VO> selectAllCalc() {
		System.out.println("selectAllCalc()..");		
		
		List<Calc_VO> list = sqlSession.selectList("selectAllCalc");
		
		return list;
	}

}
