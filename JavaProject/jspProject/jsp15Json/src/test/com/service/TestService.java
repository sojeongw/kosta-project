package test.com.service;

import java.util.List;

import test.com.model.TestDAO;
import test.com.model.TestDAOimpl;
import test.com.model.TestVO;

public class TestService {
	
	private TestDAO dao = new TestDAOimpl();
	
	public List<TestVO> json_selectAll(){
		return dao.json_selectAll();
	}
	
	public TestVO json_selectOne(TestVO vo) {
		return dao.json_selectOne(vo);
	}
	
}
