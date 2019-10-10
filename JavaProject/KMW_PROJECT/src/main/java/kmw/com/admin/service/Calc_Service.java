package kmw.com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kmw.com.admin.model.Calc_DAO;
import kmw.com.admin.model.Calc_VO;

@Service
public class Calc_Service {

	@Autowired
	private Calc_DAO dao;

	public int insertCalc(Calc_VO vo) {
		System.out.println("insertCalc()...");
		
		return dao.insertCalc(vo);
	}
	
	public int updateCalc(Calc_VO vo) {
		System.out.println("updateCalc()...");

		return dao.updateCalc(vo);
	}
	
	public Calc_VO selectOneCalc(Calc_VO vo) {
		System.out.println("selectOneCalc()...");

		return dao.selectOneCalc(vo);
	}
	
	public List<Calc_VO> selectAllCalc() {
		System.out.println("selectAll()...");

		
		return dao.selectAllCalc();
	}
}
