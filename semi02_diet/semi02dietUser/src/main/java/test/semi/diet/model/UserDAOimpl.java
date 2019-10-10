package test.semi.diet.model;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOimpl implements UserDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertMember(UserVO vo) {

		System.out.println("insertMember(UserVO vo).....");

		int flag = 0;
		flag = sqlSession.insert("insertMember", vo);
//		flag = sqlSession.insert("userkcal", vo);

		return flag;
	}

	@Override
	public int up_info(UserVO vo) {

		int flag = 0;

		flag = sqlSession.update("up_info", vo);

		return flag;

	}

	@Override
	public int login(UserVO vo) {
		System.out.println("login(UserVO vo)");
		int flag = 0;

		List<UserVO> list = sqlSession.selectList("selectAll");

		for (int i = 0; i < list.size(); i++) {

			if (vo.id.equals(list.get(i).id) == true && vo.pw.equals(list.get(i).pw) == true) {

				vo.name = list.get(i).name;
				vo.age = list.get(i).age;
				vo.gender = list.get(i).gender;
				vo.tel = list.get(i).tel;
				vo.height = list.get(i).height;
				vo.weight = list.get(i).weight;
				vo.goal = list.get(i).goal;
				flag = 1;
				break;
			}
		}

		return flag;
	}

	@Override
	public int up_goal(UserVO vo) {
		System.out.println("up_goal(UserVO vo)...");

		int flag = 0;
	
		flag = sqlSession.update("up_goal", vo);
		
		return flag;
	}

	@Override
	public int delete(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO selectOne(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> selectAll() {

		System.out.println("selectAll().....");

		List<UserVO> list = sqlSession.selectList("selectAll");

		return list;
	}

	@Override
	public int insertUserkcal(KcalVO kvo) {
		System.out.println("insertUserkcal()....."+kvo.getTotalkcal());
		int flag = 0;
		System.out.println("insertUserkccal(KcalVO kvo).....");
	
		flag = sqlSession.insert("insertUserkcal", kvo);
		
		return flag;
	}

	@Override
	public List<KcalVO> selectUserkcal(KcalVO kvo) {
		
		System.out.println("selectUserKcal()...");
		List<KcalVO> list = sqlSession.selectList("selectUserkcal",kvo);
		return list;
	}

	@Override
	public int insert(UserVO vo) {
		
		int flag = 0;

		flag = sqlSession.insert("insert",vo);
		
		return flag;
	}

	@Override
	public List<UserVO> selectBoardall() {
	
		System.out.println("selectBoardAll()..");
		
//		for (int i = 0; i < 5; i++) {
//			AdminVO vo = new AdminVO();
//			vo.setNum(i + 1);
//			vo.setContent("안냐세요. 더 많은 지식을 알고시포요.");
//			vo.setWriter("writer" + (i+1));
//			list.add(i, vo);
//		}
//		
		List<UserVO> list = sqlSession.selectList("selectBoardAll");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getNum());
			System.out.println(list.get(i).getContent());
			System.out.println(list.get(i).getWriter());
			System.out.println(list.get(i).getReg_date());
		}
		
	
		return list;
		

	}

}
