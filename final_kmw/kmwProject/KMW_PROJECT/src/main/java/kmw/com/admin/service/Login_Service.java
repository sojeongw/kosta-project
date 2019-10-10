package kmw.com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kmw.com.admin.model.Login_DAO;
import kmw.com.admin.model.Login_VO;

@Service
public class Login_Service {

	@Autowired
	private Login_DAO dao;

	public Login_VO LoginSelectOne(Login_VO vo) {
		System.out.println("LoginSelectOne()..");
		return dao.LoginSelectOne(vo);
	}
	
	public Login_VO AndroidLoginSelectOne(Login_VO vo) {
		System.out.println("AndroidLoginSelectOne()..");
		return dao.AndroidLoginSelectOne(vo);
	}



}
