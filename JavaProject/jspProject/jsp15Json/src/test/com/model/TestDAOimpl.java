package test.com.model;

import java.util.ArrayList;
import java.util.List;

public class TestDAOimpl implements TestDAO {

	@Override
	public TestVO json_selectOne(TestVO vo) {
		TestVO tvo = new TestVO();
		tvo.setName("sojeong");
		tvo.setAge(22);
		return tvo;
	}

	@Override
	public List<TestVO> json_selectAll() {
		List<TestVO> list = new ArrayList<>();
		TestVO vo = new TestVO();
		vo.setAge(11);
		vo.setName("kim");
		list.add(vo);
		list.add(vo);
		list.add(vo);
			
		return list;
	}


}
