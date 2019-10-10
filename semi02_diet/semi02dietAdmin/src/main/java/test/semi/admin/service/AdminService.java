package test.semi.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.semi.admin.model.*;

@Service
public class AdminService {

	@Autowired
	private AdminDAO dao;

	public int insert(AdminVO vo) {

		return dao.insert(vo);
	}

	public int update(AdminVO vo) {
		return dao.update(vo);
	}

	public int delete(AdminVO vo) {
		return dao.delete(vo);
	}

	public AdminVO selectOne(AdminVO vo) {
		return dao.selectOne(vo);
	}

	public List<AdminVO> selectAll() {
		return dao.selectAll();
	}

	public List<AdminVO> selectAllmember() {
		return dao.selectAllmember();
	}

	public AdminVO selectOnemember(AdminVO vo) {
		return dao.selectOnemember(vo);
	}

	public int updateMember(AdminVO vo) {
		return dao.updateMember(vo);
	}

	public int deleteMember(AdminVO vo) {
		return dao.deleteMember(vo);
	}

	public int updateGrade(AdminVO vo) {
		return dao.updateGrade(vo);
	}

	public int login(AdminVO vo) {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}

	public List<AdminVO> selectAllgrade() {
		// TODO Auto-generated method stub
		return dao.selectAllgrade();
	}

}
