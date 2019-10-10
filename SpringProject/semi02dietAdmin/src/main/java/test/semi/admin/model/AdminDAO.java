package test.semi.admin.model;

import java.util.List;

public interface AdminDAO {

	public int insert(AdminVO vo);
	public int update(AdminVO vo);
	public int delete(AdminVO vo);
	public AdminVO selectOne(AdminVO vo);
	public List<AdminVO> selectAll(int startPage, int endPage);
	public List<AdminVO> selectAllmember();
	public AdminVO selectOnemember(AdminVO vo);
	public int updateMember(AdminVO vo);
	public int deleteMember(AdminVO vo);
	public int updateGrade(AdminVO vo);
	public int login(AdminVO vo);
	public List<AdminVO> selectAllgrade();
	public List<AdminVO> selectAllmember(int startPage, int endPage);
	public int rowCount();
	
}
