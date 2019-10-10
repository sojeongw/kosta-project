package test.com.service;

import test.com.model.StudentDAO;
import test.com.model.StudentDAOimpl;
import test.com.model.StudentVO;
import java.util.*;

public class StudentService {
	
	// 얘를 콜하면 실제로 dao에 있는 함수를 불러온 것 처럼 리턴을 받아야 한다 >> dao 객체 생성
	private StudentDAO dao = new StudentDAOimpl();
	

	public int insert(StudentVO vo) {
		return dao.insert(vo);
	}
	public int update(StudentVO vo) {
		return dao.update(vo);
	}
	public int delete(StudentVO vo) {
		return dao.delete(vo);
	}
	public StudentVO selectOne(StudentVO vo) {
		return dao.selectOne(vo);
	}
	public List<StudentVO> selectAll(){
		return dao.selectAll();
		
	}

}
