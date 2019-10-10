package test.com.spring02Menu.service;

import java.util.List;

import test.com.spring02Menu.model.MenuDAO;
import test.com.spring02Menu.model.MenuDAOimpl;
import test.com.spring02Menu.model.MenuVO;

public class MenuService {
	
	MenuDAO dao = new MenuDAOimpl();
	
	public int insert(MenuVO vo) {
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
