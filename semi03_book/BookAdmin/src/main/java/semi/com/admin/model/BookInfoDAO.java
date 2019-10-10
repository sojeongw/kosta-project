package semi.com.admin.model;

import java.util.List;

public interface BookInfoDAO {
	public int book_insert(BookInfoVO vo);
	public int book_update(BookInfoVO vo);
	public int book_delete(BookInfoVO vo);
	public int book_return(BookInfoVO vo);//다이어그램과 다름
	public List<BookInfoVO> book_selectAll();// 다이어그램과 다름
	
}
