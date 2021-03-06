package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class boardDAOimpl implements boardDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public boardDAOimpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc driver successed");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver failed");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(boardVO vo) {
		System.out.println("insert(boardVO vo)");

		int flag = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn complete..");

			String sql = "insert into board(num, title, content, writer) values(seq_board_num.nextval, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());

			// test
			System.out.println(vo.getNum());
			System.out.println(vo.getTitle());
			System.out.println(vo.getContent());
			System.out.println(vo.getWriter());
			System.out.println(vo.getReg_Date());

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insert failed..");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
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

		return flag;
	}

	@Override
	public int update(boardVO vo) {
		System.out.println("update(boardVO vo)");
		int flag = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn complete..");

			String sql = "update board set title = ?, content = ?, writer = ? where num = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getNum());

			// test
			System.out.println(vo.getNum());
			System.out.println(vo.getTitle());
			System.out.println(vo.getContent());
			System.out.println(vo.getWriter());
			System.out.println(vo.getReg_Date());

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update failed..");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
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

		return flag;
	}

	@Override
	public int delete(boardVO vo) {
		System.out.println("delete(boardVO vo)");
		int flag = 0;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn complete");

			String sql = "delete from board where num = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("delete failed...");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
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
		return flag;
	}

	@Override
	public boardVO selectOne(boardVO vo) {
		System.out.println("selectOne(boardVO vo)");
		boardVO bvo = new boardVO();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn succeeded..");

			String sql = "select * from board where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());

			rs = pstmt.executeQuery();
			// System.out.println("selectOne rs:" + rs);

			while (rs.next()) {
				bvo.setNum(rs.getInt("num"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContent(rs.getString("content"));
				bvo.setWriter(rs.getString("writer"));
				bvo.setReg_Date(rs.getDate("reg_date"));
			}
		} catch (Exception e) {
			System.out.println("selectOne failed");
			e.printStackTrace();
		}
		return bvo;
	}

	@Override
	public List<boardVO> selectAll() {
		System.out.println("selectAll()");
		List<boardVO> list = new ArrayList<>();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "board", "hi123456");
			System.out.println("conn succeeded..");

			String sql = "select * from board";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			// System.out.println("selectAll rs:" + rs);

			while (rs.next()) {
				// System.out.println(99);

				boardVO vo = new boardVO();
				vo.setNum(rs.getInt("num"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReg_Date(rs.getDate("reg_date"));

				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("error");
		} finally {
			if (rs != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
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
