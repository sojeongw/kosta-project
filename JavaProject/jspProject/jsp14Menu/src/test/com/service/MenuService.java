package test.com.service;

import java.util.List;

import test.com.model.MenuDAO;
import test.com.model.MenuDAOimpl;
import test.com.model.MenuVO;

public class MenuService {
	
	// 얘를 콜하면 실제로 dao에 있는 함수를 불러온 것 처럼 리턴을 받아야 한다 >> dao 객체 생성
	private MenuDAO dao = new MenuDAOimpl();
	
	
	// 절대 dao를 상속받으면 안 된다. 그냥 복사해서 붙여넣는다.
	public int insert(MenuVO vo) {
		// 그냥 이렇게 콜만 해준다.
		return dao.insert(vo);
	}
	
	public int delete(MenuVO vo) {
		return dao.delete(vo);
	}
	
	public int update(MenuVO vo) {
		return dao.update(vo);
	}
	
	public MenuVO selectOne(MenuVO vo) {
		return dao.selectOne(vo);
	}
	
	public List<MenuVO> selectAll(){
		return dao.selectAll();
	}

}
