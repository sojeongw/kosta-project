package kmw.com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kmw.com.admin.model.Elec_DAO;
import kmw.com.admin.model.Elec_VO;

@Service
public class Elec_Service {

	@Autowired
	private Elec_DAO dao;
	
	public int updateElec(Elec_VO vo) {
		return dao.updateElec(vo);
	}

	public Elec_VO selectOneElec(Elec_VO vo) {
		return dao.selectOneElec(vo);
	}

	public List<Elec_VO> selectAllElec() {
		return dao.selectAllElec();
	}
}
