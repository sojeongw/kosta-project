package test.com.spring01.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.com.spring01.MenuController;

@Repository
public class MenuDAOimpl implements MenuDAO {

	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	SqlSession sqlSession;
	// 지금은 아직 null 값. 이렇게 써주면 sql이 세팅된다.
	// autowired했는데 에러가 나면 걔가 등록이 안 되어있는 상태임.
	
	/*생성된 bean을 주입시켜주는 게 dependency injection 
	이런 개념을 IOC라고 한다. 기존 코딩하는 방식의 반대로 하는 것. 
	이 오브젝트가 필요해서 new 하면 기존 방식이고
	스프링에서는 그 반대로 먼저 new해놓고 bean 만들어 놓고 나서
	필요할 때만 injection받아서 사용한다. = 제어의 역전 inversion of control = IOC
	>> 이제 우리는 bean을 만들 줄 알아야 한다.
	중요 키워드 : IOC, BEAN, AOP */
	
	/*private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;*/
	
	/*private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "admin";
	private final String PASSWORD = "hi123456";*/

	// sqlMapper로 이동
	/*private String sql_insert = "insert into menu(num, menu, price, store, kcal) values(seq_menu_num.nextval, ?, ?, ?, ?)";
	private String sql_select_all = "select * from menu order by num asc";
	private String sql_select_one = "select * from menu where num=?";
	private String sql_update = "update menu set menu = ?, price = ?, store = ?, kcal = ? where num = ?";
	private String sql_delete = "delete from menu where num = ?";*/

	/*public MenuDAOimpl() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("driver 실패");
			e.printStackTrace();
		}
	}*/

	@Override
	public int insert(MenuVO vo) {
		/*
		 * 1. System.out.println("insert(MenuVO vo)"); System.out.println(vo.getNum());
		 * System.out.println(vo.getMenu()); System.out.println(vo.getPrice());
		 * System.out.println(vo.getStore()); System.out.println(vo.getKcal());
		 * 
		 * return 1;
		 */
		
		logger.info("num : " + vo.getNum());
		logger.info("menu : " + vo.getMenu());
		logger.info("price : " + vo.getPrice());
		logger.info("store : " + vo.getStore());
		logger.info("kcal : " + vo.getKcal());

		int flag = 0;

		// 내가 찾아가야될 sql 아이디 + 넘겨줄 데이터
		flag = sqlSession.insert("insert", vo);
		
		
		return flag;
	}

	@Override
	public int delete(MenuVO vo) {
		System.out.println("delete(MenuVO vo)");
		System.out.println(vo.getNum());
		
		int flag = 0;
		
		flag = sqlSession.delete("delete", vo);
		
		return flag;
	}

	@Override
	public int update(MenuVO vo) {
		/*System.out.println("update(MenuVO vo)");
		System.out.println(vo.getNum());
		System.out.println(vo.getMenu());
		System.out.println(vo.getPrice());
		System.out.println(vo.getStore());
		System.out.println(vo.getKcal());*/
		
		int flag = 0;
		flag = sqlSession.insert("update", vo);
		
		
		return flag;
	}

	@Override
	public MenuVO selectOne(MenuVO vo) {
		System.out.println("selectOne(MenuVO vo)");
		System.out.println(vo.getNum());
		MenuVO mvo = sqlSession.selectOne("selectOne", vo);
		return mvo;
	}

	@Override
	public List<MenuVO> selectAll() {
		System.out.println("selectAll()");
		List<MenuVO> list = sqlSession.selectList("selectAll");
		return list;
	}
}
