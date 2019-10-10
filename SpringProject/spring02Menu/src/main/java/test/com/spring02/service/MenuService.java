package test.com.spring02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.spring02.model.MenuDAO;
import test.com.spring02.model.MenuVO;

@Service
public class MenuService {

	// 얘를 콜하면 실제로 dao에 있는 함수를 불러온 것 처럼 리턴을 받아야 한다 >> dao 객체 생성
	// private MenuDAO dao = new MenuDAOimpl();
	// 이제 어노테이션으로 대체
	@Autowired
	private MenuDAO dao;

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

	public List<MenuVO> selectAll() {
		return dao.selectAll();
	}

}
