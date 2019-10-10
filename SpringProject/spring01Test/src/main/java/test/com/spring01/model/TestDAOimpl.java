package test.com.spring01.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDAOimpl implements TestDAO{

	private static final Logger logger = LoggerFactory.getLogger(TestDAOimpl.class);

	
	@Override
	public int insert(TestVO vo) {
		logger.info("insert()....");
		return 0;
	}

	@Override
	public TestVO selectOne(TestVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(TestVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(TestVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
