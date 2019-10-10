package semi.com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.com.user.model.UserInfoDAO;
import semi.com.user.model.UserInfoVO;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoDAO dao;


	public int user_login(UserInfoVO vo) {
		// TODO Auto-generated method stub
		return dao.user_login(vo);
	}


	public int user_insert(UserInfoVO vo) {
		// TODO Auto-generated method stub
		return dao.user_insert(vo);
	}


	public int user_update(UserInfoVO vo) {
		// TODO Auto-generated method stub
		return dao.user_update(vo);
	}


	public int user_delete(UserInfoVO vo) {
		// TODO Auto-generated method stub
		return dao.user_delete(vo);
	}
	
	
}
