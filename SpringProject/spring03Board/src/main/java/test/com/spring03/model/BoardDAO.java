package test.com.spring03.model;

import java.util.List;

import test.com.spring03.model.BoardVO;

public interface BoardDAO {
	
	public int insert(BoardVO vo);
	public int update(BoardVO vo);
	public int delete(BoardVO vo);
	public BoardVO selectOne(BoardVO vo);
	public List<BoardVO> selectAll();

}
