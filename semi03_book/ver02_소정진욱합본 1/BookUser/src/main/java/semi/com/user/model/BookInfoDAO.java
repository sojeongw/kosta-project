package semi.com.user.model;

import java.util.List;

public interface BookInfoDAO {

	public int book_insert(BookInfoVO vo);
	public int book_update(BookInfoVO vo);
	public int book_delete(BookInfoVO vo);
	public BookInfoVO book_selectone(BookInfoVO vo);
	public List<BookInfoVO> book_selectall(BookInfoVO vo);
	public List<UserInfoVO> checkoutList(UserInfoVO vo);
	public int book_changeTF(BookInfoVO vo);

}
