package test.com.spring02Menu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAOimpl implements MenuDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "admin";
	private final String PASSWORD = "hi123456";

	private String sql_insert = "insert into menu(num, menu, price, store, kcal) values(seq_menu_num.nextval, ?, ?, ?, ?)";
	private String sql_select_all = "select * from menu order by num asc";
	private String sql_select_one = "select * from menu where num=?";
	private String sql_update = "update menu set menu = ?, price = ?, store = ?, kcal = ? where num = ?";
	private String sql_delete = "delete from menu where num = ?";

	public MenuDAOimpl() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("driver 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("driver 실패");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(MenuVO vo) {
		/*
		 * 1. System.out.println("insert(MenuVO vo)"); System.out.println(vo.getNum());
		 * System.out.println(vo.getMenu()); System.out.println(vo.getPrice());
		 * System.out.println(vo.getStore()); System.out.println(vo.getKcal());
		 * 
		 * return 1;
		 */

		int flag = 0;

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn 성공");

			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getMenu());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getStore());
			pstmt.setInt(4, vo.getKcal());

			flag = pstmt.executeUpdate();
			System.out.println("insert flag : " + flag);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return flag;
	}

	@Override
	public int delete(MenuVO vo) {
		System.out.println("delete(MenuVO vo)");
		System.out.println(vo.getNum());
		
		int flag = 0;

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn 성공");

			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, vo.getNum());

			flag = pstmt.executeUpdate();
			System.out.println("delete flag : " + flag);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
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

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn 성공");

			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getMenu());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getStore());
			pstmt.setInt(4, vo.getKcal());
			pstmt.setInt(5, vo.getNum());

			flag = pstmt.executeUpdate();
			System.out.println("insert flag : " + flag);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return flag;
	}

	@Override
	public MenuVO selectOne(MenuVO vo) {
		System.out.println("selectOne(MenuVO vo)");
		System.out.println(vo.getNum());

		MenuVO mvo = new MenuVO();

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn 성공");

			pstmt = conn.prepareStatement(sql_select_one);
			pstmt.setInt(1, vo.getNum());

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				mvo.setNum(rs.getInt("num"));
				mvo.setMenu(rs.getString("menu"));
				mvo.setPrice(rs.getInt("price"));
				mvo.setStore(rs.getString("store"));
				mvo.setKcal(rs.getInt("kcal"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return mvo;
	}

	@Override
	public List<MenuVO> selectAll() {
		System.out.println("selectAll()");
		List<MenuVO> list = new ArrayList<MenuVO>();

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn 성공");

			pstmt = conn.prepareStatement(sql_select_all);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MenuVO vo = new MenuVO();
				vo.setNum(rs.getInt("num"));
				vo.setMenu(rs.getString("menu"));
				vo.setPrice(rs.getInt("price"));
				vo.setStore(rs.getString("store"));
				vo.setKcal(rs.getInt("kcal"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}
}
