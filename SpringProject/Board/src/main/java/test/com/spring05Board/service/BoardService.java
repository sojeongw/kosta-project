package test.com.spring05Board.service;

import test.com.spring05Board.model.BoardDAO;
import test.com.spring05Board.model.BoardDAOimpl;
import test.com.spring05Board.model.BoardVO;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
