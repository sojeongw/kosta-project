package test.semi.admin.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AdminDAOimpl implements AdminDAO {
	private static final Logger logger = LoggerFactory.getLogger(AdminDAOimpl.class);

	public List<AdminVO> list = new ArrayList<AdminVO>();
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(AdminVO vo) {
		logger.info("insert()..");
		int flag = 0;
		
		vo.setId("admin");
		flag = sqlSession.insert("insert",vo);
		
		return flag;
	}
	


	@Override
	public int update(AdminVO vo) {
		logger.info("update()..");
		int flag = 0;
		
		//vo.setReply("답변입니다.");
		
		flag = sqlSession.update("update",vo);
		return flag;
	}

	@Override
	public int delete(AdminVO vo) {
		logger.info("delete()..");
		int flag = 0;
		
		flag = sqlSession.delete("delete",vo);
		
		System.out.println(flag);
		return flag;
	}

	@Override
	public AdminVO selectOne(AdminVO vo) {
		logger.info("selectOne()..");
		
//		vo.setContent("안냐세요. 더 많은 지식을 알고시포요.");
//		vo.setWriter("writer 1");
		
		AdminVO avo = sqlSession.selectOne("selectOne",vo);

		System.out.println(vo.getBoard_num());
		System.out.println(vo.getContent());
		System.out.println(vo.getId());
		System.out.println(vo.getBoard_date());
		return avo;
	}

	

	@Override
	public List<AdminVO> selectAllmember() {
		System.out.println("selectAllmember()"+sqlSession);
		List<AdminVO> list = sqlSession.selectList("selectAllmember");

		return list;
	}

	@Override
	public AdminVO selectOnemember(AdminVO vo) {
		logger.info(vo.getId());
		AdminVO avo = sqlSession.selectOne("selectOnemember",vo);
		return avo;
	}

	@Override
	public int updateMember(AdminVO vo) {
	      logger.info("update()..");
	      int flag = 0;
	      logger.info("update().."+vo.getId());
	      flag = sqlSession.update("updateMember_info",vo);
	      flag = sqlSession.update("updateMember_pw",vo);
	      return flag;
	   }

	@Override
	public int deleteMember(AdminVO vo) {
		logger.info("deleteMember()...");
		int flag = 0;
		logger.info("deleteMember()");
		flag = sqlSession.delete("deleteMember", vo);
		return flag;
	}

	@Override
	public int updateGrade(AdminVO vo) {
		logger.info("updateGrade()..");
		int flag = 0;
		logger.info("updateGrade().."+vo.getId());
		flag = sqlSession.update("updateGrade",vo);
		return flag;
	}



	@Override
	public int login(AdminVO vo) {
		System.out.println("login(UserVO vo)...");
		int flag = 0;
		
		List<AdminVO> list = sqlSession.selectList("selectAll_login");
	
		System.out.println(1111111);
		
		for(int i = 0 ; i<list.size(); i ++)
		{

			if((vo.getId()).equals(list.get(i).getId()) == true && (vo.getPw()).equals(list.get(i).getPw()) == true) {
		
				
				System.out.println(vo.getId());
				System.out.println(vo.getPw());			
				vo.setProfile_pic(list.get(i).getProfile_pic());
				System.out.println(vo.getProfile_pic()+"@@@@@@@@@@@@");
				flag = 1;
				break;
			}
		}

		
		
		return flag;
	}

	@Override
	   public int rowCount() {
	      int countRow = sqlSession.selectOne("selectPage");
	      System.out.println(countRow);
	      return countRow;
	   }

	@Override
	public List<AdminVO> selectAllgrade() {
		List<AdminVO> list = sqlSession.selectList("selectAllgrade");
		return list;
	}

	@Override
	public List<AdminVO> selectAllmember(int startPage, int endPage) {
		System.out.println("selectAllmember()"+sqlSession);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("snum", startPage);
		map.put("enum", endPage);
		List<AdminVO> list = sqlSession.selectList("selectAllmember",map);
		System.out.println(list.size()+"<<<<<<<<<<<<<");
		return list;
	}
	
	@Override
	public List<AdminVO> selectAll(int startPage, int endPage) {
		System.out.println("selectAll()" + sqlSession);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("snum", startPage);
		map.put("enum", endPage);
		List<AdminVO> list = sqlSession.selectList("selectAll", map);
		System.out.println(list.size() + "<<<<<<<<<<<<<");
		return list;
	}
	
//	@Override
//	public List<AdminVO> selectAll() {
//		logger.info("selectAll()..");
//		
////		for (int i = 0; i < 5; i++) {
////			AdminVO vo = new AdminVO();
////			vo.setNum(i + 1);
////			vo.setContent("안냐세요. 더 많은 지식을 알고시포요.");
////			vo.setWriter("writer" + (i+1));
////			list.add(i, vo);
////		}
////		
////		for(int i=0; i<list.size(); i++) {
////			System.out.println(list.get(i).getNum());
////			System.out.println(list.get(i).getContent());
////			System.out.println(list.get(i).getWriter());
////			System.out.println(list.get(i).getReg_date());
////		}
//		
//		List<AdminVO> list = sqlSession.selectList("selectAll");
//		return list;
//	}
	
}
