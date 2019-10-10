package test.com;

import java.util.ArrayList;
import java.util.List;

public class Test01DAOimpl implements Test01DAO {

	// Test01VO[] vos = new Test01VO[3];
	List<Test01VO> list = new ArrayList<Test01VO>();

	public Test01DAOimpl() {
		// main에 있던 걸 여기로 옯기면
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc succeeded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("jdbc failed");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Test01VO vo) {
		// TODO Auto-generated method stub
		System.out.println("insert()");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		int flag = 0;
		try {
			// vos[0] = vo; 0번 방이 아니게 됨
			list.add(vo);
			flag = 1;
		} catch (Exception e) {

		} finally {
			System.out.println("finally");
		}
		return flag;
	}

	@Override
	public List<Test01VO> selectAll() {
		System.out.println("selectAll()...");

		// 지역 변수를 하나 만들어서
		List<Test01VO> list = new ArrayList<Test01VO>();

		try {
			// 정상적일 때만 전역 변수를 담아서 리턴
			// vos = this.vos;
			list = this.list;

		} catch (Exception e) {
			list = null;
			System.out.println("에러");
		} finally {
			System.out.println("finally");
		}
		// return list; >> 리턴 타입이 안맞음 >> 리턴타입 수정하기
		return list;
	}

	@Override
	public int update(Test01VO vo) {
		System.out.println("update()");
		System.out.println(vo.getNum());
		System.out.println(vo.getName());
		int flag = 0;
		try {
			// vos[0] = vo; 0번 방이 아니게 됨
			list.set(vo.getNum()-1, vo);
			flag = 1;
		} catch (Exception e) {

		} finally {
			System.out.println("finally");
		}
		return flag;
	}
	
	public Test01VO selectOne(Test01VO vo) {
		System.out.println("selectOne()");
		System.out.println(vo.getNum());
		Test01VO vo2 = new Test01VO();
		try {
		vo2 = list.get(vo.getNum()-1);
		} catch(Exception e) {
			
		} finally {
			
		}
		return vo2;
	}

	@Override
	public int delete(Test01VO vo) {
		System.out.println("delete()");
		System.out.println(vo.getNum());
		int flag = 0;
		try {
			// vos[0] = vo; 0번 방이 아니게 됨
			list.remove(vo.getNum()-1);
			flag = 1;
		} catch (Exception e) {

		} finally {
			System.out.println("finally");
		}
		return flag;
	}

	

}
