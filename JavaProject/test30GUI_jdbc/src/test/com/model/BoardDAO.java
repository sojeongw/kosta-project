package test.com.model;

import java.util.List;

public interface BoardDAO {
	
	public int insert(BoardVO bvo);	
	public int update(BoardVO bvo);
	public int delete(BoardVO bvo);
	public BoardVO selectOne(BoardVO bvo);
	public List<BoardVO>  selectAll();


}
