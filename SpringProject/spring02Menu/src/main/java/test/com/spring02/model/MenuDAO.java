package test.com.spring02.model;

import java.util.List;

import test.com.spring02.model.MenuVO;

public interface MenuDAO {
	
	public int insert(MenuVO vo);
	public int delete(MenuVO vo);
	public int update(MenuVO vo);
	public MenuVO selectOne(MenuVO vo);
	public List<MenuVO> selectAll();

}
