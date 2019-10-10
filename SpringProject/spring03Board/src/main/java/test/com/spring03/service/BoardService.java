package test.com.spring03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.spring03.model.BoardDAO;
import test.com.spring03.model.BoardVO;


@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	

	public int insert(BoardVO vo) {
		return dao.insert(vo);
	}
	public int update(BoardVO vo) {
		return dao.update(vo);
	}
	public int delete(BoardVO vo) {
		return dao.delete(vo);
	}
	public BoardVO selectOne(BoardVO vo) {
		return dao.selectOne(vo);
	}
	public List<BoardVO> selectAll(){
		return dao.selectAll();
		
	}

}
