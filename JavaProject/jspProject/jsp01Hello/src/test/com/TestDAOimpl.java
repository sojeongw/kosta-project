package test.com;

import java.util.ArrayList;
import java.util.List;

public class TestDAOimpl implements TestDAO {
	
	public TestDAOimpl() {
		try {
		Class.forName("test.com.TestVO");
		System.out.println("Driver complete");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	@Override
	public int insert(TestVO vo) {
		System.out.println("insert...");
		System.out.println(vo.getId());
		return 1;
	}

	@Override
	public int update(TestVO vo) {
		System.out.println("update start");
		vo.setNum(77);
		vo.setId("up id");
		vo.setPw("bbbb");
		vo.setName("cccc");
		vo.setTel("010");
		
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		
		
		
		return 1;
	}

	@Override
	public int delete(TestVO vo) {
		System.out.println("delete start");
		System.out.println(vo.getNum());
		return 1;
	}

	@Override
	public TestVO selectOne(TestVO vo) {
		System.out.println("selectOne start");
		System.out.println(vo.getNum());
		TestVO tvo = new TestVO();
		tvo.setNum(77);
		tvo.setId("SOaaaa");
		tvo.setPw("SObbbb");
		tvo.setName("cccc");
		tvo.setTel("010");
		return tvo;
	}


	@Override
	public List<TestVO> selectAll() {
		System.out.println("selectAll start");
		List<TestVO> list  = new ArrayList<TestVO>();
		TestVO vo = new TestVO();
		vo.setNum(77);
		vo.setId("aaaa");
		vo.setPw("bbbb");
		vo.setName("cccc");
		list.add(vo);
		list.add(new TestVO());
		list.add(new TestVO());
		return list;
	}

}
