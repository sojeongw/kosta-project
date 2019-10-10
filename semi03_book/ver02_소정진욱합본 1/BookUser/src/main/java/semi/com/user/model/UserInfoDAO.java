package semi.com.user.model;

import java.util.List;

public interface UserInfoDAO {

	public int user_login(UserInfoVO vo);
	public int user_insert(UserInfoVO vo);
	public int user_update(UserInfoVO vo);
	public int user_delete(UserInfoVO vo);
	public UserInfoVO user_selectone(UserInfoVO vo);
	public int duplication_check(UserInfoVO vo);




}
