package test.semi.diet.model;

import java.util.HashMap;
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
		System.out.println("flag1: "+flag);
		flag = sqlSession.insert("insertMember2", vo);
		System.out.println("flag2: "+flag);
		flag = sqlSession.insert("insertMember3", vo);
		System.out.println("flag3: "+flag);

		return flag;
	}

	@Override
	public int up_info(UserVO vo) {

		int flag = 0;

		flag = sqlSession.update("up_info", vo);
		flag = sqlSession.update("up_info2", vo);
		flag = sqlSession.update("up_info3", vo);
		
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
				vo.profile_pic = list.get(i).profile_pic;
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
	public UserVO selectOne(UserVO vo) {
		
		System.out.println(vo.getNum());
		UserVO uvo = sqlSession.selectOne("selectOne", vo);
				
		return uvo;
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
	public int update(UserVO vo) {
		int flag = 0;
		flag = sqlSession.update("updateBoard_member", vo);
		return flag;
	}

	@Override
	public int delete(UserVO vo) {
		int flag = 0;
		flag = sqlSession.delete("deleteBoard_member", vo);
		return flag;
	}
	
	@Override
	public int insertBoard_member(UserVO vo) {
		int flag = 0;
		flag = sqlSession.insert("insertBoard_member", vo);
		return flag;
	}

	@Override
	public int deleteBoard_member(UserVO vo) {
		int flag = 0;
		flag = sqlSession.delete("deleteBoard_member", vo);
		return flag;
	}

	@Override
	public UserVO selectOneBoard_member(UserVO vo) {
		
		
		UserVO uvo = sqlSession.selectOne("selectOneBoard_member", vo);
		return uvo;
	}

	@Override
	public int updateUserkcal(KcalVO kvo) {
		int flag = 0;
		flag = sqlSession.update("updateUserkcal", kvo);
		return flag;
	}


	@Override
	public List<KcalVO> selectAllUserkcal(KcalVO kvo) {

		System.out.println("selectAllUserKcal()...");
		List<KcalVO> list = sqlSession.selectList("selectAllUserkcal", kvo);
		return list;
	}
	
	@Override
	public List<UserVO> selectId(UserVO vo) {
		System.out.println("selectId...");
		List<UserVO> list = sqlSession.selectList("selectId", vo);
		return list;
	}
	
	@Override
	public List<UserVO> selectAllBoard_member(int startPage, int endPage) {
		System.out.println("selectAllBoard_member()" + sqlSession);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("snum", startPage);
		map.put("enum", endPage);
		List<UserVO> list = sqlSession.selectList("selectAllBoard_member", map);
		System.out.println(list.size() + "<<<<<<<<<<<<<");
		return list;
	}
	

	@Override
	public int rowCount() {
		int countRow = sqlSession.selectOne("selectPage");
		System.out.println(countRow);
		return countRow;
	}


}
