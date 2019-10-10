package project.model;

import java.util.List;

public interface LoginDAO {

	public LoginVO selectOne(LoginVO lvo);
	
	public List<LoginVO> selectAll();

}
