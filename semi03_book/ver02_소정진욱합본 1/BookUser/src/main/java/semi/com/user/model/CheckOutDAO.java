package semi.com.user.model;

import java.util.List;

public interface CheckOutDAO {

	public int book_register(CheckOutVO vo);
	public int book_return(CheckOutVO vo);
	public List<CheckOutVO> book_admin_selectall(CheckOutVO vo);
	public CheckOutVO book_user_selectone(CheckOutVO vo);
	public List<CheckOutVO> checkoutList(CheckOutVO vo);


}
