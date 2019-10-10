package kmw.com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kmw.com.admin.model.Ctrl_DAO;
import kmw.com.admin.model.Ctrl_VO;

@Service
public class Ctrl_Service {

	@Autowired
	private Ctrl_DAO dao;
	
	/*public int updateName(Ctrl_VO vo) {
		return dao.updateName(vo);
	}*/

	public int updateMotion(Ctrl_VO vo) {
		return dao.updateMotion(vo);
	}

	public int updateAngle(Ctrl_VO vo) {
		return dao.updateAngle(vo);
	}
	
	public int updateStart_time(Ctrl_VO vo) {
		return dao.updateStart_time(vo);
	}
	
	public int updateEnd_time(Ctrl_VO vo) {
		return dao.updateEnd_time(vo);
	}
	
}
