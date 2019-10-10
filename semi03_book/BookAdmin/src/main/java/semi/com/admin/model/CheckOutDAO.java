package semi.com.admin.model;

import java.util.List;

public interface CheckOutDAO {
	public int book_return_delete(CheckOutVO vo);
	public List<CheckOutVO> book_checkout_selectAll();
}
