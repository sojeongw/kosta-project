package semi.com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import semi.com.admin.model.BookInfoDAO;
import semi.com.admin.model.BookInfoVO;
import semi.com.admin.model.CheckOutDAO;
import semi.com.admin.model.CheckOutVO;
import semi.com.admin.model.UserInfoDAO;
import semi.com.admin.model.UserInfoVO;

@Service
public class AdminService {

	@Autowired
	private BookInfoDAO bdao;
	@Autowired
	private CheckOutDAO cdao;
	@Autowired
	private UserInfoDAO udao;

	public int book_insert(BookInfoVO vo) {

		return bdao.book_insert(vo);
	}
	
	public int book_delete(BookInfoVO vo) {

		return bdao.book_delete(vo);
	}
	
	public int book_return(BookInfoVO vo) {

		return bdao.book_return(vo);
	}

	public List<BookInfoVO> book_selectAll() {

		return bdao.book_selectAll();
	}
	
	public int book_update(BookInfoVO vo) {

		return bdao.book_update(vo);
		
	}
	
	public List<CheckOutVO> book_checkout_selectAll() {

		return cdao.book_checkout_selectAll();
	}
	
	public int book_return_delete(CheckOutVO vo) {

		return cdao.book_return_delete(vo);
	}
	
	public int user_login(UserInfoVO vo) {
		
		return udao.user_login(vo);
	}
}
