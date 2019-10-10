package semi.com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semi.com.user.model.CheckOutDAO;
import semi.com.user.model.CheckOutVO;

@Service
public class CheckOutService {
	
	@Autowired
	private CheckOutDAO dao;

	
	public int book_register(CheckOutVO vo) {
		// TODO Auto-generated method stub
		return dao.book_register(vo);
	}

	
	public int book_return(CheckOutVO vo) {
		// TODO Auto-generated method stub
		return dao.book_return(vo);
	}

	
	public List<CheckOutVO> book_admin_selectall(CheckOutVO vo) {
		// TODO Auto-generated method stub
		return dao.book_admin_selectall(vo);
	}

	
	public CheckOutVO book_user_selectone(CheckOutVO vo) {
		// TODO Auto-generated method stub
		return dao.book_user_selectone(vo);
	}

	
}
