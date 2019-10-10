package test.semi.diet.model;

import java.util.*;

public interface UserDAO {

	public int insertMember(UserVO vo);
	
	public int insertUserkcal(KcalVO kvo);
	
	public int login(UserVO vo);
	
	public int up_info(UserVO vo);
	
	public int up_goal(UserVO vo);
	
	public int delete(UserVO vo);
	
	UserVO selectOne(UserVO vo);
	
	List<UserVO> selectAll();

	public List<KcalVO> selectUserkcal(KcalVO kvo);

	public int insert(UserVO vo);
	
	public List<UserVO> selectBoardall();
	
	
	
}
