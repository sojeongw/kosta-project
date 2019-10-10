package semi.com.user.model;

public interface UserInfoDAO {

	public int user_login(UserInfoVO vo);
	public int user_insert(UserInfoVO vo);
	public int user_update(UserInfoVO vo);
	public int user_delete(UserInfoVO vo);
	
}
