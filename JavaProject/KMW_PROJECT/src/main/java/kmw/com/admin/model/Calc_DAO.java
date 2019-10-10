package kmw.com.admin.model;

import java.util.List;

public interface Calc_DAO {

	public int insertCalc(Calc_VO vo);

	public int updateCalc(Calc_VO vo);

	public Calc_VO selectOneCalc(Calc_VO vo);

	public List<Calc_VO> selectAllCalc();

}
