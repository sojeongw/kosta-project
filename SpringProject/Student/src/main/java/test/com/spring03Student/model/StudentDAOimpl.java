package test.com.spring03Student.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOimpl implements StudentDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insert(StudentVO vo) {
		System.out.println("insert(studentVO vo)");
		
		int flag = sqlSession.insert("insert", vo);
		
		return flag;
	}

	@Override
	public int update(StudentVO vo) {
		System.out.println("update(studentVO vo)");
		
		
		
		int flag = sqlSession.update("update", vo);
		
		return flag;
	}

	@Override
	public int delete(StudentVO vo) {
		System.out.println("delete(studentVO vo)");
		int flag = sqlSession.delete("delete", vo);
		return flag;
	}

	@Override
	public StudentVO selectOne(StudentVO vo) {
		System.out.println("selectOne(studentVO vo)");
		StudentVO svo = sqlSession.selectOne("selectOne", vo);
		return svo;
	}

	@Override
	public List<StudentVO> selectAll() {
		System.out.println("selectAll()");
		List<StudentVO> list = sqlSession.selectList("selectAll");

		return list;
	}

}
