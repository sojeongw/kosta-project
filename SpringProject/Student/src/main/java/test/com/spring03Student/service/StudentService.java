package test.com.spring03Student.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.spring03Student.model.StudentDAO;
import test.com.spring03Student.model.StudentVO;

@Service
public class StudentService {
	
	@Autowired
	private StudentDAO dao;
	

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
