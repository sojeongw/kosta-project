package test.com.spring01.service;

import java.util.List;

import test.com.spring01.model.TestDAO;
import test.com.spring01.model.TestDAOimpl;
import test.com.spring01.model.TestVO;

public class TestService {
	
	TestDAO dao = new TestDAOimpl();

	public int insert(TestVO vo) {
		return dao.insert(vo);
	}

	public TestVO selectOne(TestVO vo) {
		// TODO Auto-generated method stub
		return dao.selectOne(vo);
	}
	
	public List<TestVO> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	public int update(TestVO vo) {
		// TODO Auto-generated method stub
		return dao.update(vo);
	}

	public int delete(TestVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
