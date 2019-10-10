package test.com;

import java.util.List;

public interface boardDAO {
	
	public int insert(boardVO vo);
	public int update(boardVO vo);
	public int delete(boardVO vo);
	public boardVO selectOne(boardVO vo);
	public List<boardVO> selectAll();

}
