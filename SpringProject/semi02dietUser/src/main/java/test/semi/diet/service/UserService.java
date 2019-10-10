package test.semi.diet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import test.semi.diet.model.KcalVO;
import test.semi.diet.model.UserDAO;
import test.semi.diet.model.UserVO;


@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	public int insertMember(UserVO vo) {
		return dao.insertMember(vo);
	}
	public int login(UserVO vo) {
		
		return dao.login(vo);
	}
	
	public int up_info(UserVO vo){
		return dao.up_info(vo);
	}
	public int up_goal(UserVO vo) {
		return dao.up_goal(vo);
	}
	public int delete(UserVO vo){
		return dao.delete(vo);
	}

	public List<UserVO> selectAll(){
		return dao.selectAll();
	}

	public UserVO selectOne(UserVO vo){
		return dao.selectOne(vo);
	}
	public int insertUserkcal(KcalVO kvo) {
	
		return dao.insertUserkcal(kvo);
	}
	public List<KcalVO> selectAllUserkcal(KcalVO kvo) {
		return dao.selectAllUserkcal(kvo);
	}
	public int insert(UserVO vo) {

		return dao.insert(vo);
	}
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.update(vo);
	}
	
	
	///////////////////////////////////보드//////////////////////////
	
	public int deleteBoard_member(UserVO vo){
		return dao.deleteBoard_member(vo);
	}

	public UserVO selectOneBoard_member(UserVO vo){
		return dao.selectOneBoard_member(vo);
	}

	public int insertBoard_member(UserVO vo) {

		return dao.insertBoard_member(vo);
	}

	public List<UserVO> selectId(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.selectId(vo);
	}
	
	public List<UserVO> selectAllBoard_member(int startPage, int endPage) {
		return dao.selectAllBoard_member(startPage, endPage);
	}

	public int rowCount() {
		return dao.rowCount();
	}
	
	
	
}