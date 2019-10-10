package semi.com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.com.user.model.BookInfoDAO;
import semi.com.user.model.BookInfoVO;
import semi.com.user.model.UserInfoVO;

@Service
public class BookInfoService {
	
	@Autowired
	private BookInfoDAO dao;

	
	public int book_insert(BookInfoVO vo) {
		// TODO Auto-generated method stub
		return dao.book_insert(vo);
	}

	
	public int book_update(BookInfoVO vo) {
		// TODO Auto-generated method stub
		return dao.book_update(vo);
	}

	
	public int book_delete(BookInfoVO vo) {
		// TODO Auto-generated method stub
		return dao.book_delete(vo);
	}

	
	public BookInfoVO book_selectone(BookInfoVO vo) {
		// TODO Auto-generated method stub
		return dao.book_selectone(vo);
	}

	
	public List<BookInfoVO> book_selectall(BookInfoVO vo) {
		// TODO Auto-generated method stub
		return dao.book_selectall(vo);
	}


	
	
}
