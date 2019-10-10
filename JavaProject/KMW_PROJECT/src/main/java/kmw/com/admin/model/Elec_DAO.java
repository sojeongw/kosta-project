package kmw.com.admin.model;

import java.util.List;

public interface Elec_DAO {

	public int updateElec(Elec_VO vo);

	public Elec_VO selectOneElec(Elec_VO vo);

	public List<Elec_VO> selectAllElec();

}
