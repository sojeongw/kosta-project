package test.com.service;

import test.com.model.BoardDAO;
import test.com.model.BoardDAOimpl;
import test.com.model.BoardVO;
import java.util.*;

public class BoardService {
	
	// 얘를 콜하면 실제로 dao에 있는 함수를 불러온 것 처럼 리턴을 받아야 한다 >> dao 객체 생성
	private BoardDAO dao = new BoardDAOimpl();
	

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
